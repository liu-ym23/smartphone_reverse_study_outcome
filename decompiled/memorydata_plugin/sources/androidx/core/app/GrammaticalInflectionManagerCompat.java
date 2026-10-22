package androidx.core.app;

import android.app.GrammaticalInflectionManager;
import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class GrammaticalInflectionManagerCompat {
    public static final int GRAMMATICAL_GENDER_FEMININE = 2;
    public static final int GRAMMATICAL_GENDER_MASCULINE = 3;
    public static final int GRAMMATICAL_GENDER_NEUTRAL = 1;
    public static final int GRAMMATICAL_GENDER_NOT_SPECIFIED = 0;

    static class Api34Impl {
        private Api34Impl() {
        }

        static int getApplicationGrammaticalGender(Context r2) {
            return getGrammaticalInflectionManager((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationGrammaticalGender();
        }

        private static GrammaticalInflectionManager getGrammaticalInflectionManager(Context r2) {
            return (GrammaticalInflectionManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(GrammaticalInflectionManager.class), GrammaticalInflectionManager.class, "com.obric.memorydata.plugin");
        }

        static void setRequestedApplicationGrammaticalGender(Context r2, int r3) {
            getGrammaticalInflectionManager((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).setRequestedApplicationGrammaticalGender(r3);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GrammaticalGender {
    }

    private GrammaticalInflectionManagerCompat() {
    }

    public static int getApplicationGrammaticalGender(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return 0;
    L5:
        return Api34Impl.getApplicationGrammaticalGender(r3);
    }

    public static void setRequestedApplicationGrammaticalGender(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.setRequestedApplicationGrammaticalGender(r4, r3);
        return;
    }
}
