package com.bytedance.android.live.broadcastgame.api.feature_panel;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.utility.SharedPrefHelper;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PreviewOpenFeatureTalentSettingUtil {
    public static final SharedPrefHelper a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/feature_panel/PreviewOpenFeatureTalentSettingUtil$Type;", "", "", "value", "I", "getValue", "()I", "MINIAPP", "TALENT", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type MINIAPP = null;
        public static final Type TALENT = null;
        public static final /* synthetic */ Type[] a = null;
        private final int value;

        static {
            Type r1 = new Type("MINIAPP", 0, 0);
            MINIAPP = r1;
            Type r2 = new Type("TALENT", 1, 1);
            TALENT = r2;
            a = new Type[]{r1, r2};
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        a = SharedPrefHelper.b(s1.getContext());
    }

    public static void a(Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        a.m("miniapp_mount_module_uid_key:" + k.n(IUserService.class).user().n(), Integer.valueOf(r2.getValue()));     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
