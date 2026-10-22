package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.BattleChorusResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.n7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class BattleChorusMethod extends wy0.b<n7, BattleChorusResultModel> {
    public final Type a;
    public final x11.a b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/BattleChorusMethod$BattleChorusType;", "", "", "type", "I", "getType", "()I", "OpenChorus", "CloseChorus", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleChorusType extends Enum<BattleChorusType> {
        public static final BattleChorusType CloseChorus = null;
        public static final BattleChorusType OpenChorus = null;
        public static final /* synthetic */ BattleChorusType[] a = null;
        private final int type;

        static {
            BattleChorusType r2 = new BattleChorusType("OpenChorus", 0, 1);
            OpenChorus = r2;
            BattleChorusType r3 = new BattleChorusType("CloseChorus", 1, 2);
            CloseChorus = r3;
            a = new BattleChorusType[]{r2, r3};
        }

        public static BattleChorusType valueOf(String r1) {
            return (BattleChorusType) r27.a.a(BattleChorusType.class, r1);
        }

        public static BattleChorusType[] values() {
            return (BattleChorusType[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public BattleChorusType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public BattleChorusMethod(x11.a r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(n7.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r3, CallContext r4) {
        n7 r5 = (n7) r3;
        Intrinsics.checkNotNullParameter(r5, "param");
        Intrinsics.checkNotNullParameter(r4, "callContext");
        int r6 = r5.getType();
        Long r0 = null;
        if (r6 != BattleChorusType.OpenChorus.getType()) goto L13;
        x11.a r7 = this.b;
        if (r7 == null) goto L9;
        y11.f r8 = r7.G9();
        if (r8 == null) goto L9;
        r0 = Long.valueOf(r8.a());
    L9:
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).b(er2.b.class);
        Intrinsics.checkNotNull(r10);
        iq2.b r12 = ((com.bytedance.live.kmp.core.c) r10).getChorusService();
        if (r12 == null) goto L22;
        r12.f(String.valueOf(r0));
    L22:
        BattleChorusResultModel r13 = new BattleChorusResultModel();
        r13.a(BattleChorusResultModel.Code.Success);
        finishWithResult(r13);
        return;
    L13:
        if (r6 != BattleChorusType.CloseChorus.getType()) goto L22;
        x11.a r14 = this.b;
        if (r14 == null) goto L19;
        y11.f r15 = r14.G9();
        if (r15 == null) goto L19;
        r0 = Long.valueOf(r15.a());
    L19:
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).b(er2.b.class);
        Intrinsics.checkNotNull(r17);
        iq2.b r18 = ((com.bytedance.live.kmp.core.c) r17).getChorusService();
        if (r18 == null) goto L22;
        r18.a(String.valueOf(r0));
        goto L22
    }
}
