package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.vm.MediaMultiAnchorStartViewModel;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/dialog/MediaMultiAnchorStartDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorStartDialog extends LiveDialogFragment {
    public static final /* synthetic */ int h = 0;
    public Map<Integer, View> d;
    public int e;
    public int f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final MediaMultiAnchorStartViewModel T90() {
        return (MediaMultiAnchorStartViewModel) this.g.getValue();
    }

    public final void updateTitle() {
        List<User> r0 = T90().getOnLineList();
        ((TextView) S90(2131388913)).setText(s1.B(2131920236));
        int r2 = s1.y() - UtilityKotlinExtentionsKt.i(142);
        ((TextView) S90(2131388772)).setMaxWidth(r2);
        List<User> r4 = r0;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        String r7 = BuildConfig.FLAVOR;
        if (r5 == true) goto L41;
        ArrayList r6 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L21;
        Object r8 = r1.next();
        User r9 = (User) r8;
        o0.a r10 = o0.a;
        if (r9 == null) goto L17;
        String r11 = r9.getIdStr();
    L18:
        String r13 = jc1.k.n(IUserService.class).user().n();
        r10.getClass();
        if ((!o0.a.a(r11, r13)) == false) goto L13;
        r6.add(r8);
        goto L13
    L17:
        r11 = null;
        goto L18
    L21:
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r14 = r6.iterator();
    L23:
        if (r14.hasNext() == false) goto L30;
        User r15 = (User) r14.next();
        if (r15 == null) goto L28;
        String r16 = r15.getNickName();
        if (r16 == null) goto L28;
    L29:
        r3.add(r16);
    L28:
        r16 = BuildConfig.FLAVOR;
        goto L29
    L30:
        String r17 = CollectionsKt.joinToString$default(r3, "、", null, null, 0, null, null, 62, null);
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;
        String r19 = String.format(s1.B(2131920260), Arrays.copyOf(new Object[]{r17}, 1));
        float r20 = ((TextView) S90(2131388772)).getPaint().measureText(r17);     // Catch: Exception -> L38
        float r110 = ((TextView) S90(2131388772)).getPaint().measureText(r19);     // Catch: Exception -> L38
        float r21 = r2;
        if (r110 <= r21) goto L40;
        float r23 = r21 - (r110 - r20);     // Catch: Exception -> L38
        float r24 = (this.e * r3.size()) + (this.f * 2);     // Catch: Exception -> L38
        float r25 = r23 - r24;     // Catch: Exception -> L38
        if (r25 <= r24) goto L41;
        final int r26 = (int) (r25 / (r3.size() * UtilityKotlinExtentionsKt.i(13)));     // Catch: Exception -> L38
        r7 = String.format(s1.B(2131920260), Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(r3, "...、", null, "...", 0, null, new AnonymousClass1(r26), 26, null)}, 1));     // Catch: Exception -> L38
    L40:
        r7 = r19;
    L38:
        e = move-exception;
        ALogger.e("MultiAnchorPkStartDialogNew--getTitle error", e);
    L41:
        ((TextView) S90(2131388772)).setText(r7);
        return;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r5 = false;
        goto L9
    }

    public MediaMultiAnchorStartDialog() {
        this.d = new LinkedHashMap();
        this.e = UtilityKotlinExtentionsKt.i(20);
        this.f = UtilityKotlinExtentionsKt.i(20);
        System.currentTimeMillis();
        this.g = LazyKt.lazy(new MediaMultiAnchorStartDialog$viewModel$2(this));
    }

    public final void U90() {
        String r2 = null;
        if (MediaMultiAnchorStartViewModel.isOrganizer$default(T90(), null, 1, null) == true) goto L9;
        ((LinearLayout) S90(2131378701)).setBackgroundResource(2131249509);
        ((ImageView) S90(2131375983)).setVisibility(8);
        TextView r0 = (TextView) S90(2131390101);
        Context r3 = getContext();
        if (r3 == null) goto L7;
        r2 = r3.getString(2131920312);
    L7:
        r0.setText(r2);
        ((TextView) S90(2131390101)).setTextColor(s1.h(2131108405));
        return;
    L9:
        if (T90().isOverLimit() == false) goto L14;
        ((LinearLayout) S90(2131378701)).setBackgroundResource(2131249509);
        ((ImageView) S90(2131375983)).setVisibility(8);
        TextView r1 = (TextView) S90(2131390101);
        Context r4 = getContext();
        if (r4 == null) goto L13;
        r2 = r4.getString(2131920258);
    L13:
        r1.setText(r2);
        ((TextView) S90(2131390101)).setTextColor(s1.h(2131108405));
        return;
    L14:
        ((ImageView) S90(2131375983)).setVisibility(0);
        ((LinearLayout) S90(2131378701)).setBackgroundResource(2131249508);
        TextView r5 = (TextView) S90(2131390101);
        Context r6 = getContext();
        if (r6 == null) goto L17;
        r2 = r6.getString(2131920288);
    L17:
        r5.setText(r2);
        ((TextView) S90(2131390101)).setTextColor(-1);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954578);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ImageView r4 = (ImageView) S90(2131383571);
        if (r4 == null) goto L5;
        r4.setOnClickListener(new t(this));
    L5:
        LinearLayout r5 = (LinearLayout) S90(2131378701);
        if (r5 == null) goto L8;
        r5.setOnClickListener(new u(this));
    L8:
        this.f = (int) ((TextView) S90(2131388772)).getPaint().measureText(" ");
        this.e = (int) ((TextView) S90(2131388772)).getPaint().measureText("...、");
        U90();
        updateTitle();
        T90().getFinishState().observe(this, new r(this));
        T90().getOnlineStateNotify().observe(this, new s(this));
        T90().loadData();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566916, r3, false);
    }
}
