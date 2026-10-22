package wy8;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.api.params.VideoParam;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.api.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final List<o> a(CameraOutputContext r18) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        List<OutputParam> r0 = r18.getOutputParamList();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L60;
        OutputParam r3 = (OutputParam) r2.next();
        o r4 = null;
        if (r3 != null) goto L12;
    L58:
        if (r4 == null) goto L7;
        r1.add(r4);
        goto L7
    L12:
        if (r3.getResultType() != OutputParam.ResultType.VIDEO) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L19;
        VideoParam r6 = r3.getVideoParam();
        if (r6 == null) goto L22;
        String r7 = r6.getPath();
    L23:
        if (r7 == null) goto L58;
        if ((true ^ StringsKt.isBlank(r7)) == false) goto L27;
        String r10 = r7;
    L28:
        if (r10 == null) goto L58;
        if (r5 == false) goto L32;
        PreviewMediaType r8 = PreviewMediaType.VIDEO;
    L33:
        PreviewMediaType r11 = r8;
        if (r5 == false) goto L38;
        VideoParam r9 = r3.getVideoParam();
        if (r9 == null) goto L42;
        int r12 = r9.getWidth();
    L41:
        int r13 = r12;
    L43:
        if (r5 == false) goto L47;
        VideoParam r14 = r3.getVideoParam();
        if (r14 == null) goto L51;
        int r15 = r14.getHeight();
    L50:
        int r16 = r15;
    L52:
        if (r5 == false) goto L56;
        VideoParam r17 = r3.getVideoParam();
        if (r17 == null) goto L56;
        long r19 = r17.getDuration();
    L57:
        r4 = new o(r10, r10, r11, null, r13, r16, r19, 8);
    L56:
        r19 = 0;
    L51:
        r16 = 0;
        goto L52
    L47:
        ImageParam r20 = r3.getImageParam();
        if (r20 == null) goto L51;
        r15 = r20.getHeight();
    L42:
        r13 = 0;
        goto L43
    L38:
        ImageParam r21 = r3.getImageParam();
        if (r21 == null) goto L42;
        r12 = r21.getWidth();
        goto L41
    L32:
        r8 = PreviewMediaType.IMAGE;
        goto L33
    L27:
        r10 = null;
    L22:
        r7 = null;
        goto L23
    L19:
        ImageParam r22 = r3.getImageParam();
        if (r22 == null) goto L22;
        r7 = r22.getPath();
        goto L23
    L14:
        r5 = false;
        goto L15
    L60:
        return r1;
    }
}
