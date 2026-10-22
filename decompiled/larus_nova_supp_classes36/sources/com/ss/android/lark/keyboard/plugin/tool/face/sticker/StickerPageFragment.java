package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class StickerPageFragment extends Fragment {
    public static final /* synthetic */ int s = 0;
    public RecyclerView d;
    public StickerPageAdapter e;
    public WeakReference<com.ss.android.lark.keyboard.plugin.tool.face.b> f;
    public final List<Sticker> g;
    public WeakReference<k> h;
    public boolean i;
    public final Map<String, Long> j;
    public final Map<String, Long> k;
    public final Map<String, Long> l;
    public final List<String> m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;

    public class a implements rkb.g {
        public final /* synthetic */ StickerPageFragment a;

        public a(StickerPageFragment r1) {
            this.a = r1;
        }

        @Override // rkb.g
        public final boolean onLoadFailed(Exception r1, final Object r2, Target r3, boolean r4) {
            UICallbackExecutor.post(new u(this, r2));
            return false;
        }

        @Override // rkb.g
        public final boolean onResourceReady(Object r1, final Object r2, Target r3, DataSource r4, boolean r5) {
            UICallbackExecutor.post(new v(this, r2));
            return false;
        }
    }

    public final void T90() {
        StickerPageAdapter r0 = this.e;
        r r1 = new r(this);
        if (r0.g != null) goto L7;
        r0.g = r1;
        return;
    }

    public final void U90() {
        StickerPageAdapter r0 = this.e;
        t r1 = new t(this);
        if (r0.h != null) goto L7;
        r0.h = r1;
        return;
    }

    public final void V90() {
        StickerPageAdapter r0 = this.e;
        q r1 = new q(this);
        if (r0.f != null) goto L7;
        r0.f = r1;
        return;
    }

    public final void onDestroy() {
        StickerPageAdapter r0 = this.e;
        if (r0 == null) goto L6;
        r0.h = null;
        r0.f = null;
        r0.g = null;
    L6:
        super.onDestroy();
    }

    public StickerPageFragment() {
        this.g = new ArrayList();
        this.i = false;
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = new ArrayList();
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = false;
        new a(this);
    }

    public final void setUserVisibleHint(boolean r19) {
        super.setUserVisibleHint(r19);
        boolean r2 = this.i;
        boolean r3 = false;
        if (r2 == false) goto L6;
        if (r19 == true) goto L6;
        boolean r5 = true;
    L7:
        if (r2 == true) goto L10;
        if (r19 == false) goto L10;
        r3 = true;
    L10:
        this.i = r19;
        if (r19 == false) goto L13;
        this.r = true;
        String r1 = com.ss.android.lark.keyboard.plugin.tool.face.c.a;
        Intrinsics.checkNotNullParameter(null, "stickerSetId");
        HashMap r14 = new HashMap();
        r14.put("sticker_package_id", null);
        com.ss.android.lark.keyboard.plugin.tool.face.c.a = AppreciableKit.start$default(AppreciableKit.Companion.getInstance(), Biz.Messenger, Scene.Chat, Event.enter_sticker_set, "StickerSet", true, null, null, r14, null, 96, null);
        Log.d("StickerPage", "start, set: null");
    L13:
        S90(r3, r5);
        return;
    L6:
        r5 = false;
        goto L7
    }

    public final void S90(boolean r26, boolean r27) {
        if (r27 == true) goto L8;
        if (this.i == true) goto L8;
        return;
    L8:
        if (this.r == false) goto L29;
        if (r27 == true) goto L13;
        if (this.n == 0) goto L13;
        return;
    L13:
        if (this.o <= 0) goto L31;
        this.r = false;
        if (r27 == false) goto L17;
        int r1 = 2;
    L19:
        if (this.p <= 0) goto L25;
        String r2 = com.ss.android.lark.keyboard.plugin.tool.face.c.a;
        Map<String, Long> r3 = this.l;
        Intrinsics.checkNotNullParameter(r3, "stickerDetail");
        HashMap r13 = new HashMap();
        r13.put("sticker_detail", r3);
        HashMap r4 = new HashMap();
        r4.put("end_type", Integer.valueOf(r1));
        HashMap r12 = new HashMap();
        r12.put("is_need_net", Boolean.TRUE);
        if (r26 == false) goto L23;
        AppreciableKit.timeCost$default(AppreciableKit.Companion.getInstance(), com.ss.android.lark.keyboard.plugin.tool.face.c.a, -1, null, r12, r13, r4, 4, null);
        goto L25
    L23:
        AppreciableKit.end$default(AppreciableKit.Companion.getInstance(), com.ss.android.lark.keyboard.plugin.tool.face.c.a, null, r12, r13, r4, 2, null);
    L25:
        if (this.q <= 0) goto L27;
        String r5 = com.ss.android.lark.keyboard.plugin.tool.face.c.a;
        List<String> r6 = this.m;
        Intrinsics.checkNotNullParameter(null, "stickerSetId");
        Intrinsics.checkNotNullParameter(r6, "stickerDetail");
        HashMap r7 = new HashMap();
        r7.put("sticker_package_id", null);
        r7.put("sticker_detail", r6);
        HashMap r8 = new HashMap();
        r8.put("end_type", Integer.valueOf(r1));
        HashMap r9 = new HashMap();
        Boolean r10 = Boolean.TRUE;
        r9.put("is_need_net", r10);
        AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Messenger, Scene.Chat, Event.enter_sticker_set, ErrorType.SDK, ErrorLevel.Fatal, 0, null, "StickerSet", "", r10, r9, r7, r8, 64, null));
    L27:
        Log.d("StickerPage", "end, set: null compete count: " + this.o);
        return;
    L17:
        r1 = 1;
        goto L19
    L31:
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Context r7 = r4.getContext();
        LinearLayout r8 = new LinearLayout(r7);
        r8.setId(2131384813);
        ViewGroup.LayoutParams r9 = new ViewGroup.LayoutParams(-1, -1);
        r8.setOrientation(1);
        r8.setLayoutParams(r9);
        RecyclerView r10 = new RecyclerView(r7);
        r10.setId(2131387349);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, -1);
        r2.gravity = 1;
        r10.setPadding(0, 0, 0, 0);
        r8.addView(r10, r2);
        RecyclerView r11 = r8.findViewById(2131387349);
        this.d = r11;
        r11.setLayoutManager(new GridLayoutManager(getContext(), 4));
        StickerPageAdapter r12 = new StickerPageAdapter(getContext());
        this.e = r12;
        this.d.setAdapter(r12);
        StickerPageAdapter r13 = this.e;
        List<Sticker> r14 = this.g;
        r13.getClass();
        if (CollectionUtils.isEmpty(r14) == true) goto L6;
        ((ArrayList) r13.a).addAll(r14);
        r13.notifyDataSetChanged();
    L6:
        T90();
        V90();
        U90();
        StickerPageAdapter r15 = this.e;
        r15.i = new s(this);
        return r8;
    }
}
