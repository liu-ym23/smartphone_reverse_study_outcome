package com.ss.android.lark.coremd.clickcompat;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import z5c.k3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MomentsAppLinkPatcher {

    @Target({ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/coremd/clickcompat/MomentsAppLinkPatcher$PatchScene;", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PatchScene {
        public static final int CARD_MSG = 1;
        public static final a Companion = null;
        public static final int IM_MSG = 0;

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

    static {
    }

    @JvmStatic
    public static final String a(String r7) {
        if (r7 == null) goto L37;
        Uri r0 = UriProtector.parse(r7);
        if (r0 != null) goto L7;
        return r7;
    L7:
        if (StringsKt.contains$default(r7, "/client/moments/home", false, 2, null) == false) goto L9;
    L16:
        String r8 = k3.f.b;
        Uri.Builder r1 = r0.buildUpon();
        if (UriProtector.getQueryParameter(r0, "from") == null) goto L28;
        if (r8 == null) goto L28;
        r1.clearQuery();
        Iterator r3 = UriProtector.getQueryParameterNames(r0).iterator();
    L21:
        if (r3.hasNext() == false) goto L28;
        String r4 = (String) r3.next();
        if (Intrinsics.areEqual(r4, "from") == true) goto L21;
        Iterator r5 = UriProtector.getQueryParameters(r0, r4).iterator();
    L26:
        if (r5.hasNext() == false) goto L21;
        r1.appendQueryParameter(r4, (String) r5.next());
    L28:
        if (r8 == null) goto L31;
        r1.appendQueryParameter("from", r8);
    L31:
        return r1.build().toString();
    L9:
        if (StringsKt.contains$default(r7, "/client/moments/detail", false, 2, null) == true) goto L16;
        if (StringsKt.contains$default(r7, "/client/moments/category", false, 2, null) == true) goto L16;
        if (StringsKt.contains$default(r7, "/client/moments/hashtag", false, 2, null) == true) goto L16;
        return r7;
    L37:
        return r7;
    }
}
