package com.larus.business.markdown.impl.markwon.phone;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.business.markdown.api.model.PhoneNumberConfig;
import io.noties.markwon.core.CoreProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lsc.m;
import lsc.x;
import lsc.y;
import msc.o;
import msc.p;
import org.commonmark.node.Link;
import org.commonmark.node.Text;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class PhoneNumberLinkPlugin$PhoneNumberMarker implements o.a {
    public final PhoneNumberConfig a;
    public final Function0<Boolean> b;

    public PhoneNumberLinkPlugin$PhoneNumberMarker(PhoneNumberConfig r2, Function0<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "isLoading");
        this.a = r2;
        this.b = r3;
    }

    public final void a(final m r9, Text r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "visitor");
        Intrinsics.checkNotNullParameter(r10, "node");
        if (((Boolean) this.b.invoke()).booleanValue() == false) goto L5;
        return;
    L5:
        PhoneNumberConfig r0 = this.a;
        if (r0 == null) goto L44;
        Function1<String, String> r1 = r0.getLinkGenerator();
        if (r1 == null) goto L55;
        b r2 = ((b) r10).a;
    L11:
        if (r2 == null) goto L16;
        if ((r2 instanceof Link) == true) goto L14;
        r2 = r2.a;
        goto L11
    L14:
        return;
    L16:
        Lazy r3 = LazyKt.lazy(new PhoneNumberLinkPlugin$PhoneNumberMarker$onTextAdded$factory$2(r9));
        a r4 = a.a;
        String r12 = r10.h;
        String r5 = this.a.getPhoneRegex();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r12, ShareType.TEXT);
        if (r5 != null) goto L19;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == false) goto L25;
        Pattern r7 = null;
    L28:
        if (r7 != null) goto L32;
        r7 = a.b;
        if (r7 != null) goto L32;
        r7 = PatternProtector.compile("(?<![\\d.])((?:(?:\\+86|86)[- ]?)?1[3-9][0-9][- ]?\\d{4}[- ]?\\d{4}|(?:\\(0\\d{2,3}\\)|0\\d{2,3})?[- ]?\\d{7,8}|(?:400|800)[- ]?\\d{3,4}[- ]?\\d{3,4}|(?:\\(0\\d{2,3}\\)|0\\d{2,3})?[- ]?(?:(?:1[0-3]\\d{3})|(?:9(?:[5,6]\\d{3}))|(?:1(?:2\\d{4}|\\d{5})|9(?:[5,6]\\d{4})|100\\d{3}))|\\+\\d{1,3}[- ]?(?:\\(\\d{1,5}\\)|\\d{1,5})[- ]?\\d{1,4}[- ]?\\d{3,5})(?![\\d.])");
        a.b = r7;
    L32:
        Matcher r13 = r7.matcher(r12);
        ArrayList r8 = new ArrayList();
    L34:
        if (r13.find() == false) goto L36;
        r8.add(new a.C0073a(r13.start(), r13.end(), r13.group()));
        goto L34
    L36:
        Iterator r14 = r8.iterator();
    L38:
        if (r14.hasNext() == false) goto L56;
        a.C0073a r15 = (a.C0073a) r14.next();
        int r16 = r15.a + r11;
        int r17 = r15.b + r11;
        String r18 = r15.c;
        CoreProps.g.c(r9.r(), r1.invoke(r18));
        p.d.c(r9.r(), r18);
        x r19 = (x) r3.getValue();
        if (r19 == null) goto L38;
        Object r20 = r19.a(r9.B(), r9.r());
        if (r20 == null) goto L38;
        y.f(r9.builder(), r20, r16, r17);
        goto L38
    L56:
        return;
    L25:
        r7 = a.c;
        if (r7 != null) goto L28;
        r7 = PatternProtector.compile(r5);
        a.c = r7;
        goto L28
    L19:
        if (StringsKt.isBlank(r5) == true) goto L22;
        r6 = false;
        goto L23
    L55:
        return;
    }
}
