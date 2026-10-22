package com.ss.android.lark.photoeditor.impl.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class PhotoEditorFragment extends BaseFragment {
    public static final /* synthetic */ int q = 0;
    public View d;
    public FragmentActivity e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public boolean j;
    public String k;
    public String l;
    public String m;
    public o n;
    public final a o;
    public final b p;

    public class a implements r.b {
        public final /* synthetic */ PhotoEditorFragment a;

        public a(PhotoEditorFragment r1) {
            this.a = r1;
        }
    }

    public class b implements o.a {
        public final /* synthetic */ PhotoEditorFragment a;

        public b(PhotoEditorFragment r1) {
            this.a = r1;
        }

        public final void a(String r3, Pair<Integer, Integer> r4, ArrayList<pfc.f.a> r5) {
            PhotoEditorFragment r0 = this.a;
            int r1 = PhotoEditorFragment.q;
            o r2 = r0.n;
            if (r2 == null) goto L5;
            r2.destroy();
            r0.n = null;
        L5:
            Intent r6 = new Intent();
            r6.putExtra("key_result_path", r3);
            if (r5 == null) goto L8;
            r6.putParcelableArrayListExtra("key_edit_action_list", s0c.a.a(r5));
        L8:
            r6.putExtra("key_editor_width", (Serializable) r4.first);
            r6.putExtra("key_editor_height", (Serializable) r4.second);
            this.a.setResult(-1, r6);
            this.a.finish();
        }

        public final void b(String r3, String r4, Pair<Integer, Integer> r5, ArrayList<pfc.f.a> r6) {
            PhotoEditorFragment r0 = this.a;
            int r1 = PhotoEditorFragment.q;
            o r2 = r0.n;
            if (r2 == null) goto L5;
            r2.destroy();
            r0.n = null;
        L5:
            Intent r7 = new Intent();
            r7.putExtra("key_result_path", r3);
            r7.putExtra("key_result_path_decrypt", r4);
            if (r6 == null) goto L8;
            r7.putParcelableArrayListExtra("key_edit_action_list", s0c.a.a(r6));
        L8:
            r7.putExtra("key_editor_width", (Serializable) r5.first);
            r7.putExtra("key_editor_height", (Serializable) r5.second);
            this.a.setResult(-1, r7);
            this.a.finish();
        }
    }

    public PhotoEditorFragment() {
        this.o = new a(this);
        this.p = new b(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        o r0 = this.n;
        if (r0 == null) goto L6;
        r0.destroy();
        this.n = null;
        return;
    }

    public final void onViewCreated(View r19, Bundle r20) {
        super.onViewCreated(r19, r20);
        Bundle r1 = getArguments();
        if (r1 == null) goto L13;
        String r4 = r1.getString("key_image_url");
        if (TextUtils.isEmpty(r4) == true) goto L13;
        String r5 = r1.getString("key_result_path");
        String r6 = r1.getString("key_from", "");
        boolean r8 = r1.getBoolean("key_show_save_btn", false);
        boolean r9 = r1.getBoolean("key_show_forward_btn", false);
        String r7 = r1.getString("key_file_key", "");
        this.l = r1.getString("chat_id");
        this.m = r1.getString("message_id");
        Log.i("PhotoEditor", "imageUrl = " + r4);
        Log.i("PhotoEditor", " saveResultPath = " + r5);
        if (TextUtils.isEmpty(r4) == true) goto L13;
        if (TextUtils.isEmpty(r5) == true) goto L13;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r8;
        this.j = r9;
        this.k = r7;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L18;
        finish();
        return;
    L18:
        q0c.a r3 = getActivity();
        if ((r3 instanceof q0c.a) == false) goto L21;
        q0c.a r10 = r3;
    L22:
        o r11 = new o(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.e, this.d, this.o, this.p, r10);
        this.n = r11;
        ((r) r11.getView()).e = getArguments().getParcelableArrayList("key_preset_mask_rects");
        this.n.create();
        com.ss.android.lark.insets.f r12 = WindowInsetsUtils.b(this);
        r12.c(false);
        r12.o(true);
        r12.i(UIUtils.getColor(((BaseFragment) this).mContext, 2131103463));
        return;
    L21:
        r10 = null;
    L13:
        r2 = false;
        goto L15
    }

    public final void onActivityResult(int r5, int r6, Intent r7) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r5, r6, r7);
        if ("from_screenshot_forward_preview".equals(this.h) == false) goto L8;
        if (r5 != 16) goto L8;
        if (r6 != (-1)) goto L8;
        Intent r1 = new Intent();
        r1.putExtra("key_result_forwarded_image", true);
        setResult(-1, r1);
    L8:
        o r8 = this.n;
        if (r8 == null) goto L14;
        r8.getClass();
        if (r5 != 16) goto L15;
        UICallbackExecutor.execute(new n(r8, r6));
        return;
    L15:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.d = r2.inflate(2131558502, r3, false);
        this.e = getActivity();
        return this.d;
    }
}
