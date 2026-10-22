package com.bytedance.android.live.revlink.impl.multianchor.dialog.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/ui/SelectRelinkAnchorListView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/ui/SelectRelinkAnchorListView$a;", "callback", "", "setSelectCallback", "", "", "getSelectedAnchorList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelectRelinkAnchorListView extends LinearLayout {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final ArrayList<String> b;
    public a c;

    public interface a {
        void ro(List<String> r1);
    }

    public SelectRelinkAnchorListView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SelectRelinkAnchorListView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final List<String> getSelectedAnchorList() {
        return this.b;
    }

    public final void b(List<? extends p> r8) {
        Intrinsics.checkNotNullParameter(r8, "linkUsers");
        removeAllViews();
        List<? extends p> r9 = r8;
        Iterator<T> r0 = r9.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Object r1 = r0.next();
        IBaseUser r3 = ((p) r1).getUser();
        if (r3 == null) goto L8;
        String r4 = r3.getIdString();
    L10:
        if (Intrinsics.areEqual(r4, this.a) == false) goto L4;
    L13:
        p r2 = (p) r1;
        if (r2 == null) goto L17;
        IBaseUser r5 = r2.getUser();
        if (r5 == null) goto L17;
    L22:
        if (r5 == null) goto L24;
        addView(a(r5, true));
    L24:
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r9.iterator();
    L26:
        if (r7.hasNext() == false) goto L34;
        Object r10 = r7.next();
        IBaseUser r12 = ((p) r10).getUser();
        if (r12 == null) goto L30;
        String r13 = r12.getIdString();
    L32:
        if ((!Intrinsics.areEqual(r13, this.a)) == false) goto L26;
        r6.add(r10);
        goto L26
    L30:
        r13 = null;
        goto L32
    L34:
        Iterator r14 = r6.iterator();
    L36:
        if (r14.hasNext() == false) goto L40;
        IBaseUser r15 = ((p) r14.next()).getUser();
        if (r15 == null) goto L36;
        addView(a(r15, false));
        goto L36
    L40:
        ArrayList<String> r16 = this.b;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r18 = r9.iterator();
    L42:
        if (r18.hasNext() == false) goto L49;
        IBaseUser r19 = ((p) r18.next()).getUser();
        if (r19 == null) goto L47;
        String r20 = r19.getIdString();
        if (r20 == null) goto L47;
    L48:
        r17.add(r20);
    L47:
        r20 = "";
        goto L48
    L49:
        this.b.removeAll(CollectionsKt.subtract(r16, CollectionsKt.toSet(r17)));
        return;
    L17:
        IRoom r22 = u.a();
        if (r22 == null) goto L20;
        r5 = r22.getOwner();
        goto L22
    L20:
        r5 = null;
        goto L22
    L8:
        r4 = null;
        goto L10
    L12:
        r1 = null;
        goto L13
    }

    public final void setSelectCallback(a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.c = r2;
    }

    public final View a(final IBaseUser r6, final boolean r7) {
        View r0 = LayoutInflater.from(getContext()).inflate(2131567443, this, false);
        TextView r1 = (TextView) r0.findViewById(2131390995);
        String r3 = r6.getNickName();
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        r1.setText(r3);
        ImageUtil.loadRoundImage(r0.findViewById(2131374960), r6.getAvatarThumbKt());
        if (r7 == false) goto L9;
    L12:
        boolean r2 = true;
    L13:
        r0.setSelected(r2);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        r4.leftMargin = s1.f(4.0f);
        r4.rightMargin = s1.f(4.0f);
        Unit r5 = Unit.INSTANCE;
        r0.setLayoutParams(r4);
        r0.setOnClickListener(x0.a(new SelectRelinkAnchorListView$provideItem$3(this, r6, r7)));
        r0.setTag(r6.getIdString());
        return r0;
    L9:
        if (this.b.contains(r6.getIdString()) == true) goto L12;
        r2 = false;
        goto L13
    }

    public SelectRelinkAnchorListView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = u.e();
        this.b = new ArrayList();
    }

    public /* synthetic */ SelectRelinkAnchorListView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
