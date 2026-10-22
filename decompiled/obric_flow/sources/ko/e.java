package ko;

import com.lynx.tasm.service.IServiceProvider;

/* JADX INFO: loaded from: classes2.dex */
public interface e extends IServiceProvider {
    void cancelPreloadMedia(String r5, String r10);

    f fetchResourceAsync(String r5, p r10, o r11);

    int isLocalResource(String r5);

    void preloadMedia(String r5, String r10, String r11, long r12);
}
