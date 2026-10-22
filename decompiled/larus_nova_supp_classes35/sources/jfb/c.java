package jfb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.e;
import com.ss.android.lark.filedetail.impl.folder.manage.adapter.FileInfoAdapter;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends jfb.a<FileInfoAdapter.ListFileItemViewHolder> {

    public static final class a extends SimpleTarget<Drawable> {
        public final /* synthetic */ LKUIRoundedImageView2 a;
        public final /* synthetic */ Drawable b;

        public final void onResourceReady(Object r2) {
            Drawable r3 = (Drawable) r2;
            LKUIRoundedImageView2 r0 = this.a;
            if (r3 != null) goto L5;
            r3 = this.b;
        L5:
            r0.setImageDrawable(r3);
        }

        public a(LKUIRoundedImageView2 r1, Drawable r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public c() {
    }

    @Override // com.ss.android.lark.filedetail.impl.folder.manage.adapter.b
    public final RecyclerView.ViewHolder a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563503, r4, false);
        Intrinsics.checkNotNull(r5);
        return new FileInfoAdapter.ListFileItemViewHolder(r5);
    }

    @Override // jfb.a
    public final Pair<String, String> c(TextView r17, nfb.a r18) {
        Intrinsics.checkNotNullParameter(r17, "textView");
        Intrinsics.checkNotNullParameter(r18, Keys.API_RETURN_KEY_DATA);
        StringBuilder r1 = new StringBuilder();
        r1.append(FileUtils.h(r18.d));
        r1.append(' ');
        r1.append(r18.g);
        r1.append(' ');
        int r2 = com.ss.android.lark.filedetail.impl.folder.manage.adapter.a.a;
        Date r4 = new Date(1000 * r18.e);
        boolean r3 = e.h(r4);
        c7c.a r5 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        String r6 = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.a = r6;
        r5.a(DatePreciseness.DAY);
        if (r3 == false) goto L5;
        LengthType r7 = LengthType.SHORT;
    L6:
        r5.c(r7);
        r5.b(DisplayPattern.ABSOLUTE);
        r1.append(c7c.b.a(UIHelper.getContext(), r4, r5));
        return TuplesKt.to(r18.c, r1.toString());
    L5:
        r7 = LengthType.LONG;
        goto L6
    }

    @Override // jfb.a
    public final void b(FileInfoAdapter.FileItemViewHolder r5, boolean r6, boolean r7) {
        FileInfoAdapter.ListFileItemViewHolder r8 = (FileInfoAdapter.ListFileItemViewHolder) r5;
        Intrinsics.checkNotNullParameter(r8, "holder");
        Context r0 = ((RecyclerView.ViewHolder) r8).itemView.getContext();
        int r1 = 0;
        if (r6 == false) goto L5;
        int r2 = UIUtils.getColor(r0, 2131103351);
    L6:
        r8.a.setBorderColor(r2);
        LKUIRoundedImageView2 r3 = r8.a;
        float r4 = 0.0f;
        if (r6 == false) goto L9;
        float r9 = 0.5f;
    L10:
        r3.setBorderWidthInDp(r9);
        LKUIRoundedImageView2 r10 = r8.a;
        if (r6 == false) goto L13;
        r4 = 4.0f;
    L13:
        r10.setRadiusInDp(r4);
        ImageView r11 = r8.d;
        if (r7 == false) goto L16;
        int r12 = 0;
    L17:
        r11.setVisibility(r12);
        ImageView r13 = r8.e;
        if (r7 == true) goto L21;
        r1 = 8;
    L21:
        r13.setVisibility(r1);
        return;
    L16:
        r12 = 8;
        goto L17
    L9:
        r9 = 0.0f;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    @Override // jfb.a
    public final SimpleTarget<Drawable> d(LKUIRoundedImageView2 r1, int r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
        return new a(r1, UIUtils.getDrawable(r1.getContext(), r2));
    }
}
