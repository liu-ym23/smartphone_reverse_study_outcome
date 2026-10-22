package com.ss.android.ugc.effectmanager;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface DownloadableModelSupportLibraryLoader {

    public static class SystemLoader implements DownloadableModelSupportLibraryLoader {
        public SystemLoader() {
        }

        public static /* synthetic */ void access$000(String r0) {
            System.loadLibrary(r0);
        }

        @JvmStatic
        public static void INVOKESTATIC_com_ss_android_ugc_effectmanager_DownloadableModelSupportLibraryLoader$SystemLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
            Intrinsics.checkNotNullParameter(r4, "libName");
            FLogger r0 = FLogger.a;
            r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
            a.c(r4);
            r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
        }

        @Override // com.ss.android.ugc.effectmanager.DownloadableModelSupportLibraryLoader
        public void loadLibrary(String r1) {
            INVOKESTATIC_com_ss_android_ugc_effectmanager_DownloadableModelSupportLibraryLoader$SystemLoader_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r1);
        }
    }

    void loadLibrary(String r1);
}
