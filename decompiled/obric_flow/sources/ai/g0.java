package ai;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import com.bytedance.crash.util.ListMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.ui.list.UIListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f211c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    public g0(int r5) {
        switch(r5) {
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        b0 r10 = b0.f180a;
        this.d = new CopyOnWriteArrayList();
        ArrayList r11 = new ArrayList();
        this.e = r11;
        this.f = new ArrayList();
        this.f209a = r10;
        r11.add(new b());
        return;
    L5:
        this.f = new MediaMetadataRetriever();
        return;
    L7:
        this.f209a = new ListMap();
        this.f210b = new ListMap();
        this.f211c = new ListMap();
        this.e = new ListMap();
        this.d = new CopyOnWriteArrayList();
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
    }

    public static boolean b(ReadableArray r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void a() {
        ReadableArray r5 = (ReadableArray) this.f211c;
        int r10 = 0;
        UIListAdapter r11 = (UIListAdapter) this.g;
        if (r5 == null) goto L9;
        int r12 = 0;
    L6:
        if (r12 >= ((ReadableArray) this.f211c).size()) goto L9;
        r11.notifyItemChanged(((ReadableArray) this.f211c).getInt(r12), Integer.valueOf(((ReadableArray) this.d).getInt(r12)));
        r12 = r12 + 1;
    L9:
        if (((ReadableArray) this.e) == null) goto L14;
        int r13 = 0;
    L12:
        if (r13 >= ((ReadableArray) this.e).size()) goto L14;
        r11.notifyItemMoved(((ReadableArray) this.e).getInt(r13), ((ReadableArray) this.f).getInt(r13));
        r13 = r13 + 1;
    L14:
        ReadableArray r14 = (ReadableArray) this.f210b;
        if (r14 == null) goto L20;
        int r15 = r14.size() - 1;
    L17:
        if (r15 < 0) goto L20;
        r11.notifyItemRemoved(((ReadableArray) this.f210b).getInt(r15));
        r15 = r15 - 1;
    L20:
        if (((ReadableArray) this.f209a) != null) goto L22;
        return;
    L22:
        if (r10 >= ((ReadableArray) this.f209a).size()) goto L29;
        r11.notifyItemInserted(((ReadableArray) this.f209a).getInt(r10));
        r10 = r10 + 1;
        goto L22
    }

    public void c(h r5) {
        ArrayList r10 = (ArrayList) this.e;
        w0.b(r5, "factory == null");
        r10.add(r5);
    }

    public void d(ei.b r5) {
        w0.b(r5, "interceptor == null");
        ((CopyOnWriteArrayList) this.d).add(r5);
    }

    public h0 e() {
        if (((k) this.f211c) == null) goto L23;
        if (((bi.a) this.f210b) == null) goto L21;
        if (((h.a) this.g) == null) goto L19;
        Executor r10 = ((b0) this.f209a).b();
        ArrayList r11 = new ArrayList((ArrayList) this.f);
        r11.add(((b0) this.f209a).a(r10));
        ArrayList r5 = new ArrayList((ArrayList) this.e);
        if (h0.f212i == null) goto L17;
        Iterator r12 = h0.f212i.iterator();
    L12:
        if (r12.hasNext() == false) goto L17;
        ei.b r13 = (ei.b) r12.next();
        if (((CopyOnWriteArrayList) this.d).contains(r13) == true) goto L12;
        ((CopyOnWriteArrayList) this.d).add(r13);
    L17:
        return new h0((k) this.f211c, (bi.a) this.f210b, (CopyOnWriteArrayList) this.d, r5, r11, (h.a) this.g, r10);
    L19:
        throw new IllegalStateException("HttpExecutor may not be null.");
    L21:
        throw new IllegalStateException("ClientProvider may not be null.");
    L23:
        throw new IllegalStateException("Endpoint may not be null.");
    }

    public void f() {
        MediaPlayer r5 = new MediaPlayer();
        this.e = r5;
        r5.setOnCompletionListener(new wp.a(this));
        MediaPlayer r10 = (MediaPlayer) this.e;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r10.setOnPreparedListener(new wp.b(this));
        MediaPlayer r11 = (MediaPlayer) this.e;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L8:
        r11.setOnErrorListener(new wp.c(this));
        MediaPlayer r12 = (MediaPlayer) this.e;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L11:
        r12.setOnInfoListener(new wp.d(this));
    }

    public void g(String r5) {
        if (r5 == null) goto L8;
        if (r5.trim().length() == 0) goto L8;
        k r10 = new k();
        r10.f239a = r5;
        this.f211c = r10;
        return;
    L8:
        throw new NullPointerException("Endpoint may not be blank.");
    }
}
