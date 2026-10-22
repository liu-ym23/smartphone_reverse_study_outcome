package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n extends wy0.b<a, b> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    @JsonAdapter(InvitePkMethod_ParamsSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/n$a;", "Lvh7/j;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface a extends vh7.j<a> {

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.jsb.n$a$a, reason: collision with other inner class name */
        @JsonAdapter(InvitePkMethod_ParamsSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C0125a {
        }

        @FieldName(name = "sec_to_user_id")
        String L2();

        @FieldName(name = "battle_config_setting")
        String getBattleConfigSetting();

        @FieldName(name = Constants.Keys.duration)
        int getDuration();

        @FieldName(name = "extra")
        JsonObject getExtra();

        @FieldName(name = "invite_type")
        Integer getInviteType();

        @FieldName(name = "sign_extra")
        String getSignExtra();

        @FieldName(name = "to_room_id")
        long getToRoomId();

        @FieldName(name = "to_user_id")
        String getToUserId();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/n$b;", "", "", Constants.OperatorKey.CODE, "I", "getCode", "()I", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName(Constants.OperatorKey.CODE)
        private final int code;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (this.code == ((b) r2).code) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.code;
        }

        public final String toString() {
            return "Result(code=" + this.code + ")";
        }

        public b(int r1) {
            this.code = r1;
        }
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public n(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.b = r1;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(a.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r12, CallContext r13) {
        a r14 = (a) r12;
        Intrinsics.checkNotNullParameter(r14, "param");
        Intrinsics.checkNotNullParameter(r13, "callContext");
    L21:
        finishWithFailure();
        return;
    L4:
        if (r14.L2() != null) goto L6;
        finishWithResult(new b(0));     // Catch: Throwable -> L21
        return;
    L6:
        com.bytedance.android.live.revlink.impl.global.c r15 = this.b;     // Catch: Throwable -> L21
        if (r15 == null) goto L9;
        com.bytedance.android.live.revlink.impl.pk.service.b r16 = r15.Ud();     // Catch: Throwable -> L21
    L10:
        com.bytedance.android.live.revlink.impl.pk.service.b r0 = r16;
        if (r0 == null) goto L25;
        long r1 = r14.getToRoomId();     // Catch: Throwable -> L21
        String r3 = r14.L2();     // Catch: Throwable -> L21
        String r4 = r14.getToUserId();     // Catch: Throwable -> L21
        int r5 = r14.getDuration();     // Catch: Throwable -> L21
        Integer r6 = r14.getInviteType();     // Catch: Throwable -> L21
        String r17 = r14.getSignExtra();     // Catch: Throwable -> L21
        if (r17 != null) goto L16;
        r17 = "";
    L16:
        String r8 = r14.getBattleConfigSetting();     // Catch: Throwable -> L21
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        String r7 = r17;
        r0.invitePkByJsb(r1, r3, r4, r5, r6, r7, r8, InvitePkMethodKt.a(r14), new o(this));     // Catch: Throwable -> L21
        return;
    L25:
        return;
    L9:
        r16 = null;
        goto L10
    }
}
