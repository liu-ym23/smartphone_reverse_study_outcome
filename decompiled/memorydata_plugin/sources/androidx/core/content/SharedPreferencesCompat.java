package androidx.core.content;

import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class SharedPreferencesCompat {

    @Deprecated
    public static final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper;

        private static class Helper {
            Helper() {
            }

            public void apply(SharedPreferences.Editor r2) {
                SharedPreferences.Editor r1 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r2, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
                r1.apply();     // Catch: AbstractMethodError -> L5
                return;
            L5:
                r1.commit();
            }
        }

        private EditorCompat() {
            this.mHelper = new Helper();
        }

        @Deprecated
        public static EditorCompat getInstance() {
            if (sInstance != null) goto L6;
            sInstance = new EditorCompat();
        L6:
            return sInstance;
        }

        @Deprecated
        public void apply(SharedPreferences.Editor r3) {
            SharedPreferences.Editor r4 = (SharedPreferences.Editor) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.Editor.class, "com.obric.memorydata.plugin");
            this.mHelper.apply(r4);
        }
    }

    private SharedPreferencesCompat() {
    }
}
