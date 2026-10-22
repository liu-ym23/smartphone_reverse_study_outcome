package jfb;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.filedetail.impl.folder.manage.adapter.FileInfoAdapter;
import com.ss.android.lark.filedetail.impl.folder.manage.drawable.property.ExtraVideoProperty;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.widget.span.BorderProperty;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends jfb.a<FileInfoAdapter.FileItemViewHolder> {

    public static final class a extends SimpleTarget<Drawable> {
        public final /* synthetic */ LKUIRoundedImageView2 a;
        public final /* synthetic */ Drawable b;
        public final /* synthetic */ b c;
        public final /* synthetic */ boolean d;

        public final void onResourceReady(Object r14) {
            Drawable r1 = (Drawable) r14;
            if (r1 != null) goto L5;
            this.a.setImageDrawable(this.b);
            return;
        L5:
            Context r15 = this.a.getContext();
            b r0 = this.c;
            Intrinsics.checkNotNull(r15);
            boolean r2 = this.d;
            r0.getClass();
            float r3 = UIUtils.dp2px(r15, 32.0f);
            float r4 = UIUtils.dp2px(r15, 28.0f);
            float r5 = UIUtils.dp2px(r15, 100.0f);
            float r6 = UIUtils.dp2px(r15, 84.0f);
            int r7 = r1.getIntrinsicWidth();
            float r8 = r1.getIntrinsicHeight();
            float r9 = r5 * r8;
            float r10 = r7;
            if (r9 >= (r4 * r10)) goto L8;
            float r11 = r4 / r8;
        L15:
            float r12 = r11;
            float r13 = r6 - (r8 * r11);
            float r16 = r12;
        L16:
            mfb.a.C0259a r17 = new mfb.a.C0259a();
            r17.b = (r5 - (r10 * r16)) * 0.5f;
            r17.c = r13;
            r17.d = r16;
            r17.a = r2;
            Intrinsics.checkNotNullParameter(r1, "drawable");
            mfb.a r18 = new mfb.a(r1, r5, r6, r17.a, r17.b, r17.c, r17.d);
            BorderProperty r19 = new BorderProperty(UIUtils.getColor(r15, 2131103351), UIUtils.dp2px(r15, 0.5f), UIUtils.dp2px(r15, 5.0f));
            Intrinsics.checkNotNullParameter(r15, "context");
            Intrinsics.checkNotNullParameter(r15, "context");
            Drawable r20 = UDIconUtils.getIconDrawable(r15, 2131256132, UIUtils.getColor(r15, 2131106521));
            Intrinsics.checkNotNullParameter(r15, "context");
            float r21 = UIUtils.dp2px(r15, 24);
            Intrinsics.checkNotNullParameter(r15, "context");
            int r22 = UIUtils.getColor(r15, 2131103546);
            Intrinsics.checkNotNullParameter(r15, "context");
            int r23 = UIUtils.getColor(r15, 2131106513);
            Intrinsics.checkNotNullParameter(r15, "context");
            float r24 = UIUtils.dp2px(r15, 12);
            Intrinsics.checkNotNullParameter(r15, "context");
            this.a.setImageDrawable(new kfb.b(r18, r19, new ExtraVideoProperty(r15, r21, r22, r23, r24, UIUtils.dp2px(r15, 5), r20), new lfb.a()));
            return;
        L8:
            float r25 = r6 * r10;
            if (r25 >= (r3 * r8)) goto L12;
            r16 = r3 / r10;
            r13 = (r6 - (r8 * r16)) * 0.5f;
            goto L16
        L12:
            if (r25 >= r9) goto L14;
            r16 = r6 / r8;
            r13 = 0.0f;
            goto L16
        L14:
            r11 = r5 / r10;
            goto L15
        }

        public a(LKUIRoundedImageView2 r1, Drawable r2, b r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public b() {
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.adapter.b
    public final RecyclerView.ViewHolder a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131561505, r4, false);
        Intrinsics.checkNotNull(r5);
        return new FileInfoAdapter.FileItemViewHolder(r5);
    }

    @Override // jfb.a
    public final Pair<String, String> c(TextView r19, nfb.a r20) {
        Intrinsics.checkNotNullParameter(r19, "textView");
        Intrinsics.checkNotNullParameter(r20, Keys.API_RETURN_KEY_DATA);
        int r3 = UIUtils.dp2px(r19.getContext(), 100.0f);
        if (r19.getPaint().measureText(r20.c) <= r3) goto L5;
        boolean r4 = true;
    L6:
        StringBuilder r5 = new StringBuilder();
        r5.append(FileUtils.h(r20.d));
        if (r4 == false) goto L9;
        String r6 = BuildConfig.FLAVOR;
    L10:
        r5.append(r6);
        String r7 = r5.toString();
        int r8 = com.ss.android.lark.filedetail.impl.folder.manage.adapter.a.a;
        String r1 = r20.c;
        Intrinsics.checkNotNullParameter(r19, "textView");
        Intrinsics.checkNotNullParameter(r1, "content");
        if (r19.getEllipsize() != TextUtils.TruncateAt.MIDDLE) goto L44;
        int r2 = r19.getMaxLines();
        if (r2 < 2) goto L44;
        StaticLayout r21 = r12;
        StaticLayout r12 = new StaticLayout(r1, r19.getPaint(), r3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        int r9 = r21.getLineCount();
        ArrayList r10 = new ArrayList();
        IntProgression r11 = RangesKt.step(RangesKt.until(0, r9), 1);
        int r13 = r11.getFirst();
        int r14 = r11.getLast();
        int r15 = r11.getStep();
        if (r15 <= 0) goto L19;
        if (r13 > r14) goto L19;
    L21:
        StaticLayout r16 = r21;
        r10.add(new Point(r16.getLineStart(r13), r16.getLineEnd(r13)));
        if (r13 == r14) goto L25;
        r13 = r13 + r15;
        r21 = r16;
    L25:
        if (r10.size() <= r2) goto L44;
        int r17 = (r2 - 1) / 2;
        String r18 = r1.substring(0, ((Point) ListProtector.get(r10, r17)).y);
        String r22 = r1.substring(((Point) ListProtector.get(r10, CollectionsKt.getLastIndex(r10) - ((r2 - r17) - 1))).x);
    L29:
        if (r22.length() <= 0) goto L31;
        boolean r23 = true;
    L33:
        if (r23 == false) goto L42;
        if (new StaticLayout(r18 + "..." + r22, r19.getPaint(), r3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount() <= r2) goto L42;
        int r24 = StringsKt.indexOf$default(r22, " ", 0, false, 6, null);
        if (r24 != (-1)) goto L39;
        int r25 = 1;
    L40:
        r22 = r22.substring(r25);
        goto L29
    L39:
        r25 = r24 + 1;
    L42:
        r1 = r18 + "..." + r22;
        goto L44
    L31:
        r23 = false;
    L19:
        if (r15 >= 0) goto L25;
        if (r14 > r13) goto L25;
    L44:
        return TuplesKt.to(r1, r7);
    L9:
        r6 = "\n";
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    @Override // jfb.a
    public final SimpleTarget<Drawable> d(LKUIRoundedImageView2 r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return new a(r2, UIUtils.getDrawable(r2.getContext(), r3), this, r4);
    }
}
