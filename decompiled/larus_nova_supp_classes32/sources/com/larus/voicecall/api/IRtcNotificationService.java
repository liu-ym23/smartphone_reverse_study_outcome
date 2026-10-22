package com.larus.voicecall.api;

import android.content.Context;
import android.graphics.Bitmap;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface IRtcNotificationService {

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/voicecall/api/IRtcNotificationService$RtcNotificationAction;", NameKeys.UnloadStrategy_No_Strategy, "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface RtcNotificationAction {
        public static final a Companion = null;
        public static final int HANG_UP = 3;
        public static final int MUTE = 1;
        public static final int UN_MUTE = 2;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final Bitmap c;
        public final Integer d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final Context h;

        public a(String r2, String r3, Bitmap r4, Integer r5, boolean r6, boolean r7, boolean r8, Context r9) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r3, LynxAccessibilityModule.MSG_CONTENT);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    MutableSharedFlow a();
}
