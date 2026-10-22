package ff0;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.ugc.effectmanager.DownloadableModelSupport;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    public final void accept(Object r17) {
        if (((Boolean) r17).booleanValue() == false) goto L45;
        ReadOnlyProperty r0 = vm2.d.O6;
        KProperty[] r1 = vm2.d.a;
        String r3 = null;
        if (((Boolean) r0.getValue(null, r1[402(0x192, float:5.63E-43)])).booleanValue() == true) goto L11;
        int r2 = n.a;
        List r4 = CollectionsKt.listOf("lip_sync");
        Map r5 = MapsKt.mapOf(TuplesKt.to("lip_sync", CollectionsKt.listOf("lip_sync")));
        ALogger.i("HamletAvatar", "start epDownloadModel");
        DownloadableModelSupport r6 = DownloadableModelSupport.getInstance();
        Object[] r7 = r4.toArray(new String[0]);
        if (r7 == null) goto L10;
        r6.fetchResourcesByRequirementsAndModelNames((String[]) r7, r5, new j());
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L11:
        int r8 = n.a;
        Context r9 = s1.getContext();
        if (r9 == null) goto L47;
        boolean r10 = c.a;
        ReadOnlyProperty r11 = vm2.d.G6;
        String r12 = (String) r11.getValue(null, r1[394(0x18a, float:5.52E-43)]);
        File r13 = r9.getExternalFilesDir(null);
        if (r13 != null) goto L17;
    L19:
        PolarisFileWrapper r14 = new PolarisFileWrapper(r13, "hamlet_avatar");
        if (r14.exists() == true) goto L39;
        r14.mkdirs();
    L39:
        r3 = (String) CollectionsKt.lastOrNull(StringsKt.split$default(new URL((String) r11.getValue(null, r1[394(0x18a, float:5.52E-43)])).getPath(), new String[]{"/"}, false, 0, 6, null));     // Catch: Exception -> L24
    L42:
        if (r3 != null) goto L28;
        ALogger.i("HamletAvatar", "hamlet lipsync model url parase file part error, please check url!!!");     // Catch: Exception -> L36
    L41:
        return;
    L28:
        if (new PolarisFileWrapper(r14, r3).exists() == false) goto L34;
        HamletAvatarContext r15 = HamletAvatarContext.Companion.getContext();     // Catch: Exception -> L36
        if (r15 == null) goto L41;
        com.bytedance.live.datacontext.m<Boolean> r16 = r15.isLipSyncModelDownloaded();     // Catch: Exception -> L36
        if (r16 == null) goto L41;
        r16.setValue(Boolean.TRUE);     // Catch: Exception -> L36
        goto L41
    L34:
        Downloader.with(r9).url(r12).name(r3).monitorScene("HAMLET_AVATAR_LIPSYNC_MODEL_FILE_NAME").savePath(r14.getAbsolutePath()).onlyWifi(false).retryCount(2).subThreadListener(new i()).download();     // Catch: Exception -> L36
    L36:
        e = move-exception;
        ALogger.i("HamletAvatar", "hamlet lipsync model download exception " + Log.getStackTraceString(e) + "!!!");
        return;
    L17:
        if (r13.exists() == true) goto L19;
        r13.mkdirs();
        goto L19
    L47:
        return;
    }
}
