package com.suite.lark.platform.component.storage.clean;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/suite/lark/platform/component/storage/clean/ResourceEraser$EraserResult;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class CleanEngine$cleanFiles$1 extends Lambda implements Function0<m.a> {
    final /* synthetic */ List<String> $filePaths;
    final /* synthetic */ boolean $skipSafeDelete;
    final /* synthetic */ d this$0;

    public CleanEngine$cleanFiles$1(List<String> r1, boolean r2, d r3) {
        this.$filePaths = r1;
        this.$skipSafeDelete = r2;
        this.this$0 = r3;
        super(0);
    }

    public final m.a invoke() {
        i r0 = i.a;
        List<String> r2 = this.$filePaths;
        boolean r3 = this.$skipSafeDelete;
        d r4 = this.this$0;
        Iterator<T> r5 = r2.iterator();
        List r6 = null;
        long r7 = 0;
        i r11 = r0;
        String r15 = null;
        long r13 = 0;
        boolean r9 = false;
    L4:
        if (r5.hasNext() == false) goto L49;
        PolarisFileWrapper r12 = new PolarisFileWrapper((String) r5.next());
        String r17 = "";
        if (r12.exists() == false) goto L39;
        if (r3 == true) goto L50;
        r4.getClass();     // Catch: IOException -> L34
        Pair r1 = d.a(r12, r6);     // Catch: IOException -> L34
        boolean r18 = ((Boolean) r1.component1()).booleanValue();     // Catch: IOException -> L34
        r13 = r13 + ((Number) r1.component2()).longValue();
    L52:
        boolean r19 = !r12.isDirectory();
        if (r18 == false) goto L54;
    L38:
        String r8 = r17;
        boolean r10 = true;
    L40:
        if (r19 == false) goto L42;
        String r14 = "file";
    L44:
        if (r18 == false) goto L46;
        Log.i("StorageCleaner", "erase " + r14 + " success, exist:" + r10 + ", path:" + r12.getAbsolutePath() + ' ' + r8);
    L47:
        r6 = null;
        r7 = 0;
        goto L4
    L46:
        Log.e("StorageCleaner", "erase " + r14 + " failed, path:" + r12.getAbsolutePath() + ' ' + r8);
        r9 = true;
        goto L47
    L42:
        r14 = "dir";
        goto L44
    L54:
        r11 = i.b;     // Catch: IOException -> L30
    L30:
        e = e;
    L37:
        r11 = i.c;
        r15 = r12.getAbsolutePath();
        Log.e("StorageCleaner", "delete file has io exception:" + e.getMessage() + ", file:" + r12.getAbsolutePath());
    L32:
        e = e;
    L36:
        r19 = true;
        goto L37
    L50:
        r17 = "ignore whitelist";
        Iterator r16 = FilesKt.walkBottomUp(r12).iterator();     // Catch: IOException -> L34
    L9:
        r18 = true;
    L11:
        if (r16.hasNext() == false) goto L52;
        File r110 = (File) r16.next();     // Catch: IOException -> L34
        long r20 = r110.length();     // Catch: IOException -> L34
        if (r110.delete() == true) goto L16;
        r20 = r7;
    L16:
        r13 = r13 + r20;     // Catch: IOException -> L34
        if (r20 == r7) goto L19;
    L20:
        if (r18 == true) goto L9;
    L22:
        r18 = false;
        goto L11
    L19:
        if (r110.exists() == true) goto L22;
    L34:
        e = e;
        r18 = true;
        goto L36
    L39:
        r8 = "";
        r10 = false;
        r18 = true;
        r19 = true;
        goto L40
    L49:
        return new m.a(!r9, r11, "file paths: " + this.$filePaths, r13, r15, 24);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1737invoke() {
        return invoke();
    }
}
