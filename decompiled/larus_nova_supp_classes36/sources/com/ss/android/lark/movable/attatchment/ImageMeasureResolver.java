package com.ss.android.lark.movable.attatchment;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(i.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/movable/attatchment/ImageMeasureResolver;", "Lcom/ss/android/lark/movable/attatchment/IAttachmentMeasureResolver;", "<init>", "()V", "attachmentTypeId", "", "getAttachmentTypeId", "()I", "getSize", "", "", "containerWidth", "propertyString", "", "Companion", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageMeasureResolver implements i {
    public static final a Companion = null;
    private static final String KEY_IMG_TYPE = "img_type";
    private static final String KEY_IMG_URL = "img_url";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageMeasureResolver() {
    }

    @Override // com.ss.android.lark.movable.attatchment.i
    public int getAttachmentTypeId() {
        int r0 = c.a;
        return c.b;
    }

    @Override // com.ss.android.lark.movable.attatchment.i
    public List<Float> getSize(float r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "propertyString");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(new JSONObject(r7));     // Catch: Throwable -> L5
    L7:
        m r1 = null;
        if (Result.isFailure-impl(r8) == false) goto L10;
        r8 = null;
    L10:
        JSONObject r9 = (JSONObject) r8;
        if (r9 == null) goto L13;
        String r2 = r9.optString(KEY_IMG_URL);
        Intrinsics.checkNotNull(r2);
        if ((!StringsKt.isBlank(r2)) == true) goto L18;
        r2 = null;
    L18:
        if (r2 != null) goto L22;
        return CollectionsKt.emptyList();
    L22:
        if (Intrinsics.areEqual(r9.optString(KEY_IMG_TYPE), "photo_with_size") == true) goto L24;
        CopyOnWriteArrayList<Function2<String, Float, m>> r10 = l.a;
        Intrinsics.checkNotNullParameter(r2, "imageKey");
        Iterator r11 = CollectionsKt.asReversedMutable(l.a).iterator();
    L27:
        if (r11.hasNext() == false) goto L31;
        m r3 = (m) ((Function2) r11.next()).invoke(r2, Float.valueOf(r6));
        if (r3 == null) goto L27;
        r1 = r3;
    L31:
        if (r1 == null) goto L33;
        float r12 = r1.a;
        if (r12 <= 0.0f) goto L42;
        if (r1.b <= 0.0f) goto L42;
        return CollectionsKt.listOf(new Float[]{Float.valueOf(r12), Float.valueOf(r1.b)});
    L42:
        return CollectionsKt.emptyList();
    L33:
        return CollectionsKt.emptyList();
    L24:
        return CollectionsKt.emptyList();
    L13:
        return CollectionsKt.emptyList();
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
