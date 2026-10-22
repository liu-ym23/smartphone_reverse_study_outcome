package com.bytedance.geckox;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import com.bytedance.keva.Keva;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4770b;

    public /* synthetic */ o(Object r5, int r10) {
        this.f4769a = r10;
        this.f4770b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f4769a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        n r5 = (n) this.f4770b;
        r5.getClass();
        pa.a r10 = r5.f4760c;
        return;
    L6:
        com.bytedance.gkfs.d r11 = new com.bytedance.gkfs.d();
        int r12 = 0;
        com.bytedance.gkfs.d.c(r11, "clean", "start", 0, 12);
        if (((Boolean) com.bytedance.gkfs.e.f4831a.getValue()).booleanValue() == false) goto L9;
        com.bytedance.gkfs.e.b("开始旧数据清理");
    L9:
        Context r13 = df.c.c();
        final Ref.IntRef r14 = new Ref.IntRef();
        r14.element = 0;
        c r15 = b.f4736a;
        AppSettingsManager$IGeckoAppSettings r16 = r15.a();
        if (r16 == null) goto L13;
        r15.d = r16.getGkFSTestChannels();
    L13:
        if (((Map) r15.d) != null) goto L15;
        GeckoLogger.a("getGkFSTestChannels: null");
    L15:
        Map r17 = (Map) r15.d;
        if (r17 == null) goto L60;
        Iterator r18 = r17.entrySet().iterator();
    L19:
        if (r18.hasNext() == false) goto L60;
        Map.Entry r19 = (Map.Entry) r18.next();
        String r20 = (String) r19.getKey();
        String r110 = (String) df.c.d.get(r20);
        if (r110 != null) goto L25;
        r110 = r13.getFilesDir().getAbsolutePath() + "/offlineX";
    L25:
        if (r110.length() == 0) goto L26;
        List r21 = (List) r19.getValue();
        if (r21 == null) goto L19;
        Iterator r111 = r21.iterator();
    L31:
        if (r111.hasNext() == false) goto L19;
        String r112 = (String) r111.next();
        File r22 = new File(r110);
        if (TextUtils.isEmpty(r20) == false) goto L35;
    L52:
        String r113 = null;
    L53:
        if (r113 != null) goto L55;
    L59:
        com.bytedance.gkfs.d.f(r11, "gkfs-clean", "dir of " + r20 + '/' + r112 + " not found", 0, 28);
        r12 = 0;
        goto L31
    L55:
        if (r113.length() == 0) goto L59;
        com.bytedance.gkfs.e.a(new File(r113), new GkFSUtils$cleanOldExperiments$2$$special$$inlined$forEach$lambda$1(r14));
        r12 = 0;
        goto L31
    L35:
        if (TextUtils.isEmpty(r112) == true) goto L52;
        if (r22.exists() == false) goto L52;
        if (r22.isDirectory() == false) goto L52;
        String r114 = com.bytedance.geckox.utils.d.b(r112);
        StringBuilder r23 = new StringBuilder();     // Catch: Throwable -> L47
        String r24 = File.separator;     // Catch: Throwable -> L47
        r23.append(r24);     // Catch: Throwable -> L47
        r23.append(r20);     // Catch: Throwable -> L47
        String r25 = new File(r22, r23.toString()).getAbsolutePath();     // Catch: Throwable -> L47
        File r26 = new File(r25, r114);     // Catch: Throwable -> L47
        Long r115 = com.bytedance.geckox.utils.d.a(r26);     // Catch: Throwable -> L47
        if (r26.exists() == false) goto L49;
        if (r115 == null) goto L49;
        com.bytedance.android.anniex.base.service.f.k(r20, r114, r115, "3");     // Catch: Throwable -> L47
        r113 = r25 + r24 + r114 + r24 + r115 + r24 + "res";     // Catch: Throwable -> L47
    L49:
        com.bytedance.android.anniex.base.service.f.k(r20, r114, r115, "3");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        GeckoLogger.a("getChannelPath:error:", th);
        goto L52
    L26:
        com.bytedance.gkfs.d.f(r11, "clean", com.lynx.tasm.utils.g.d("dir of ", r20, " not registered yet"), r12, 28);
    L60:
        final Ref.IntRef r27 = new Ref.IntRef();
        r27.element = r12;
        File r28 = GkFSBlockBuffer.f4942l;
        if (r28 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("rootDir");
    L63:
        com.bytedance.gkfs.e.a(r28, new GkFSUtils$cleanOldExperiments$2$2(r27));
        Keva.getRepo("gkfs_chunk_indexing", 1).clear();
        ((Keva) this.f4770b).storeStringJustDisk("is_cleaned_3470", "2");
        com.bytedance.gkfs.d.c(r11, "clean", "finish, deletedFileCount=" + r14.element + ", deletedChunkCount=" + r27.element, 0, 12);
        if (((Boolean) com.bytedance.gkfs.e.f4831a.getValue()).booleanValue() == false) goto L66;
        com.bytedance.gkfs.e.b("完成旧数据清理");
    L66:
        ArrayList r29 = p.f4771a;
        monitor-enter(r29);
        Iterator r30 = r29.iterator();     // Catch: Throwable -> L72
    L70:
        if (r30.hasNext() == false) goto L74;
        ((Function0) r30.next()).invoke();     // Catch: Throwable -> L72
        goto L70
    L74:
        p.f4771a.clear();     // Catch: Throwable -> L72
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L72
        monitor-exit(r29);
        return;
    L72:
        th = move-exception;
        throw th;
    }
}
