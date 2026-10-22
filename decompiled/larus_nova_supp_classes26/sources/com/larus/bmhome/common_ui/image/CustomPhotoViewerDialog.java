package com.larus.bmhome.common_ui.image;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.bigimg.n1;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l19.f;
import org.json.JSONObject;
import uo8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001$B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bB7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0007\u0010\u0011J\u000f\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J\u0010\u0010\u0015\u001a\u00020\"2\u0006\u0010#\u001a\u00020 H\u0004R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/larus/bmhome/common_ui/image/CustomPhotoViewerDialog;", "Lcom/larus/common_ui/photoviewer/PhotoViewerDialog;", "context", "Landroid/content/Context;", "imageUrls", "", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "eventParams", "Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;", "(Landroid/content/Context;Ljava/util/List;Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;)V", "imageThumbUrls", "", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;)V", "customTransitionAdapter", "Lcom/larus/bmhome/common_ui/image/CustomPhotoTransitionPagerAdapter;", "(Landroid/content/Context;Lcom/larus/bmhome/common_ui/image/CustomPhotoTransitionPagerAdapter;)V", "getCustomTransitionAdapter", "()Lcom/larus/bmhome/common_ui/image/CustomPhotoTransitionPagerAdapter;", "reportParams", "getReportParams", "()Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;", "setReportParams", "(Lcom/larus/bmhome/common_ui/image/PhotoViewerReportParams;)V", "extraView", "Landroid/view/View;", "getExtraView", "()Landroid/view/View;", "setExtraView", "(Landroid/view/View;)V", "getExtraViewLayout", "", "()Ljava/lang/Integer;", "Lorg/json/JSONObject;", "pos", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomPhotoViewerDialog extends PhotoViewerDialog {
    public final CustomPhotoTransitionPagerAdapter n;
    public final k o;
    public final View p;

    public static final class a implements f {
        public final /* synthetic */ CustomPhotoViewerDialog a;

        public final void onTransitionChanged(int r1, float r2) {
        }

        public a(CustomPhotoViewerDialog r1) {
            this.a = r1;
        }

        public final void onTransitionBegin(int r2) {
            View r3 = this.a.p;
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }

        public final void onTransitionEnd(int r2) {
            View r3 = this.a.p;
            if (r3 == null) goto L6;
            r3.setVisibility(0);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public Integer g() {
        return null;
    }

    public final JSONObject h(int r6) {
        JSONObject r0 = new JSONObject();
        k r1 = this.o;
        if (r1 == null) goto L19;
        Map<String, Object> r2 = r1.a;
        if (r2 == null) goto L10;
        Iterator<Map.Entry<String, Object>> r3 = r2.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<String, Object> r4 = r3.next();
        r0.put(r4.getKey(), r4.getValue());
    L10:
        List<Map<String, Object>> r5 = r1.b;
        if (r5 == null) goto L19;
        if (r6 < 0) goto L19;
        if (r6 >= r5.size()) goto L19;
        Iterator r7 = ((Map) ListProtector.get(r5, r6)).entrySet().iterator();
    L17:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r8 = (Map.Entry) r7.next();
        r0.put((String) r8.getKey(), r8.getValue());
    L19:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomPhotoViewerDialog(Context r4, CustomPhotoTransitionPagerAdapter r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "customTransitionAdapter");
        super(r4, r5);
        this.n = r5;
        Window r6 = getWindow();
        if (r6 == null) goto L5;
        r6.setExitTransition(null);
    L5:
        Window r7 = getWindow();
        if (r7 == null) goto L8;
        r7.setReturnTransition(null);
    L8:
        Integer r8 = g();
        if (r8 == null) goto L11;
        View r9 = getLayoutInflater().inflate(r8.intValue(), ((PhotoViewerDialog) this).c, false);
        this.p = r9;
        ((PhotoViewerDialog) this).c.addView(r9, new FrameLayout.LayoutParams(-1, -1));
    L11:
        r5.p = new a(this);
    }

    public CustomPhotoViewerDialog(Context r3, List<n1> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "imageUrls");
        CustomPhotoTransitionPagerAdapter r0 = new CustomPhotoTransitionPagerAdapter();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.k = r4;
        Unit r5 = Unit.INSTANCE;
        this(r3, r0);
    }

    public CustomPhotoViewerDialog(Context r3, List<n1> r4, List<String> r5, k r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "imageUrls");
        Intrinsics.checkNotNullParameter(r6, "eventParams");
        CustomPhotoTransitionPagerAdapter r0 = new CustomPhotoTransitionPagerAdapter();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.k = r4;
        r0.l = r5;
        Unit r7 = Unit.INSTANCE;
        this(r3, r0);
        this.o = r6;
    }
}
