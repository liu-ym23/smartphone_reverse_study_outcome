package eob;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.keyboard.edittext2.base.c;
import com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlineStrategy;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import fob.d;
import fob.f;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a extends BaseFunctionEditor<hob.b> implements c {
    public static final C0256a f = null;
    public final Map<Class<? extends hob.b>, d<? extends hob.b>> c;
    public final LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> d;
    public final LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> e;

    /* JADX INFO: renamed from: eob.a$a, reason: collision with other inner class name */
    public static final class C0256a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a<a> {
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC0134a
        public final Class<a> a() {
            return this.a.a;
        }

        public C0256a() {
            this.a = new com.ss.android.lark.keyboard.edittext2.base.d(a.class);
        }
    }

    static {
        f = new C0256a();
    }

    public final void V() {
        this.d.clear();
        this.e.clear();
        LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> r0 = this.d;
        Map<Class<? extends hob.b>, d<? extends hob.b>> r1 = this.c;
        LinkedHashMap r2 = new LinkedHashMap(MapsKt.mapCapacity(r1.size()));
        Iterator<T> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r4 = (Map.Entry) r3.next();
        r2.put(r4.getKey(), ((d) r4.getValue()).a(this));
        goto L4
    L6:
        r0.putAll(r2);
        LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> r5 = this.e;
        Map<Class<? extends hob.b>, d<? extends hob.b>> r6 = this.c;
        LinkedHashMap r7 = new LinkedHashMap(MapsKt.mapCapacity(r6.size()));
        Iterator<T> r8 = r6.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.put(r9.getKey(), ((d) r9.getValue()).b(this));
        goto L8
    L10:
        r5.putAll(r7);
    }

    public final void X() {
        com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste.c r0 = com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste.c.a;
        Intrinsics.checkNotNullParameter(r0, "strategy");
        this.c.remove(r0.getType());
        this.d.remove(r0.getType());
        this.e.remove(r0.getType());
    }

    public a() {
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        Y(CollectionsKt.listOf(UrlInlineStrategy.c));
        V();
    }

    public final void U(d<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "strategy");
        this.c.put((Class<? extends hob.b>) r4.getType(), (d<? extends hob.b>) r4);
        LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> r0 = this.d;
        GenericDeclaration r1 = r4.getType();
        r0.put((Class<? extends hob.b>) r1, r4.a(this));
        LinkedHashMap<Class<? extends hob.b>, fob.c<?, ?>> r2 = this.e;
        GenericDeclaration r3 = r4.getType();
        r2.put((Class<? extends hob.b>) r3, r4.b(this));
    }

    public final void Y(List<? extends d<?>> r5) {
        Intrinsics.checkNotNullParameter(r5, LocationHitPoint$ResultType.LIST);
        this.c.clear();
        Map<Class<? extends hob.b>, d<? extends hob.b>> r0 = this.c;
        List<? extends d<?>> r6 = r5;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        d r2 = (d) r7.next();
        r1.add(TuplesKt.to(r2.getType(), r2));
        goto L4
    L6:
        MapsKt.putAll(r0, r1);
        V();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void S(SpannableStringBuilder r1, hob.b r2, int r3) {
        W(r1, r2, r3);
    }

    public void W(SpannableStringBuilder r4, hob.b r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "data");
        String r0 = r5.a;
        r4.append(r0);
        Object r1 = ((LinkedHashMap) this.c).get(r5.getClass());
        if ((r1 instanceof d) == false) goto L5;
        d r2 = (d) r1;
    L6:
        if (r2 != null) goto L9;
        Log.w("AnchorEditor", "onInsert: fount no urlStrategy to handle data, link is " + r5.a);
        return;
    L9:
        fob.b r7 = r2.c(this, r5);
        r4.setSpan(r7, r6, r0.length() + r6, 33);
        Object r8 = r7.e();
        if (r8 == null) goto L13;
        r4.setSpan(r8, r6, r0.length() + r6, 33);
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z(Spannable r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "builder");
        SpannableString r12 = SpannableString.valueOf(r9.subSequence(r10, r11));
        ArrayList r0 = new ArrayList();
        Iterator<fob.c<?, ?>> r1 = this.d.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        fob.c<?, ?> r2 = r1.next();
        if ((r2 instanceof fob.c) == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L10;
        fob.c.a<?> r3 = r2.resolve(r12);
        if (r3.a == false) goto L4;
        D r4 = r3.b;
        if (r4 == 0) goto L4;
        r0.addAll((Collection) r4);
        goto L16
    L10:
        Log.w("AnchorEditor", "resolveUrlByRegexIfNeed: find invalid url resolver");
    L16:
        Iterator r13 = r0.iterator();
    L18:
        if (r13.hasNext() == false) goto L32;
        f.b r5 = (f.b) r13.next();
        IntRange r6 = r5.b;
        hob.b r7 = (hob.b) r5.a;
        int r8 = r6.getFirst() + r10;
        int r14 = r6.getLast() + r10;
        boolean r15 = com.ss.android.lark.keyboard.edittext2.utils.b.c(r9, r8, r14);
        Object r16 = ((LinkedHashMap) this.c).get(r7.getClass());
        if ((r16 instanceof d) == false) goto L22;
        d r17 = (d) r16;
    L23:
        if (r17 != null) goto L25;
        Log.w("AnchorEditor", "resolveUrlByRegexIfNeed: find empty anchor strategy");
    L25:
        if (r14 < r8) goto L26;
        if (r15 == true) goto L18;
        if (r17 == null) goto L18;
        fob.b r18 = r17.c(this, r7);
        r9.setSpan(r18, r8, r14, 33);
        Object r19 = r18.e();
        if (r19 == null) goto L18;
        r9.setSpan(r19, r8, r14, 33);
        goto L18
    L26:
        Log.w("AnchorEditor", "resolveUrlByRegexIfNeed: range.last < range.first, range{" + r8 + ", " + r14 + '}');
        goto L18
    L22:
        r17 = null;
        goto L23
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void T(hob.b r3, SpannableStringBuilder r4, int r5, int r6) {
        hob.b r7 = r3;
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r4, "text");
        RichTextElement r0 = RichTextElementCreator.e(r7.a);
        Map<String, String> r8 = r7.b;
        if (r8 != null) goto L5;
        r8 = MapsKt.emptyMap();
    L5:
        r0.setStyle(r8);
        r4.setSpan(new p(r0, r4.subSequence(r5, r6).toString()), r5, r6, 33);
    }
}
