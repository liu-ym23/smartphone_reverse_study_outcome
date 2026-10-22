package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.h;
import com.ss.android.lark.officesdk.minutes.ui.style.b;
import com.ss.android.lark.officesdk.minutes.ui.style.c;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fBo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00126\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u00132\n\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/language/MmRecordingLanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/language/MmRecordingLanguageAdapter$ViewHolder;", "context", "Landroid/content/Context;", "data", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;", "currentLanguage", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "isTranslation", "", "onItemClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppbrandHostConstants.Schema_Meta.NAME, "selected", "preCheckSuccess", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;ZLkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingLanguageAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Context a;
    public final List<h> b;
    public final h c;
    public final MmRecordingUILaunchMode d;
    public final boolean e;
    public final Function2<h, Boolean, Unit> f;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/language/MmRecordingLanguageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/language/MmRecordingLanguageAdapter;Landroid/view/View;)V", "tvLanguage", "Landroid/widget/TextView;", "ivChecked", "Landroid/widget/ImageView;", "dividerLine", "bind", "", "item", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/language/MmSubtitleLanguage;", "position", "", "totalSize", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;
        public final View c;
        public final /* synthetic */ MmRecordingLanguageAdapter d;

        public ViewHolder(MmRecordingLanguageAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.d = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131390042);
            this.b = (ImageView) r3.findViewById(2131375903);
            this.c = r3.findViewById(2131369203);
        }
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        ViewHolder r11 = (ViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        final h r0 = (h) ListProtector.get(this.b, r10);
        int r1 = this.b.size();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "item");
        r11.a.setText(r0.b);
        View r2 = ((RecyclerView.ViewHolder) r11).itemView;
        int r5 = 0;
        String r7 = null;
        if (StringsKt.startsWith$default(r0.a.toLowerCase(Locale.ROOT), "en", false, 2, null) == false) goto L5;
        int r3 = 2131377144;
    L6:
        r2.setId(r3);
        View r4 = ((RecyclerView.ViewHolder) r11).itemView;
        if (r1 != 1) goto L9;
        Drawable r6 = b.a(r11.d.a).m(r11.d.a);
    L15:
        r4.setBackground(r6);
        View r8 = r11.c;
        int r12 = 8;
        if (r10 != (r1 - 1)) goto L18;
        int r13 = 8;
    L19:
        r8.setVisibility(r13);
        String r14 = r0.a;
        h r15 = r11.d.c;
        if (r15 == null) goto L22;
        r7 = r15.a;
    L22:
        final boolean r16 = Intrinsics.areEqual(r14, r7);
        ImageView r17 = r11.b;
        if (r16 == false) goto L25;
        r12 = 0;
    L25:
        r17.setVisibility(r12);
        e r18 = e.a;
        MmRecordingUILaunchMode r19 = r11.d.d;
        r18.getClass();
        boolean r20 = e.b(r19).getCapability().a();
        TextView r21 = r11.a;
        int r22 = h18.e.a;
        Context r23 = r11.d.a;
        if (r16 == false) goto L29;
        if (r20 == false) goto L29;
        r5 = 1;
    L29:
        r21.setTypeface(h18.e.b(r23, r5));
        View r24 = ((RecyclerView.ViewHolder) r11).itemView;
        final MmRecordingLanguageAdapter r25 = r11.d;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r24, new MmRecordingLanguageAdapter$ViewHolder$bind$1(r16, r25, r0));
        return;
    L18:
        r13 = 0;
        goto L19
    L9:
        if (r10 != 0) goto L12;
        r6 = b.a(r11.d.a).r(r11.d.a);
        goto L15
    L12:
        if (r10 != (r1 - 1)) goto L14;
        r6 = b.a(r11.d.a).n(r11.d.a);
        goto L15
    L14:
        r6 = b.a(r11.d.a).b(r11.d.a);
        goto L15
    L5:
        r3 = -1;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        e r5 = e.a;
        MmRecordingUILaunchMode r0 = this.d;
        r5.getClass();
        View r6 = e.b(r0).getLayout().r(LayoutInflater.from(c.c(this.a, this.d)), r3);
        if (this.e == false) goto L5;
        int r7 = uvb.b.a;
        uvb.b.a(r6, 2131390042, uvb.c.F);
        uvb.b.a(r6, 2131375903, uvb.c.G);
    L7:
        return new ViewHolder(this, r6);
    L5:
        int r8 = uvb.b.a;
        uvb.b.a(r6, 2131390042, uvb.c.B);
        uvb.b.a(r6, 2131375903, uvb.c.C);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingLanguageAdapter(Context r2, List<h> r3, h r4, MmRecordingUILaunchMode r5, boolean r6, Function2<? super h, ? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r5, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r7, "onItemClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
