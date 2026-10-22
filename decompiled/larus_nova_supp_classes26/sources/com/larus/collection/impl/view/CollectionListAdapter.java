package com.larus.collection.impl.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.model.MessageCollection;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/collection/impl/view/CollectionListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/platform/model/MessageCollection;", "Lcom/larus/collection/impl/view/BaseCollectionItemHolder;", "callback", "Lcom/larus/collection/impl/view/CollectionListHolderCallback;", "<init>", "(Lcom/larus/collection/impl/view/CollectionListHolderCallback;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectionListAdapter extends ListAdapter<MessageCollection, BaseCollectionItemHolder> {
    public static final CollectionListAdapter$Companion$DIFF_CALLBACK$1 b = null;
    public final com.larus.collection.impl.view.a a;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.collection.impl.view.CollectionListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        b = new CollectionListAdapter$Companion$DIFF_CALLBACK$1();
    }

    public CollectionListAdapter(MineCollectFragment.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        super(b);
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r17, int r18) {
        BaseCollectionItemHolder r0 = (BaseCollectionItemHolder) r17;
        Intrinsics.checkNotNullParameter(r0, "holder");
        final MessageCollection r2 = (MessageCollection) getItem(r18);
        if ((r0 instanceof NormalCollectionItemHolder) == false) goto L5;
        NormalCollectionItemHolder r1 = (NormalCollectionItemHolder) r0;
    L6:
        final NormalCollectionItemHolder r3 = r1;
        if (r3 == null) goto L128;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "item");
        FLogger.a.i("NormalCollectionItemHolder", "bindData, item=" + r2 + ", absoluteAdapterPosition = " + r3.getAbsoluteAdapterPosition());
        String r4 = r2.getCoverUrl();
        String r5 = r2.getSubCoverUrl();
        boolean r6 = false;
        if (r4 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == false) goto L19;
        Group r7 = r3.e;
        if (r7 == null) goto L23;
        e1.o(r7);
    L23:
        e1.d(r3.a, new o(r3, r2));
        r3.a.setOnLongClickListener(new p(r3, r2));
        r3.a.setOnTouchListener(new s(r3));
        TextView r9 = r3.f;
        if (r9 == null) goto L26;
        r9.setText(r2.getTitle());
    L26:
        String r10 = r2.getCollectionBio();
        if (r10 != null) goto L29;
    L32:
        boolean r11 = true;
    L33:
        if (r11 == false) goto L37;
        TextView r12 = r3.g;
        if (r12 == null) goto L43;
        e1.o(r12);
    L43:
        int r13 = md8.b.a;
        Long r14 = r2.getCreateTime();
        String r15 = "";
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L62
        if (r14 == null) goto L47;
        long r19 = r14.longValue();     // Catch: Throwable -> L62
    L49:
        if (r19 > 0) goto L51;
        String r20 = r15;
    L69:
        if (r20.length() != 0) goto L71;
        boolean r21 = true;
    L72:
        if (r21 == false) goto L76;
        TextView r22 = r3.h;
        if (r22 == null) goto L82;
        e1.o(r22);
    L82:
        String r23 = r2.getSource();
        if (r23 != null) goto L85;
    L88:
        boolean r24 = true;
    L89:
        if (r24 == false) goto L93;
        TextView r25 = r3.i;
        if (r25 == null) goto L111;
        e1.o(r25);
    L111:
        Group r26 = r3.e;
        if (r26 != null) goto L114;
    L119:
        if (r6 == false) goto L123;
        FLogger.a.i("NormalCollectionItemHolder", "description, maxLines = 1");
        TextView r27 = r3.g;
        if (r27 == null) goto L129;
        r27.setMaxLines(1);
        return;
    L129:
        return;
    L123:
        FLogger.a.i("NormalCollectionItemHolder", "description, maxLines = 2");
        TextView r28 = r3.g;
        if (r28 == null) goto L131;
        r28.setMaxLines(2);
        return;
    L131:
        return;
    L114:
        if (r26.getVisibility() != 0) goto L116;
        boolean r29 = true;
    L117:
        if (r29 != true) goto L119;
        r6 = true;
        goto L119
    L116:
        r29 = false;
        goto L117
    L93:
        TextView r30 = r3.i;
        if (r30 == null) goto L108;
        TextView r31 = r3.h;
        if (r31 != null) goto L98;
    L103:
        boolean r32 = false;
    L104:
        if (r32 == false) goto L106;
        String r33 = " · " + r2.getSource();
    L107:
        r30.setText(r33);
        goto L108
    L106:
        r33 = r2.getSource();
        goto L107
    L98:
        if (r31.getVisibility() != 0) goto L100;
        boolean r34 = true;
    L101:
        if (r34 != true) goto L103;
        r32 = true;
        goto L104
    L100:
        r34 = false;
    L108:
        TextView r35 = r3.i;
        if (r35 == null) goto L111;
        e1.x(r35);
        goto L111
    L85:
        if (r23.length() == 0) goto L88;
        r24 = false;
        goto L89
    L76:
        TextView r36 = r3.h;
        if (r36 == null) goto L79;
        r36.setText(r20);
    L79:
        TextView r37 = r3.h;
        if (r37 == null) goto L82;
        e1.x(r37);
        goto L82
    L71:
        r21 = false;
        goto L72
    L51:
        Calendar r38 = Calendar.getInstance();     // Catch: Throwable -> L62
        r38.setTime(new Date(r19 * ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY)));     // Catch: Throwable -> L62
        int r110 = r38.get(1);     // Catch: Throwable -> L62
        int r111 = r38.get(2) + 1;     // Catch: Throwable -> L62
        int r39 = r38.get(5);     // Catch: Throwable -> L62
        Calendar r112 = Calendar.getInstance();     // Catch: Throwable -> L62
        r112.setTime(new Date(System.currentTimeMillis()));     // Catch: Throwable -> L62
        int r40 = r112.get(1);     // Catch: Throwable -> L62
        int r113 = r112.get(2) + 1;     // Catch: Throwable -> L62
        int r114 = r112.get(5);     // Catch: Throwable -> L62
        if (r110 != r40) goto L58;
        if (r111 != r113) goto L58;
        if (r39 != r114) goto L58;
        String r41 = AppHost.a.getApplication().getString(2131905623);     // Catch: Throwable -> L62
    L56:
        r20 = r41;
    L58:
        if (r110 != r40) goto L60;
        StringBuilder r42 = new StringBuilder();     // Catch: Throwable -> L62
        r42.append(r111);     // Catch: Throwable -> L62
        r42.append('/');     // Catch: Throwable -> L62
        r42.append(r39);     // Catch: Throwable -> L62
        r41 = r42.toString();     // Catch: Throwable -> L62
        goto L56
    L60:
        StringBuilder r43 = new StringBuilder();     // Catch: Throwable -> L62
        r43.append(r110);     // Catch: Throwable -> L62
        r43.append('/');     // Catch: Throwable -> L62
        r43.append(r111);     // Catch: Throwable -> L62
        r43.append('/');     // Catch: Throwable -> L62
        r43.append(r39);     // Catch: Throwable -> L62
        r41 = r43.toString();     // Catch: Throwable -> L62
        goto L56
    L47:
        r19 = 0;
    L62:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        Object r45 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r46 = Result.exceptionOrNull-impl(r45);
        if (r46 != null) goto L66;
        Object r47 = r45;
    L67:
        r20 = (String) r47;
        goto L69
    L66:
        FLogger.a.e("GuideCollectExt", "formatCollectTime failed, time:" + r14 + ",error:" + r46);
        r47 = r15;
        goto L67
    L37:
        TextView r48 = r3.g;
        if (r48 == null) goto L40;
        r48.setText(r2.getCollectionBio());
    L40:
        TextView r49 = r3.g;
        if (r49 == null) goto L43;
        e1.x(r49);
        goto L43
    L29:
        if (r10.length() == 0) goto L32;
        r11 = false;
        goto L33
    L19:
        Group r50 = r3.e;
        if (r50 == null) goto L22;
        e1.x(r50);
    L22:
        ImageLoaderKt.y(r3.c, r4, "collection_list_item_cover", new q(), 4);
        ImageLoaderKt.y(r3.d, r5, "collection_list_item_sub", new r(), 4);
        goto L23
    L11:
        if (r4.length() == 0) goto L14;
        r8 = false;
        goto L15
    L128:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131562517, r3, false);
        int r6 = 2131367160;
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131367160)) == null) goto L21;
        r6 = 2131367162;
        if (ViewBindings.findChildViewById(r5, 2131367162) == null) goto L21;
        r6 = 2131368849;
        if (ViewBindings.findChildViewById(r5, 2131368849) == null) goto L21;
        r6 = 2131375138;
        if (ViewBindings.findChildViewById(r5, 2131375138) == null) goto L21;
        r6 = 2131375778;
        if (ViewBindings.findChildViewById(r5, 2131375778) == null) goto L21;
        r6 = 2131387007;
        if (ViewBindings.findChildViewById(r5, 2131387007) == null) goto L21;
        r6 = 2131387536;
        if (ViewBindings.findChildViewById(r5, 2131387536) == null) goto L21;
        r6 = 2131388772;
        if (ViewBindings.findChildViewById(r5, 2131388772) == null) goto L21;
        return new NormalCollectionItemHolder(r5, this.a);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
