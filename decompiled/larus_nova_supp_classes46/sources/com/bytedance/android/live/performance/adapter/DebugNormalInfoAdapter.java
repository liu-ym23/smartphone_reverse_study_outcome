package com.bytedance.android.live.performance.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import f06.b;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tr0.c;
import tr0.h;
import vr0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class DebugNormalInfoAdapter extends RecyclerView.Adapter<h> {
    public final Context a;
    public final List<a> b;
    public final ClipboardManager c;

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public DebugNormalInfoAdapter(Context r2) {
        this.b = new ArrayList();
        this.a = r2;
        if (r2 == null) goto L6;
        this.c = (ClipboardManager) r2.getSystemService("clipboard");
        return;
    }

    public final a A2(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        Iterator r0 = ((ArrayList) this.b).iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        a r2 = (a) r0.next();
        if (r2.b.equals(r5) == false) goto L7;
        return r2;
    L11:
        return null;
    }

    public final void y2(a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r4.b) == true) goto L16;
        String r0 = r4.b;
        String r1 = r4.c;
        a r2 = A2(r0);
        if (r2 != null) goto L10;
        ((ArrayList) this.b).add(r4);
        notifyDataSetChanged();
        return;
    L10:
        if (r1.equals(r2.c) == true) goto L15;
        int r3 = ((ArrayList) this.b).indexOf(r2);
        ListProtector.set(this.b, r3, r4);
        notifyDataSetChanged();
        return;
    L15:
        return;
    }

    public static void z2(ClipboardManager r18, ClipData r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101807);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.setPrimaryClip(r19);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        final TextView r5 = ((h) r3).a;
        if (r5 == null) goto L6;
        a r6 = (a) ListProtector.get(this.b, r4);
        r5.setText(r6.b + ": " + r6.c);
        r5.setOnLongClickListener(new c(this, r5));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        return new h(LayoutInflater.from(this.a).inflate(2131561630, null));
    }
}
