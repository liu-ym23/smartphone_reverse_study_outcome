package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import android.util.Pair;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoConfig;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class g implements uqb.b {
    public final String a;
    public final GeckoConfig b;
    public final GeckoStrategy c;
    public final String d;
    public final GeckoClient e;

    public static final class a extends GeckoUpdateListener {
        public final /* synthetic */ g a;
        public final /* synthetic */ uqb.a b;
        public final /* synthetic */ ArrayList<CheckRequestBodyModel.TargetChannel> c;
        public final /* synthetic */ String d;

        public final void onUpdateFinish() {
            Log.i(this.a.d, "syncTemplates，onUpdateFinish");
        }

        public final void onLocalNewestVersion(LocalPackageModel r3) {
            Log.i(this.a.d, "syncTemplates，onLocalNewestVersion");
            uqb.a r4 = this.b;
            if (r4 == null) goto L7;
            this.a.d(this.d, r4);
            return;
        }

        public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r2, Throwable r3) {
            Log.i(this.a.d, "syncTemplates，onCheckServerVersionFail");
            uqb.a r4 = this.b;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r3 != null) goto L7;
            r3 = new Throwable("geckox update failed");
        L7:
            r4.onFailed(r3);
        }

        public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r12, Map<String, List<UpdatePackage>> r13) {
            Log.i(this.a.d, "syncTemplates，onCheckServerVersionSuccess");
            if (this.b != null) goto L6;
            return;
        L6:
            if (r13 != null) goto L8;
        L11:
            boolean r2 = true;
        L13:
            if (r2 == false) goto L39;
            ArrayList<CheckRequestBodyModel.TargetChannel> r14 = this.c;
            g r3 = this.a;
            ArrayList r4 = new ArrayList();
            Iterator<T> r15 = r14.iterator();
        L16:
            if (r15.hasNext() == false) goto L34;
            Object r5 = r15.next();
            CheckRequestBodyModel.TargetChannel r6 = (CheckRequestBodyModel.TargetChannel) r5;
            if (r12 == null) goto L20;
            List<Pair<String, Long>> r7 = r12.get(r3.b.getAccessKey());
        L21:
            if (r7 == null) goto L31;
            Iterator<T> r8 = r7.iterator();
        L24:
            if (r8.hasNext() == false) goto L28;
            Object r9 = r8.next();
            if (Intrinsics.areEqual(r6.channelName, ((Pair) r9).first) == false) goto L24;
        L29:
            if (r9 != null) goto L31;
            boolean r10 = true;
        L32:
            if (r10 == false) goto L16;
            r4.add(r5);
            goto L16
        L28:
            r9 = null;
        L31:
            r10 = false;
            goto L32
        L20:
            r7 = null;
            goto L21
        L34:
            g r16 = this.a;
            uqb.a r17 = this.b;
            Iterator r0 = r4.iterator();
        L36:
            if (r0.hasNext() == false) goto L38;
            CheckRequestBodyModel.TargetChannel r1 = (CheckRequestBodyModel.TargetChannel) r0.next();
            Log.i(r16.d, "syncTemplates，invalid channel");
            r17.onFailed(new Throwable("invalid channel"));
            goto L36
        L38:
            return;
        L39:
            ArrayList<CheckRequestBodyModel.TargetChannel> r18 = this.c;
            g r11 = this.a;
            ArrayList r19 = new ArrayList();
            Iterator<T> r110 = r18.iterator();
        L41:
            if (r110.hasNext() == false) goto L58;
            Object r20 = r110.next();
            CheckRequestBodyModel.TargetChannel r21 = (CheckRequestBodyModel.TargetChannel) r20;
            List<UpdatePackage> r22 = r13.get(r11.b.getAccessKey());
            if (r22 == null) goto L52;
            Iterator<T> r23 = r22.iterator();
        L46:
            if (r23.hasNext() == false) goto L50;
            Object r24 = r23.next();
            if (Intrinsics.areEqual(((UpdatePackage) r24).getChannel(), r21.channelName) == false) goto L46;
        L51:
            UpdatePackage r25 = (UpdatePackage) r24;
        L53:
            if (r25 == null) goto L55;
            boolean r26 = true;
        L56:
            if (r26 == true) goto L41;
            r19.add(r20);
            goto L41
        L55:
            r26 = false;
            goto L56
        L50:
            r24 = null;
            goto L51
        L52:
            r25 = null;
            goto L53
        L58:
            g r111 = this.a;
            Iterator r112 = r19.iterator();
        L60:
            if (r112.hasNext() == false) goto L65;
            CheckRequestBodyModel.TargetChannel r27 = (CheckRequestBodyModel.TargetChannel) r112.next();
            Log.i(r111.d, "syncTemplates，filterNot channel");
            uqb.a r28 = this.b;
            if (r28 == null) goto L60;
            this.a.d(this.d, r28);
            goto L60
        L65:
            return;
        L8:
            if (r13.isEmpty() == true) goto L11;
            r2 = false;
            goto L13
        }

        public final void onUpdateFailed(String r4, Throwable r5) {
            Log.e(this.a.d, "syncTemplates，onUpdateFailed， channel：" + r4, r5);
            uqb.a r6 = this.b;
            if (r6 != null) goto L5;
            return;
        L5:
            if (r5 != null) goto L7;
            r5 = new Throwable("geckox update failed");
        L7:
            r6.onFailed(r5);
        }

        public final void onUpdateSuccess(String r4, long r5) {
            Log.i(this.a.d, "syncTemplates，onUpdateSuccess， channel：" + r4 + ", version: " + r5);
            uqb.a r6 = this.b;
            if (r6 == null) goto L7;
            this.a.d(this.d, r6);
            return;
        }

        public final void onCheckRequestIntercept(int r1, Map<String, List<Pair<String, Long>>> r2, Throwable r3) {
            Log.i(this.a.d, "syncTemplates，onCheckRequestIntercept");
            uqb.a r4 = this.b;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r3 != null) goto L7;
            r3 = new Throwable("geckox  onCheckRequestIntercept");
        L7:
            r4.onFailed(r3);
        }

        public a(g r1, uqb.a r2, ArrayList<CheckRequestBodyModel.TargetChannel> r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public final VFSPath c() {
        String r0 = ResLoadUtils.getChannelPath(this.b.getResRootDir(), this.b.getAccessKey(), this.a);
        if (r0 != null) goto L7;
        return null;
    L7:
        return VFSFiles.b.z(r0);
    }

    @Override // uqb.b
    public final void a(String r6, uqb.a r7) {
        Intrinsics.checkNotNullParameter(r6, "templatePath");
        Intrinsics.checkNotNullParameter(r7, "resourceCallBack");
        Log.i(this.d, "strategy is " + this.c.name());
        VFSPath r0 = c();
        if (r0 == null) goto L7;
        VFSPath r1 = r0.subPath(r6);
        if (r1 == null) goto L7;
        VFSFile r2 = r1.toFile();
    L8:
        if (r2 == null) goto L10;
        Boolean r3 = Boolean.valueOf(r2.exists());
    L11:
        Log.i(this.d, "exist  " + r3);
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L14;
    L18:
        d(r6, r7);
        b(r6, null);
        return;
    L14:
        if (this.c == GeckoStrategy.NO_WAIT_FOR_REMOTE) goto L18;
        b(r6, r7);
        return;
    L10:
        r3 = null;
    L7:
        r2 = null;
        goto L8
    }

    public void b(String r5, uqb.a r6) {
        Intrinsics.checkNotNullParameter(r5, "templatePath");
        LinkedHashMap r0 = new LinkedHashMap();
        ArrayList r1 = new ArrayList();
        r1.add(new CheckRequestBodyModel.TargetChannel(this.a));
        r0.put(this.b.getAccessKey(), r1);
        Log.i(this.d, "begin checkUpdateMulti");
        this.e.checkUpdateMulti(r0, new a(this, r6, r1, r5));
    }

    public final void d(String r5, uqb.a r6) {
        VFSPath r0 = c();     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        Log.e(this.d, "syncTemplates，tryToReadGeckoFile，file not exist");     // Catch: Throwable -> L9
        r6.onFailed(new FileNotFoundException("getGeckoDir"));     // Catch: Throwable -> L9
        return;
    L6:
        VFSPath r7 = r0.subPath(r5);     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r7, "<this>");     // Catch: Throwable -> L9
        VFSFiles.b.getClass();     // Catch: Throwable -> L9
        byte[] r1 = ByteStreamsKt.readBytes(VFSFiles.a(r7).l(r7));     // Catch: Throwable -> L9
        String r8 = r7.getAbsolutePath();     // Catch: Throwable -> L9
        Log.i(this.d, "syncTemplates，tryToReadGeckoFile， success");
        r6.a(new uqb.c(r1, r8, g.class.getSimpleName(), 4));
        return;
    L9:
        th = move-exception;
        Log.e(this.d, "syncTemplates，tryToReadGeckoFile， channel：" + this.a, th);
        r6.onFailed(th);
    }

    public g(String r2, GeckoConfig r3, GeckoStrategy r4) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r3, "geckoConfig");
        Intrinsics.checkNotNullParameter(r4, "geckoStrategy");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = "GeckoLoader";
        this.e = GeckoClient.create(r3);
    }
}
