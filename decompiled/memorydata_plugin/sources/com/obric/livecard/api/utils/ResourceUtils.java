package com.obric.livecard.api.utils;

import android.content.Context;
import android.net.Uri;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\r¨\u0006\u0011"}, d2 = {"Lcom/obric/livecard/api/utils/ResourceUtils;", "", "()V", "getApplicationIcon", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "getAssetsFile", "context", "Landroid/content/Context;", "fileName", "type", "getDrawable", "drawableId", "", "getString", "stringId", "ResourceType", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResourceUtils {
    public static final ResourceUtils INSTANCE = null;

    @Target({ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/livecard/api/utils/ResourceUtils$ResourceType;", "", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ResourceType {
        public static final String ALPHA_VIDEO = "alpha-video";
        public static final String APP_DRAWABLE = "drawable";
        public static final String APP_ICON = "app_icon";
        public static final Companion Companion = null;
        public static final String LOTTIE = "lottie";
        public static final String STRING = "stringId";
        public static final String SVG = "svg";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/livecard/api/utils/ResourceUtils$ResourceType$Companion;", "", "()V", "ALPHA_VIDEO", "", "APP_DRAWABLE", "APP_ICON", "LOTTIE", "STRING", "SVG", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final String ALPHA_VIDEO = "alpha-video";
            public static final String APP_DRAWABLE = "drawable";
            public static final String APP_ICON = "app_icon";
            public static final String LOTTIE = "lottie";
            public static final String STRING = "stringId";
            public static final String SVG = "svg";

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    static {
        INSTANCE = new ResourceUtils();
    }

    private ResourceUtils() {
    }

    public final String getApplicationIcon(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        String r1 = new Uri.Builder().scheme(Params.CONTENT).authority("com.island.local.file").appendQueryParameter("pkg", r2).appendQueryParameter("type", "app_icon").build().toString();
        Intrinsics.checkNotNullExpressionValue(r1, "Builder().scheme(\"conten…      .build().toString()");
        return r1;
    }

    public final String getAssetsFile(Context r4, String r5, String r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "fileName");
        Intrinsics.checkNotNullParameter(r6, "type");
        String r7 = new Uri.Builder().scheme(Params.CONTENT).authority("com.island.local.file").appendQueryParameter("fileName", r5).appendQueryParameter("pkg", r3.getPackageName()).appendQueryParameter("type", r6).build().toString();
        Intrinsics.checkNotNullExpressionValue(r7, "Builder().scheme(\"conten…      .build().toString()");
        return r7;
    }

    public final String getDrawable(Context r2, int r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        String r4 = new Uri.Builder().scheme(Params.CONTENT).authority("com.island.local.file").appendQueryParameter(OaidModel.KEY_ID, String.valueOf(r3)).appendQueryParameter("pkg", r1.getPackageName()).appendQueryParameter("type", "drawable").build().toString();
        Intrinsics.checkNotNullExpressionValue(r4, "Builder().scheme(\"conten…      .build().toString()");
        return r4;
    }

    public final String getString(int r2) {
        return "stringId://" + r2;
    }
}
