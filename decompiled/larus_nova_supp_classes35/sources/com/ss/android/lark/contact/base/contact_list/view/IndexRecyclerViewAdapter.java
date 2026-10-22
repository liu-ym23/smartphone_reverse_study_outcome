package com.ss.android.lark.contact.base.contact_list.view;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u00020\u0005:\u0002 !B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\nH\u0016J\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH&J\u0016\u0010\u001e\u001a\u00120\u001fR\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/ss/android/lark/contact/base/contact_list/view/IndexRecyclerViewAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "DATA", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/ss/android/lark/contact/base/contact_list/view/IndexDataOwner;", "<init>", "()V", "indexDataObservers", BuildConfig.FLAVOR, "Lcom/ss/android/lark/contact/base/contact_list/view/IndexDataOwner$IndexDataObserver;", "indices", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "notifyIndexDataChanged", BuildConfig.FLAVOR, "isIndexEnable", BuildConfig.FLAVOR, "()Z", "setIndexEnable", "(Z)V", "getIndices", BuildConfig.FLAVOR, "registerDataObserver", "observer", "unregisterDataObserver", "genIndexData", "items", BuildConfig.FLAVOR, "getIndexFinder", "Lcom/ss/android/lark/contact/base/contact_list/view/IndexRecyclerViewAdapter$IndexFinder;", "IndexFinder", "IndexSection", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class IndexRecyclerViewAdapter<VH extends RecyclerView.ViewHolder, DATA> extends LarkRecyclerViewBaseAdapter<VH, DATA> {
    public final List<d> a;
    public final Map<Integer, String> b;
    public boolean c;

    public final class a {
        public final /* synthetic */ IndexRecyclerViewAdapter<VH, DATA> a;

        public a(IndexRecyclerViewAdapter r1) {
            this.a = r1;
        }

        public final b a(int r10) {
            ArrayList r0 = new ArrayList(((LinkedHashMap) this.a.b).keySet());
            int r7 = r0.size();
            int r3 = r7 - 1;
            int r1 = 0;
        L4:
            if (r1 >= r3) goto L15;
            if (((Number) ListProtector.get(r0, r1)).intValue() > r10) goto L14;
            int r4 = r1 + 1;
            if (r10 >= ((Number) ListProtector.get(r0, r4)).intValue()) goto L14;
            Integer r11 = (Integer) ListProtector.get(r0, r1);
            String r5 = (String) ((LinkedHashMap) this.a.b).get(r11);
            if (r5 != null) goto L12;
            return null;
        L12:
            Intrinsics.checkNotNull(r11);
            return new b(r1, r5, r11.intValue(), ((Number) ListProtector.get(r0, r4)).intValue(), r7);
        L14:
            r1 = r1 + 1;
            goto L4
        L15:
            if (r7 > 0) goto L17;
        L23:
            return null;
        L17:
            if (r10 < ((Number) ListProtector.get(r0, r3)).intValue()) goto L23;
            String r6 = (String) ((LinkedHashMap) this.a.b).get((Integer) ListProtector.get(r0, r3));
            if (r6 != null) goto L22;
            return null;
        L22:
            return new b(r3, r6, ((Number) ListProtector.get(r0, r3)).intValue(), Integer.MAX_VALUE, r7);
        }

        public final b b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "indexName");
            ArrayList r0 = new ArrayList(((LinkedHashMap) this.a.b).keySet());
            int r7 = r0.size();
            int r3 = 0;
        L3:
            if (r3 >= r7) goto L13;
            Integer r1 = (Integer) ListProtector.get(r0, r3);
            if (TextUtils.equals(r10, (CharSequence) ((LinkedHashMap) this.a.b).get(r1)) == true) goto L7;
            r3 = r3 + 1;
            goto L3
        L7:
            if (r3 != (r0.size() - 1)) goto L9;
            Integer r2 = Integer.MAX_VALUE;
        L10:
            Intrinsics.checkNotNull(r1);
            int r5 = r1.intValue();
            Intrinsics.checkNotNull(r2);
            return new b(r3, r10, r5, r2.intValue(), r7);
        L9:
            r2 = (Integer) ListProtector.get(r0, r3 + 1);
            goto L10
        L13:
            return null;
        }
    }

    public static final class b {
        public final int a;
        public final String b;
        public final int c;
        public final int d;
        public final int e;

        public b(int r2, String r3, int r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r3, "indexName");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public abstract Map<Integer, String> z2(List<? extends DATA> r1);

    public IndexRecyclerViewAdapter() {
        ((LarkRecyclerViewBaseAdapter) this).items = new AnonymousClass1(this);
        this.a = new CopyOnWriteArrayList();
        this.b = new LinkedHashMap();
        this.c = true;
    }

    public static final void y2(IndexRecyclerViewAdapter r2) {
        if (r2.c == false) goto L9;
        Map<Integer, String> r0 = r2.z2(((LarkRecyclerViewBaseAdapter) r2).items);
        ((LinkedHashMap) r2.b).clear();
        r2.b.putAll(r0);
        Iterator r3 = ((CopyOnWriteArrayList) r2.a).iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        ((d) r3.next()).b();
        goto L7
    L11:
        return;
    }

    public final void A2(d r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        if (((CopyOnWriteArrayList) this.a).contains(r2) == true) goto L6;
        ((CopyOnWriteArrayList) this.a).add(r2);
        return;
    }
}
