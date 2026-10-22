package com.ss.android.lark.chatbase.view;

import android.content.Context;
import android.media.AudioManager;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LarkPlayModeTip {
    public static final Lazy<LarkPlayModeTip> a = null;

    public static final class a {
        @JvmStatic
        public static void b(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("messenger.input.audio.playby.improvements") == false) goto L14;
            Object r0 = r4.getSystemService("audio");
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.media.AudioManager");
            int r1 = ((AudioManager) r0).getStreamVolume(3);
            int r2 = com.ss.android.lark.audio.opus.e.d().j;
            if (r2 != 1) goto L7;
            Log.i("LarkPlayModeTip", "tryShowToastOnPlay / Play in speaker mode, volume: " + r1);
            if (r1 != 0) goto L16;
            a(r4, -1);
            return;
        L16:
            return;
        L7:
            if (r2 != 2) goto L17;
            a(r4, 2);
            Log.i("LarkPlayModeTip", "tryShowToastOnPlay / Play in receiver (earpiece) mode");
            return;
        L17:
            return;
        }

        public static void a(Context r1, int r2) {
            if (r2 != (-1)) goto L5;
            UDToast.show(r1, 2131891533, 2131244016);
            return;
        L5:
            if (r2 != 1) goto L7;
            UDToast.show(r1, 2131891249, 2131248275);
            return;
        L7:
            if (r2 != 2) goto L15;
            UDToast.show(r1, 2131891248, 2131254281);
            return;
        }
    }

    public LarkPlayModeTip() {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, LarkPlayModeTip$Companion$INSTANCE$2.INSTANCE);
    }
}
