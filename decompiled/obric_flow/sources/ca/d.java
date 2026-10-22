package ca;

import android.animation.Keyframe;
import android.app.ApplicationExitInfo;
import android.view.View;
import com.bytedance.forest.model.o;
import com.bytedance.ies.bullet.service.base.s;
import com.bytedance.ies.bullet.service.base.t;
import com.bytedance.ies.bullet.service.base.u;
import com.bytedance.ies.bullet.service.base.w;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.obric.flow.cardlistpage.data.WidgetCardTemplate;
import java.io.File;
import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import l9.q;
import org.threeten.bp.OffsetDateTime;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1155a;

    public /* synthetic */ d(int r5) {
        this.f1155a = r5;
    }

    @Override // java.util.Comparator
    public final int compare(Object r10, Object r11) {
        switch(this.f1155a) {
            case 0: goto L100;
            case 1: goto L98;
            case 2: goto L96;
            case 3: goto L94;
            case 4: goto L92;
            case 5: goto L84;
            case 6: goto L83;
            case 7: goto L81;
            case 8: goto L79;
            case 9: goto L77;
            case 10: goto L75;
            case 11: goto L73;
            case 12: goto L71;
            case 13: goto L62;
            case 14: goto L53;
            case 15: goto L52;
            case 16: goto L50;
            case 17: goto L48;
            case 18: goto L46;
            case 19: goto L44;
            case 20: goto L42;
            case 21: goto L40;
            case 22: goto L38;
            case 23: goto L36;
            case 24: goto L20;
            case 25: goto L19;
            case 26: goto L14;
            case 27: goto L13;
            case 28: goto L8;
            default: goto L4;
        };
    L4:
        org.threeten.bp.chrono.g r12 = (org.threeten.bp.chrono.g) r10;
        org.threeten.bp.chrono.g r13 = (org.threeten.bp.chrono.g) r11;
        int r5 = jm.c.j(r12.toEpochSecond(), r13.toEpochSecond());
        if (r5 == 0) goto L7;
        return r5;
    L7:
        return jm.c.j(r12.toLocalTime().toNanoOfDay(), r13.toLocalTime().toNanoOfDay());
    L8:
        org.threeten.bp.chrono.c r14 = (org.threeten.bp.chrono.c) r10;
        org.threeten.bp.chrono.c r15 = (org.threeten.bp.chrono.c) r11;
        int r16 = jm.c.j(r14.toLocalDate().toEpochDay(), r15.toLocalDate().toEpochDay());
        if (r16 == 0) goto L11;
        return r16;
    L11:
        return jm.c.j(r14.toLocalTime().toNanoOfDay(), r15.toLocalTime().toNanoOfDay());
    L14:
        OffsetDateTime r17 = (OffsetDateTime) r10;
        OffsetDateTime r18 = (OffsetDateTime) r11;
        int r19 = jm.c.j(r17.toEpochSecond(), r18.toEpochSecond());
        if (r19 == 0) goto L17;
        return r19;
    L17:
        return jm.c.j(r17.getNano(), r18.getNano());
    L20:
        String r20 = (String) r10;
        String r21 = (String) r11;
        Intrinsics.checkNotNullParameter(r20, "a");
        Intrinsics.checkNotNullParameter(r21, "b");
        int r22 = Math.min(r20.length(), r21.length());
        int r23 = 4;
    L22:
        if (r23 >= r22) goto L29;
        char r24 = r20.charAt(r23);
        char r25 = r21.charAt(r23);
        if (r24 != r25) goto L26;
        r23 = r23 + 1;
        goto L22
    L26:
        if (Intrinsics.compare(r24, r25) < 0) goto L107;
        return 1;
    L107:
        return -1;
    L29:
        int r26 = r20.length();
        int r27 = r21.length();
        if (r26 == r27) goto L33;
        if (r26 < r27) goto L107;
        return 1;
    L33:
        return 0;
    L53:
        View r28 = (View) r11;
        Integer r29 = UIGroup.getViewZIndex((View) r10);
        Integer r30 = 0;
        if (r29 != null) goto L56;
        r29 = r30;
    L56:
        Integer r31 = UIGroup.getViewZIndex(r28);
        if (r31 == null) goto L61;
        r30 = r31;
    L61:
        return r29.intValue() - r30.intValue();
    L62:
        LynxBaseUI r32 = (LynxBaseUI) r10;
        LynxBaseUI r33 = (LynxBaseUI) r11;
        if (r32.getTranslationZ() <= r33.getTranslationZ()) goto L66;
        return 1;
    L66:
        if (r32.getTranslationZ() != r33.getTranslationZ()) goto L68;
        return 0;
    L68:
        return -1;
    L84:
        long r34 = ((com.bytedance.crash.upload.f) r10).f4113i;
        long r35 = ((com.bytedance.crash.upload.f) r11).f4113i;
        if (r34 <= r35) goto L87;
        return -1;
    L87:
        if (r34 != r35) goto L89;
        return 0;
    L89:
        return 1;
    L13:
        return jm.c.j(((org.threeten.bp.chrono.b) r10).toEpochDay(), ((org.threeten.bp.chrono.b) r11).toEpochDay());
    L19:
        return ((String) r11).compareTo((String) r10);
    L36:
        return (int) (((q) r10).f19587b - ((q) r11).f19587b);
    L38:
        return ((String) r11).compareTo((String) r10);
    L40:
        return ((Comparable) r10).compareTo(r11);
    L42:
        return (int) (((ApplicationExitInfo) r11).getTimestamp() - ((ApplicationExitInfo) r10).getTimestamp());
    L44:
        return Integer.compare(((gr.f) r10).f17146a, ((gr.f) r11).f17146a);
    L46:
        return ((fr.e) r10).f17000b - ((fr.e) r11).f17000b;
    L48:
        return Integer.compare(((JavaOnlyMap) r10).getInt("position"), ((JavaOnlyMap) r11).getInt("position"));
    L50:
        return ComparisonsKt.compareValues(Integer.valueOf(((WidgetCardTemplate) r10).getOrder()), Integer.valueOf(((WidgetCardTemplate) r11).getOrder()));
    L52:
        return ComparisonsKt.compareValues(Integer.valueOf(((com.obric.flow.cardlistpage.data.q) r10).e), Integer.valueOf(((com.obric.flow.cardlistpage.data.q) r11).e));
    L71:
        return Float.compare(((Keyframe) r10).getFraction(), ((Keyframe) r11).getFraction());
    L73:
        return ComparisonsKt.compareValues(Long.valueOf(((com.bytedance.lynx.service.reporter.performance.d) r11).f6849b), Long.valueOf(((com.bytedance.lynx.service.reporter.performance.d) r10).f6849b));
    L75:
        return ComparisonsKt.compareValues(Integer.valueOf(((w) r11).e), Integer.valueOf(((w) r10).e));
    L77:
        return ComparisonsKt.compareValues(Integer.valueOf(((s) r11).f6004b), Integer.valueOf(((s) r10).f6004b));
    L79:
        return ComparisonsKt.compareValues(Integer.valueOf(((u) r11).f6009b), Integer.valueOf(((u) r10).f6009b));
    L81:
        return ComparisonsKt.compareValues(Integer.valueOf(((t) r11).f6007b), Integer.valueOf(((t) r10).f6007b));
    L83:
        return ComparisonsKt.compareValues(Integer.valueOf(((o) r10).e), Integer.valueOf(((o) r11).e));
    L92:
        return ((Comparable) r10).compareTo((Comparable) r11);
    L94:
        return Long.compare(((File) r10).lastModified(), ((File) r11).lastModified());
    L96:
        return ComparisonsKt.compareValues(((Thread) ((Map.Entry) r10).getKey()).getName(), ((Thread) ((Map.Entry) r11).getKey()).getName());
    L98:
        return ((Comparable) r10).compareTo((Comparable) r11);
    L100:
        return ((c) r10).f1152a - ((c) r11).f1152a;
    }
}
