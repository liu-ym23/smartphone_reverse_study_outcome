package okio;

import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "Utf8")
@SourceDebugExtension({"SMAP\nUtf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utf8.kt\nokio/Utf8\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,559:1\n397#1,9:563\n127#1:572\n406#1,20:574\n440#1,4:595\n127#1:599\n446#1,10:601\n127#1:611\n456#1,5:612\n127#1:617\n461#1,24:618\n500#1,4:643\n127#1:647\n506#1,2:649\n127#1:651\n510#1,10:652\n127#1:662\n520#1,5:663\n127#1:668\n525#1,5:669\n127#1:674\n530#1,28:675\n397#1,9:704\n127#1:713\n406#1,20:715\n440#1,4:736\n127#1:740\n446#1,10:742\n127#1:752\n456#1,5:753\n127#1:758\n461#1,24:759\n500#1,4:784\n127#1:788\n506#1,2:790\n127#1:792\n510#1,10:793\n127#1:803\n520#1,5:804\n127#1:809\n525#1,5:810\n127#1:815\n530#1,28:816\n127#1:844\n127#1:846\n127#1:848\n127#1:850\n127#1:852\n127#1:854\n127#1:856\n127#1:858\n127#1:860\n1#2:560\n74#3:561\n68#3:562\n74#3:573\n68#3:594\n74#3:600\n68#3:642\n74#3:648\n68#3:703\n74#3:714\n68#3:735\n74#3:741\n68#3:783\n74#3:789\n74#3:845\n74#3:847\n74#3:849\n74#3:851\n74#3:853\n74#3:855\n74#3:857\n74#3:859\n74#3:861\n*S KotlinDebug\n*F\n+ 1 Utf8.kt\nokio/Utf8\n*L\n228#1:563,9\n228#1:572\n228#1:574,20\n232#1:595,4\n232#1:599\n232#1:601,10\n232#1:611\n232#1:612,5\n232#1:617\n232#1:618,24\n236#1:643,4\n236#1:647\n236#1:649,2\n236#1:651\n236#1:652,10\n236#1:662\n236#1:663,5\n236#1:668\n236#1:669,5\n236#1:674\n236#1:675,28\n277#1:704,9\n277#1:713\n277#1:715,20\n281#1:736,4\n281#1:740\n281#1:742,10\n281#1:752\n281#1:753,5\n281#1:758\n281#1:759,24\n285#1:784,4\n285#1:788\n285#1:790,2\n285#1:792\n285#1:793,10\n285#1:803\n285#1:804,5\n285#1:809\n285#1:810,5\n285#1:815\n285#1:816,28\n405#1:844\n443#1:846\n455#1:848\n460#1:850\n503#1:852\n507#1:854\n519#1:856\n524#1:858\n529#1:860\n127#1:561\n226#1:562\n228#1:573\n230#1:594\n232#1:600\n234#1:642\n236#1:648\n275#1:703\n277#1:714\n279#1:735\n281#1:741\n283#1:783\n285#1:789\n405#1:845\n443#1:847\n455#1:849\n460#1:851\n503#1:853\n507#1:855\n519#1:857\n524#1:859\n529#1:861\n*E\n"})
public final class h0 {
    @JvmOverloads
    @JvmName(name = "size")
    public static final long a(String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        boolean r13 = true;
        if (r11 < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L50;
        if (r12 < r11) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L48;
        if (r12 <= r10.length()) goto L15;
        r13 = false;
    L15:
        if (r13 == false) goto L46;
        long r16 = 0;
    L17:
        if (r11 >= r12) goto L44;
        char r17 = r10.charAt(r11);
        if (r17 < 128) goto L20;
        if (r17 < 2048) goto L24;
        if (r17 < 55296) goto L43;
        if (r17 > 57343) goto L43;
        int r18 = r11 + 1;
        if (r18 >= r12) goto L34;
        char r19 = r10.charAt(r18);
    L36:
        if (r17 > 56319) goto L42;
        if (r19 < 56320) goto L42;
        if (r19 > 57343) goto L42;
        r16 = r16 + ((long) 4);
        r11 = r11 + 2;
    L42:
        r16 = r16 + 1;
        r11 = r18;
        goto L17
    L34:
        r19 = 0;
    L43:
        int r20 = 3;
    L25:
        r16 = r16 + ((long) r20);
    L21:
        r11 = r11 + 1;
        goto L17
    L24:
        r20 = 2;
        goto L25
    L20:
        r16 = r16 + 1;
        goto L21
    L44:
        return r16;
    L46:
        throw new IllegalArgumentException(("endIndex > string.length: " + r12 + " > " + r10.length()).toString());
    L48:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r12 + " < " + r11).toString());
    L9:
        r15 = false;
        goto L10
    L50:
        throw new IllegalArgumentException(("beginIndex < 0: " + r11).toString());
    L5:
        r14 = false;
        goto L6
    }

    public static /* synthetic */ long b(String r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.length();
    L9:
        return a(r10, r11, r12);
    }
}
