package kotlin.collections.unsigned;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.MapsKt;
import kotlin.collections.UArraySortingKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\n_UArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _UArrays.kt\nkotlin/collections/unsigned/UArraysKt___UArraysKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,10733:1\n3775#1:10734\n3783#1:10735\n3791#1:10736\n3799#1:10737\n3775#1:10738\n3783#1:10739\n3791#1:10740\n3799#1:10741\n3775#1:10742\n3783#1:10743\n3791#1:10744\n3799#1:10745\n3775#1:10795\n3783#1:10796\n3791#1:10797\n3799#1:10798\n3775#1:10799\n3783#1:10800\n3791#1:10801\n3799#1:10802\n3775#1:10803\n3783#1:10804\n3791#1:10805\n3799#1:10806\n3775#1:10863\n3783#1:10864\n3791#1:10865\n3799#1:10866\n3775#1:10867\n3783#1:10868\n3791#1:10869\n3799#1:10870\n3775#1:10871\n3783#1:10872\n3791#1:10873\n3799#1:10874\n3775#1:10875\n3783#1:10876\n3791#1:10877\n3799#1:10878\n3775#1:10879\n3783#1:10880\n3791#1:10881\n3799#1:10882\n3775#1:10883\n3783#1:10884\n3791#1:10885\n3799#1:10886\n3775#1:10887\n3783#1:10888\n3791#1:10889\n3799#1:10890\n3775#1:10891\n3783#1:10892\n3791#1:10893\n3799#1:10894\n3775#1:10895\n3783#1:10896\n3791#1:10897\n3799#1:10898\n3775#1:10899\n3783#1:10900\n3791#1:10901\n3799#1:10902\n3775#1:10903\n3783#1:10904\n3791#1:10905\n3799#1:10906\n3775#1:10907\n3783#1:10908\n3791#1:10909\n3799#1:10910\n3775#1:10911\n3783#1:10912\n3791#1:10913\n3799#1:10914\n3775#1:10915\n3783#1:10916\n3791#1:10917\n3799#1:10918\n3775#1:10919\n3783#1:10920\n3791#1:10921\n3799#1:10922\n3775#1:10923\n3783#1:10924\n3791#1:10925\n3799#1:10926\n3775#1:10927\n3783#1:10928\n3791#1:10929\n3799#1:10930\n3775#1:10931\n3783#1:10932\n3791#1:10933\n3799#1:10934\n3775#1:10935\n3783#1:10936\n3791#1:10937\n3799#1:10938\n3775#1:10939\n3783#1:10940\n3791#1:10941\n3799#1:10942\n3775#1:10943\n3783#1:10944\n3791#1:10945\n3799#1:10946\n3775#1:10947\n3783#1:10948\n3791#1:10949\n3799#1:10950\n3775#1:10951\n3783#1:10952\n3791#1:10953\n3799#1:10954\n3775#1:10955\n3783#1:10956\n3791#1:10957\n3799#1:10958\n3775#1:10959\n3783#1:10960\n3791#1:10961\n3799#1:10962\n3775#1:10963\n3783#1:10964\n3791#1:10965\n3799#1:10966\n3775#1:10967\n3783#1:10968\n3791#1:10969\n3799#1:10970\n3775#1:10971\n3783#1:10972\n3791#1:10973\n3799#1:10974\n3775#1:10975\n3783#1:10976\n3791#1:10977\n3799#1:10978\n3775#1:10979\n3783#1:10980\n3791#1:10981\n3799#1:10982\n3775#1:10983\n3783#1:10984\n3791#1:10985\n3799#1:10986\n3775#1:10987\n3783#1:10988\n3791#1:10989\n3799#1:10990\n3775#1:10991\n3783#1:10992\n3791#1:10993\n3799#1:10994\n3775#1:10995\n3783#1:10996\n3791#1:10997\n3799#1:10998\n3775#1:10999\n3783#1:11000\n3791#1:11001\n3799#1:11002\n3775#1:11003\n3783#1:11004\n3791#1:11005\n3799#1:11006\n3775#1:11007\n3783#1:11008\n3791#1:11009\n3799#1:11010\n3775#1:11011\n3783#1:11012\n3791#1:11013\n3799#1:11014\n1663#2,6:10746\n1675#2,6:10752\n1639#2,6:10758\n1651#2,6:10764\n1771#2,6:10770\n1783#2,6:10776\n1747#2,6:10782\n1759#2,6:10788\n1#3:10794\n372#4,7:10807\n372#4,7:10814\n372#4,7:10821\n372#4,7:10828\n372#4,7:10835\n372#4,7:10842\n372#4,7:10849\n372#4,7:10856\n*S KotlinDebug\n*F\n+ 1 _UArrays.kt\nkotlin/collections/unsigned/UArraysKt___UArraysKt\n*L\n326#1:10734\n338#1:10735\n350#1:10736\n362#1:10737\n692#1:10738\n702#1:10739\n712#1:10740\n722#1:10741\n733#1:10742\n744#1:10743\n755#1:10744\n766#1:10745\n1718#1:10795\n1735#1:10796\n1752#1:10797\n1769#1:10798\n2546#1:10799\n2563#1:10800\n2580#1:10801\n2597#1:10802\n2913#1:10803\n2929#1:10804\n2945#1:10805\n2961#1:10806\n5573#1:10863\n5593#1:10864\n5613#1:10865\n5633#1:10866\n5654#1:10867\n5676#1:10868\n5698#1:10869\n5720#1:10870\n5833#1:10871\n5852#1:10872\n5871#1:10873\n5890#1:10874\n5912#1:10875\n5941#1:10876\n5970#1:10877\n5999#1:10878\n6024#1:10879\n6049#1:10880\n6074#1:10881\n6099#1:10882\n6129#1:10883\n6152#1:10884\n6175#1:10885\n6198#1:10886\n6221#1:10887\n6244#1:10888\n6267#1:10889\n6290#1:10890\n6311#1:10891\n6334#1:10892\n6357#1:10893\n6380#1:10894\n6403#1:10895\n6424#1:10896\n6445#1:10897\n6466#1:10898\n6487#1:10899\n6508#1:10900\n6529#1:10901\n6550#1:10902\n6569#1:10903\n6590#1:10904\n6611#1:10905\n6632#1:10906\n6655#1:10907\n6678#1:10908\n6701#1:10909\n6724#1:10910\n6745#1:10911\n6766#1:10912\n6787#1:10913\n6808#1:10914\n6825#1:10915\n6840#1:10916\n6855#1:10917\n6870#1:10918\n6889#1:10919\n6908#1:10920\n6927#1:10921\n6946#1:10922\n6961#1:10923\n6976#1:10924\n6991#1:10925\n7006#1:10926\n7025#1:10927\n7044#1:10928\n7063#1:10929\n7082#1:10930\n7104#1:10931\n7133#1:10932\n7162#1:10933\n7191#1:10934\n7216#1:10935\n7241#1:10936\n7266#1:10937\n7291#1:10938\n7321#1:10939\n7344#1:10940\n7367#1:10941\n7390#1:10942\n7413#1:10943\n7436#1:10944\n7459#1:10945\n7482#1:10946\n7503#1:10947\n7526#1:10948\n7549#1:10949\n7572#1:10950\n7595#1:10951\n7616#1:10952\n7637#1:10953\n7658#1:10954\n7679#1:10955\n7700#1:10956\n7721#1:10957\n7742#1:10958\n7761#1:10959\n7782#1:10960\n7803#1:10961\n7824#1:10962\n7847#1:10963\n7870#1:10964\n7893#1:10965\n7916#1:10966\n7937#1:10967\n7958#1:10968\n7979#1:10969\n8000#1:10970\n8017#1:10971\n8032#1:10972\n8047#1:10973\n8062#1:10974\n8081#1:10975\n8100#1:10976\n8119#1:10977\n8138#1:10978\n8153#1:10979\n8168#1:10980\n8183#1:10981\n8198#1:10982\n8416#1:10983\n8441#1:10984\n8466#1:10985\n8491#1:10986\n8516#1:10987\n8541#1:10988\n8566#1:10989\n8591#1:10990\n8615#1:10991\n8639#1:10992\n8663#1:10993\n8687#1:10994\n8712#1:10995\n8737#1:10996\n8762#1:10997\n8787#1:10998\n8809#1:10999\n8834#1:11000\n8859#1:11001\n8884#1:11002\n8909#1:11003\n8935#1:11004\n8961#1:11005\n8987#1:11006\n9012#1:11007\n9037#1:11008\n9062#1:11009\n9087#1:11010\n9113#1:11011\n9138#1:11012\n9163#1:11013\n9188#1:11014\n816#1:10746,6\n826#1:10752,6\n836#1:10758,6\n846#1:10764,6\n856#1:10770,6\n866#1:10776,6\n876#1:10782,6\n886#1:10788,6\n4791#1:10807,7\n4811#1:10814,7\n4831#1:10821,7\n4851#1:10828,7\n4872#1:10835,7\n4893#1:10842,7\n4914#1:10849,7\n4935#1:10856,7\n*E\n"})
class UArraysKt___UArraysKt extends UArraysKt___UArraysJvmKt {
    public UArraysKt___UArraysKt() {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: all-JOV_ifY, reason: not valid java name */
    private static final boolean m563allJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$all");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13))).booleanValue() == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: all-MShoTSo, reason: not valid java name */
    private static final boolean m564allMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$all");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13))).booleanValue() == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: all-jgv0xPQ, reason: not valid java name */
    private static final boolean m565alljgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$all");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13))).booleanValue() == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: all-xTcfx_M, reason: not valid java name */
    private static final boolean m566allxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$all");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13))).booleanValue() == false) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: any--ajY-9A, reason: not valid java name */
    private static final boolean m567anyajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$any");
        return ArraysKt.any(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: any-GBYM_sE, reason: not valid java name */
    private static final boolean m568anyGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$any");
        return ArraysKt.any(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: any-JOV_ifY, reason: not valid java name */
    private static final boolean m569anyJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$any");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13))).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: any-MShoTSo, reason: not valid java name */
    private static final boolean m570anyMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$any");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13))).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: any-QwZRm1k, reason: not valid java name */
    private static final boolean m571anyQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$any");
        return ArraysKt.any(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: any-jgv0xPQ, reason: not valid java name */
    private static final boolean m572anyjgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$any");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13))).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: any-rL5Bavg, reason: not valid java name */
    private static final boolean m573anyrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$any");
        return ArraysKt.any(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: any-xTcfx_M, reason: not valid java name */
    private static final boolean m574anyxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$any");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13))).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: asByteArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m575asByteArrayGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$asByteArray");
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: asIntArray--ajY-9A, reason: not valid java name */
    private static final int[] m576asIntArrayajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$asIntArray");
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: asLongArray-QwZRm1k, reason: not valid java name */
    private static final long[] m577asLongArrayQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$asLongArray");
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: asShortArray-rL5Bavg, reason: not valid java name */
    private static final short[] m578asShortArrayrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$asShortArray");
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] asUByteArray(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return UByteArray.m103constructorimpl(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] asUIntArray(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return UIntArray.m182constructorimpl(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] asULongArray(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ULongArray.m261constructorimpl(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] asUShortArray(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return UShortArray.m366constructorimpl(r10);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: associateWith-JOV_ifY, reason: not valid java name */
    private static final <V> Map<UByte, V> m579associateWithJOV_ifY(byte[] r10, Function1<? super UByte, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$associateWith");
        Intrinsics.checkNotNullParameter(r11, "valueSelector");
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(UByteArray.m109getSizeimpl(r10)), 16));
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        r12.put(UByte.m44boximpl(r15), r11.invoke(UByte.m44boximpl(r15)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: associateWith-MShoTSo, reason: not valid java name */
    private static final <V> Map<ULong, V> m580associateWithMShoTSo(long[] r10, Function1<? super ULong, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$associateWith");
        Intrinsics.checkNotNullParameter(r11, "valueSelector");
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(ULongArray.m267getSizeimpl(r10)), 16));
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        r12.put(ULong.m200boximpl(r15), r11.invoke(ULong.m200boximpl(r15)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: associateWith-jgv0xPQ, reason: not valid java name */
    private static final <V> Map<UInt, V> m581associateWithjgv0xPQ(int[] r10, Function1<? super UInt, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$associateWith");
        Intrinsics.checkNotNullParameter(r11, "valueSelector");
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(UIntArray.m188getSizeimpl(r10)), 16));
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        r12.put(UInt.m121boximpl(r15), r11.invoke(UInt.m121boximpl(r15)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: associateWith-xTcfx_M, reason: not valid java name */
    private static final <V> Map<UShort, V> m582associateWithxTcfx_M(short[] r10, Function1<? super UShort, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$associateWith");
        Intrinsics.checkNotNullParameter(r11, "valueSelector");
        LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(UShortArray.m372getSizeimpl(r10)), 16));
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        r12.put(UShort.m307boximpl(r15), r11.invoke(UShort.m307boximpl(r15)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: associateWithTo-4D70W2E, reason: not valid java name */
    private static final <V, M extends Map<? super UInt, ? super V>> M m583associateWithTo4D70W2E(int[] r10, M r11, Function1<? super UInt, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "valueSelector");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        r11.put(UInt.m121boximpl(r15), r12.invoke(UInt.m121boximpl(r15)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: associateWithTo-H21X9dk, reason: not valid java name */
    private static final <V, M extends Map<? super UByte, ? super V>> M m584associateWithToH21X9dk(byte[] r10, M r11, Function1<? super UByte, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "valueSelector");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        r11.put(UByte.m44boximpl(r15), r12.invoke(UByte.m44boximpl(r15)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: associateWithTo-X6OPwNk, reason: not valid java name */
    private static final <V, M extends Map<? super ULong, ? super V>> M m585associateWithToX6OPwNk(long[] r10, M r11, Function1<? super ULong, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "valueSelector");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        r11.put(ULong.m200boximpl(r15), r12.invoke(ULong.m200boximpl(r15)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: associateWithTo-ciTST-8, reason: not valid java name */
    private static final <V, M extends Map<? super UShort, ? super V>> M m586associateWithTociTST8(short[] r10, M r11, Function1<? super UShort, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "valueSelector");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        r11.put(UShort.m307boximpl(r15), r12.invoke(UShort.m307boximpl(r15)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component1--ajY-9A, reason: not valid java name */
    private static final int m587component1ajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component1");
        return UIntArray.m187getpVg5ArA(r10, 0);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component1-GBYM_sE, reason: not valid java name */
    private static final byte m588component1GBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component1");
        return UByteArray.m108getw2LRezQ(r10, 0);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component1-QwZRm1k, reason: not valid java name */
    private static final long m589component1QwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component1");
        return ULongArray.m266getsVKNKU(r10, 0);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component1-rL5Bavg, reason: not valid java name */
    private static final short m590component1rL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component1");
        return UShortArray.m371getMh2AYeg(r10, 0);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component2--ajY-9A, reason: not valid java name */
    private static final int m591component2ajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component2");
        return UIntArray.m187getpVg5ArA(r10, 1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component2-GBYM_sE, reason: not valid java name */
    private static final byte m592component2GBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component2");
        return UByteArray.m108getw2LRezQ(r10, 1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component2-QwZRm1k, reason: not valid java name */
    private static final long m593component2QwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component2");
        return ULongArray.m266getsVKNKU(r10, 1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component2-rL5Bavg, reason: not valid java name */
    private static final short m594component2rL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component2");
        return UShortArray.m371getMh2AYeg(r10, 1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component3--ajY-9A, reason: not valid java name */
    private static final int m595component3ajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component3");
        return UIntArray.m187getpVg5ArA(r10, 2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component3-GBYM_sE, reason: not valid java name */
    private static final byte m596component3GBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component3");
        return UByteArray.m108getw2LRezQ(r10, 2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component3-QwZRm1k, reason: not valid java name */
    private static final long m597component3QwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component3");
        return ULongArray.m266getsVKNKU(r10, 2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component3-rL5Bavg, reason: not valid java name */
    private static final short m598component3rL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component3");
        return UShortArray.m371getMh2AYeg(r10, 2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component4--ajY-9A, reason: not valid java name */
    private static final int m599component4ajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component4");
        return UIntArray.m187getpVg5ArA(r10, 3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component4-GBYM_sE, reason: not valid java name */
    private static final byte m600component4GBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component4");
        return UByteArray.m108getw2LRezQ(r10, 3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component4-QwZRm1k, reason: not valid java name */
    private static final long m601component4QwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component4");
        return ULongArray.m266getsVKNKU(r10, 3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component4-rL5Bavg, reason: not valid java name */
    private static final short m602component4rL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component4");
        return UShortArray.m371getMh2AYeg(r10, 3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component5--ajY-9A, reason: not valid java name */
    private static final int m603component5ajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component5");
        return UIntArray.m187getpVg5ArA(r10, 4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component5-GBYM_sE, reason: not valid java name */
    private static final byte m604component5GBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component5");
        return UByteArray.m108getw2LRezQ(r10, 4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component5-QwZRm1k, reason: not valid java name */
    private static final long m605component5QwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component5");
        return ULongArray.m266getsVKNKU(r10, 4);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: component5-rL5Bavg, reason: not valid java name */
    private static final short m606component5rL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$component5");
        return UShortArray.m371getMh2AYeg(r10, 4);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentEquals-FGO6Aew, reason: not valid java name */
    public static boolean m607contentEqualsFGO6Aew(short[] r10, short[] r11) {
        if (r10 != null) goto L5;
        r10 = null;
    L5:
        if (r11 != null) goto L8;
        r11 = null;
    L8:
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentEquals-KJPZfPQ, reason: not valid java name */
    public static boolean m608contentEqualsKJPZfPQ(int[] r10, int[] r11) {
        if (r10 != null) goto L5;
        r10 = null;
    L5:
        if (r11 != null) goto L8;
        r11 = null;
    L8:
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentEquals-kV0jMPg, reason: not valid java name */
    public static boolean m609contentEqualskV0jMPg(byte[] r10, byte[] r11) {
        if (r10 != null) goto L5;
        r10 = null;
    L5:
        if (r11 != null) goto L8;
        r11 = null;
    L8:
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentEquals-lec5QzE, reason: not valid java name */
    public static boolean m610contentEqualslec5QzE(long[] r10, long[] r11) {
        if (r10 != null) goto L5;
        r10 = null;
    L5:
        if (r11 != null) goto L8;
        r11 = null;
    L8:
        return Arrays.equals(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentHashCode-2csIQuQ, reason: not valid java name */
    public static final int m611contentHashCode2csIQuQ(byte[] r10) {
        if (r10 != null) goto L5;
        r10 = null;
    L5:
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentHashCode-XUkPCBk, reason: not valid java name */
    public static final int m612contentHashCodeXUkPCBk(int[] r10) {
        if (r10 != null) goto L5;
        r10 = null;
    L5:
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentHashCode-d-6D3K8, reason: not valid java name */
    public static final int m613contentHashCoded6D3K8(short[] r10) {
        if (r10 != null) goto L5;
        r10 = null;
    L5:
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentHashCode-uLth9ew, reason: not valid java name */
    public static final int m614contentHashCodeuLth9ew(long[] r10) {
        if (r10 != null) goto L5;
        r10 = null;
    L5:
        return Arrays.hashCode(r10);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentToString-2csIQuQ, reason: not valid java name */
    public static String m615contentToString2csIQuQ(byte[] r10) {
        if (r10 == null) goto L5;
        String r11 = CollectionsKt.joinToString$default(UByteArray.m101boximpl(r10), ", ", "[", "]", 0, null, null, 56, null);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return "null";
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentToString-XUkPCBk, reason: not valid java name */
    public static String m616contentToStringXUkPCBk(int[] r10) {
        if (r10 == null) goto L5;
        String r11 = CollectionsKt.joinToString$default(UIntArray.m180boximpl(r10), ", ", "[", "]", 0, null, null, 56, null);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return "null";
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentToString-d-6D3K8, reason: not valid java name */
    public static String m617contentToStringd6D3K8(short[] r10) {
        if (r10 == null) goto L5;
        String r11 = CollectionsKt.joinToString$default(UShortArray.m364boximpl(r10), ", ", "[", "]", 0, null, null, 56, null);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return "null";
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: contentToString-uLth9ew, reason: not valid java name */
    public static String m618contentToStringuLth9ew(long[] r10) {
        if (r10 == null) goto L5;
        String r11 = CollectionsKt.joinToString$default(ULongArray.m259boximpl(r10), ", ", "[", "]", 0, null, null, 56, null);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return "null";
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyInto--B0-L2c, reason: not valid java name */
    private static final long[] m619copyIntoB0L2c(long[] r10, long[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyInto");
        Intrinsics.checkNotNullParameter(r11, "destination");
        ArraysKt.copyInto(r10, r11, r12, r13, r14);
        return r11;
    }

    /* JADX INFO: renamed from: copyInto--B0-L2c$default, reason: not valid java name */
    static /* synthetic */ long[] m620copyIntoB0L2c$default(long[] r10, long[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = ULongArray.m267getSizeimpl(r10);
    L11:
        Intrinsics.checkNotNullParameter(r10, "$this$copyInto");
        Intrinsics.checkNotNullParameter(r11, "destination");
        ArraysKt.copyInto(r10, r11, r12, r13, r14);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyInto-9-ak10g, reason: not valid java name */
    private static final short[] m621copyInto9ak10g(short[] r10, short[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyInto");
        Intrinsics.checkNotNullParameter(r11, "destination");
        ArraysKt.copyInto(r10, r11, r12, r13, r14);
        return r11;
    }

    /* JADX INFO: renamed from: copyInto-9-ak10g$default, reason: not valid java name */
    static /* synthetic */ short[] m622copyInto9ak10g$default(short[] r10, short[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = UShortArray.m372getSizeimpl(r10);
    L11:
        Intrinsics.checkNotNullParameter(r10, "$this$copyInto");
        Intrinsics.checkNotNullParameter(r11, "destination");
        ArraysKt.copyInto(r10, r11, r12, r13, r14);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyInto-FUQE5sA, reason: not valid java name */
    private static final byte[] m623copyIntoFUQE5sA(byte[] r10, byte[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyInto");
        Intrinsics.checkNotNullParameter(r11, "destination");
        ArraysKt.copyInto(r10, r11, r12, r13, r14);
        return r11;
    }

    /* JADX INFO: renamed from: copyInto-FUQE5sA$default, reason: not valid java name */
    static /* synthetic */ byte[] m624copyIntoFUQE5sA$default(byte[] r10, byte[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = UByteArray.m109getSizeimpl(r10);
    L11:
        Intrinsics.checkNotNullParameter(r10, "$this$copyInto");
        Intrinsics.checkNotNullParameter(r11, "destination");
        ArraysKt.copyInto(r10, r11, r12, r13, r14);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyInto-sIZ3KeM, reason: not valid java name */
    private static final int[] m625copyIntosIZ3KeM(int[] r10, int[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyInto");
        Intrinsics.checkNotNullParameter(r11, "destination");
        ArraysKt.copyInto(r10, r11, r12, r13, r14);
        return r11;
    }

    /* JADX INFO: renamed from: copyInto-sIZ3KeM$default, reason: not valid java name */
    static /* synthetic */ int[] m626copyIntosIZ3KeM$default(int[] r10, int[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 0;
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = UIntArray.m188getSizeimpl(r10);
    L11:
        Intrinsics.checkNotNullParameter(r10, "$this$copyInto");
        Intrinsics.checkNotNullParameter(r11, "destination");
        ArraysKt.copyInto(r10, r11, r12, r13, r14);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOf--ajY-9A, reason: not valid java name */
    private static final int[] m627copyOfajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOf");
        int[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return UIntArray.m182constructorimpl(r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOf-GBYM_sE, reason: not valid java name */
    private static final byte[] m628copyOfGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOf");
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return UByteArray.m103constructorimpl(r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOf-PpDY95g, reason: not valid java name */
    private static final byte[] m629copyOfPpDY95g(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOf");
        byte[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return UByteArray.m103constructorimpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOf-QwZRm1k, reason: not valid java name */
    private static final long[] m630copyOfQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOf");
        long[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return ULongArray.m261constructorimpl(r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOf-nggk6HY, reason: not valid java name */
    private static final short[] m631copyOfnggk6HY(short[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOf");
        short[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return UShortArray.m366constructorimpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOf-qFRl0hI, reason: not valid java name */
    private static final int[] m632copyOfqFRl0hI(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOf");
        int[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return UIntArray.m182constructorimpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOf-r7IrZao, reason: not valid java name */
    private static final long[] m633copyOfr7IrZao(long[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOf");
        long[] r12 = Arrays.copyOf(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        return ULongArray.m261constructorimpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOf-rL5Bavg, reason: not valid java name */
    private static final short[] m634copyOfrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOf");
        short[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return UShortArray.m366constructorimpl(r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOfRange--nroSd4, reason: not valid java name */
    private static final long[] m635copyOfRangenroSd4(long[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOfRange");
        return ULongArray.m261constructorimpl(ArraysKt.copyOfRange(r10, r11, r12));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOfRange-4UcCI2c, reason: not valid java name */
    private static final byte[] m636copyOfRange4UcCI2c(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOfRange");
        return UByteArray.m103constructorimpl(ArraysKt.copyOfRange(r10, r11, r12));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOfRange-Aa5vz7o, reason: not valid java name */
    private static final short[] m637copyOfRangeAa5vz7o(short[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOfRange");
        return UShortArray.m366constructorimpl(ArraysKt.copyOfRange(r10, r11, r12));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: copyOfRange-oBK06Vg, reason: not valid java name */
    private static final int[] m638copyOfRangeoBK06Vg(int[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$copyOfRange");
        return UIntArray.m182constructorimpl(ArraysKt.copyOfRange(r10, r11, r12));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: count-JOV_ifY, reason: not valid java name */
    private static final int m639countJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$count");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13))).booleanValue() == false) goto L7;
        r14 = r14 + 1;
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: count-MShoTSo, reason: not valid java name */
    private static final int m640countMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$count");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13))).booleanValue() == false) goto L7;
        r14 = r14 + 1;
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: count-jgv0xPQ, reason: not valid java name */
    private static final int m641countjgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$count");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13))).booleanValue() == false) goto L7;
        r14 = r14 + 1;
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: count-xTcfx_M, reason: not valid java name */
    private static final int m642countxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$count");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13))).booleanValue() == false) goto L7;
        r14 = r14 + 1;
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: drop-PpDY95g, reason: not valid java name */
    public static final List<UByte> m643dropPpDY95g(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$drop");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return m1171takeLastPpDY95g(r10, RangesKt.coerceAtLeast(UByteArray.m109getSizeimpl(r10) - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: drop-nggk6HY, reason: not valid java name */
    public static final List<UShort> m644dropnggk6HY(short[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$drop");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return m1172takeLastnggk6HY(r10, RangesKt.coerceAtLeast(UShortArray.m372getSizeimpl(r10) - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: drop-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m645dropqFRl0hI(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$drop");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return m1173takeLastqFRl0hI(r10, RangesKt.coerceAtLeast(UIntArray.m188getSizeimpl(r10) - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: drop-r7IrZao, reason: not valid java name */
    public static final List<ULong> m646dropr7IrZao(long[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$drop");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return m1174takeLastr7IrZao(r10, RangesKt.coerceAtLeast(ULongArray.m267getSizeimpl(r10) - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: dropLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m647dropLastPpDY95g(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropLast");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return m1167takePpDY95g(r10, RangesKt.coerceAtLeast(UByteArray.m109getSizeimpl(r10) - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: dropLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m648dropLastnggk6HY(short[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropLast");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return m1168takenggk6HY(r10, RangesKt.coerceAtLeast(UShortArray.m372getSizeimpl(r10) - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: dropLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m649dropLastqFRl0hI(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropLast");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return m1169takeqFRl0hI(r10, RangesKt.coerceAtLeast(UIntArray.m188getSizeimpl(r10) - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: dropLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m650dropLastr7IrZao(long[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropLast");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L10;
        return m1170taker7IrZao(r10, RangesKt.coerceAtLeast(ULongArray.m267getSizeimpl(r10) - r11, 0));
    L10:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: dropLastWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m651dropLastWhileJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ArraysKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L11;
        if (r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r12))).booleanValue() == false) goto L8;
        r12 = r12 - 1;
        goto L4
    L8:
        return m1167takePpDY95g(r10, r12 + 1);
    L11:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: dropLastWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m652dropLastWhileMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ArraysKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L11;
        if (r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r12))).booleanValue() == false) goto L8;
        r12 = r12 - 1;
        goto L4
    L8:
        return m1170taker7IrZao(r10, r12 + 1);
    L11:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: dropLastWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m653dropLastWhilejgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ArraysKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L11;
        if (r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r12))).booleanValue() == false) goto L8;
        r12 = r12 - 1;
        goto L4
    L8:
        return m1169takeqFRl0hI(r10, r12 + 1);
    L11:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: dropLastWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m654dropLastWhilexTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ArraysKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L11;
        if (r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r12))).booleanValue() == false) goto L8;
        r12 = r12 - 1;
        goto L4
    L8:
        return m1168takenggk6HY(r10, r12 + 1);
    L11:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: dropWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m655dropWhileJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
        boolean r15 = false;
    L3:
        if (r14 >= r13) goto L11;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r14);
        if (r15 == false) goto L8;
        r12.add(UByte.m44boximpl(r16));
    L10:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r11.invoke(UByte.m44boximpl(r16)).booleanValue() == true) goto L10;
        r12.add(UByte.m44boximpl(r16));
        r15 = true;
        goto L10
    L11:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: dropWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m656dropWhileMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
        boolean r15 = false;
    L3:
        if (r14 >= r13) goto L11;
        long r16 = ULongArray.m266getsVKNKU(r10, r14);
        if (r15 == false) goto L8;
        r12.add(ULong.m200boximpl(r16));
    L10:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r11.invoke(ULong.m200boximpl(r16)).booleanValue() == true) goto L10;
        r12.add(ULong.m200boximpl(r16));
        r15 = true;
        goto L10
    L11:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: dropWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m657dropWhilejgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
        boolean r15 = false;
    L3:
        if (r14 >= r13) goto L11;
        int r16 = UIntArray.m187getpVg5ArA(r10, r14);
        if (r15 == false) goto L8;
        r12.add(UInt.m121boximpl(r16));
    L10:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r11.invoke(UInt.m121boximpl(r16)).booleanValue() == true) goto L10;
        r12.add(UInt.m121boximpl(r16));
        r15 = true;
        goto L10
    L11:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: dropWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m658dropWhilexTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
        boolean r15 = false;
    L3:
        if (r14 >= r13) goto L11;
        short r16 = UShortArray.m371getMh2AYeg(r10, r14);
        if (r15 == false) goto L8;
        r12.add(UShort.m307boximpl(r16));
    L10:
        r14 = r14 + 1;
        goto L3
    L8:
        if (r11.invoke(UShort.m307boximpl(r16)).booleanValue() == true) goto L10;
        r12.add(UShort.m307boximpl(r16));
        r15 = true;
        goto L10
    L11:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAtOrElse-CVVdw08, reason: not valid java name */
    private static final short m659elementAtOrElseCVVdw08(short[] r10, int r11, Function1<? super Integer, UShort> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > ArraysKt.getLastIndex(r10)) goto L8;
        return UShortArray.m371getMh2AYeg(r10, r11);
    L8:
        return r12.invoke(Integer.valueOf(r11)).m363unboximpl();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAtOrElse-QxvSvLU, reason: not valid java name */
    private static final int m660elementAtOrElseQxvSvLU(int[] r10, int r11, Function1<? super Integer, UInt> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > ArraysKt.getLastIndex(r10)) goto L8;
        return UIntArray.m187getpVg5ArA(r10, r11);
    L8:
        return r12.invoke(Integer.valueOf(r11)).m179unboximpl();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAtOrElse-Xw8i6dc, reason: not valid java name */
    private static final long m661elementAtOrElseXw8i6dc(long[] r10, int r11, Function1<? super Integer, ULong> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > ArraysKt.getLastIndex(r10)) goto L8;
        return ULongArray.m266getsVKNKU(r10, r11);
    L8:
        return r12.invoke(Integer.valueOf(r11)).m258unboximpl();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAtOrElse-cO-VybQ, reason: not valid java name */
    private static final byte m662elementAtOrElsecOVybQ(byte[] r10, int r11, Function1<? super Integer, UByte> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > ArraysKt.getLastIndex(r10)) goto L8;
        return UByteArray.m108getw2LRezQ(r10, r11);
    L8:
        return r12.invoke(Integer.valueOf(r11)).m100unboximpl();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAtOrNull-PpDY95g, reason: not valid java name */
    private static final UByte m663elementAtOrNullPpDY95g(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAtOrNull");
        return m783getOrNullPpDY95g(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAtOrNull-nggk6HY, reason: not valid java name */
    private static final UShort m664elementAtOrNullnggk6HY(short[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAtOrNull");
        return m784getOrNullnggk6HY(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAtOrNull-qFRl0hI, reason: not valid java name */
    private static final UInt m665elementAtOrNullqFRl0hI(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAtOrNull");
        return m785getOrNullqFRl0hI(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: elementAtOrNull-r7IrZao, reason: not valid java name */
    private static final ULong m666elementAtOrNullr7IrZao(long[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$elementAtOrNull");
        return m786getOrNullr7IrZao(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: fill-2fe2U9s, reason: not valid java name */
    public static final void m667fill2fe2U9s(int[] r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$fill");
        ArraysKt.fill(r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: fill-2fe2U9s$default, reason: not valid java name */
    public static /* synthetic */ void m668fill2fe2U9s$default(int[] r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = UIntArray.m188getSizeimpl(r10);
    L8:
        m667fill2fe2U9s(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: fill-EtDCXyQ, reason: not valid java name */
    public static final void m669fillEtDCXyQ(short[] r10, short r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$fill");
        ArraysKt.fill(r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: fill-EtDCXyQ$default, reason: not valid java name */
    public static /* synthetic */ void m670fillEtDCXyQ$default(short[] r10, short r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = UShortArray.m372getSizeimpl(r10);
    L8:
        m669fillEtDCXyQ(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: fill-K6DWlUc, reason: not valid java name */
    public static final void m671fillK6DWlUc(long[] r10, long r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$fill");
        ArraysKt.fill(r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: fill-K6DWlUc$default, reason: not valid java name */
    public static /* synthetic */ void m672fillK6DWlUc$default(long[] r10, long r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = ULongArray.m267getSizeimpl(r10);
    L8:
        m671fillK6DWlUc(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: fill-WpHrYlw, reason: not valid java name */
    public static final void m673fillWpHrYlw(byte[] r10, byte r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$fill");
        ArraysKt.fill(r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: fill-WpHrYlw$default, reason: not valid java name */
    public static /* synthetic */ void m674fillWpHrYlw$default(byte[] r10, byte r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = UByteArray.m109getSizeimpl(r10);
    L8:
        m673fillWpHrYlw(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filter-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m675filterJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filter");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        if (r11.invoke(UByte.m44boximpl(r15)).booleanValue() == false) goto L7;
        r12.add(UByte.m44boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filter-MShoTSo, reason: not valid java name */
    private static final List<ULong> m676filterMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filter");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        if (r11.invoke(ULong.m200boximpl(r15)).booleanValue() == false) goto L7;
        r12.add(ULong.m200boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filter-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m677filterjgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filter");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        if (r11.invoke(UInt.m121boximpl(r15)).booleanValue() == false) goto L7;
        r12.add(UInt.m121boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filter-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m678filterxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filter");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        if (r11.invoke(UShort.m307boximpl(r15)).booleanValue() == false) goto L7;
        r12.add(UShort.m307boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterIndexed-ELGow60, reason: not valid java name */
    private static final List<UByte> m679filterIndexedELGow60(byte[] r10, Function2<? super Integer, ? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L8;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r14);
        int r17 = r15 + 1;
        if (r11.invoke(Integer.valueOf(r15), UByte.m44boximpl(r16)).booleanValue() == false) goto L7;
        r12.add(UByte.m44boximpl(r16));
    L7:
        r14 = r14 + 1;
        r15 = r17;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterIndexed-WyvcNBI, reason: not valid java name */
    private static final List<UInt> m680filterIndexedWyvcNBI(int[] r10, Function2<? super Integer, ? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r16 = UIntArray.m187getpVg5ArA(r10, r14);
        int r17 = r15 + 1;
        if (r11.invoke(Integer.valueOf(r15), UInt.m121boximpl(r16)).booleanValue() == false) goto L7;
        r12.add(UInt.m121boximpl(r16));
    L7:
        r14 = r14 + 1;
        r15 = r17;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterIndexed-s8dVfGU, reason: not valid java name */
    private static final List<ULong> m681filterIndexeds8dVfGU(long[] r10, Function2<? super Integer, ? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L8;
        long r16 = ULongArray.m266getsVKNKU(r10, r14);
        int r17 = r15 + 1;
        if (r11.invoke(Integer.valueOf(r15), ULong.m200boximpl(r16)).booleanValue() == false) goto L7;
        r12.add(ULong.m200boximpl(r16));
    L7:
        r14 = r14 + 1;
        r15 = r17;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterIndexed-xzaTVY8, reason: not valid java name */
    private static final List<UShort> m682filterIndexedxzaTVY8(short[] r10, Function2<? super Integer, ? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L8;
        short r16 = UShortArray.m371getMh2AYeg(r10, r14);
        int r17 = r15 + 1;
        if (r11.invoke(Integer.valueOf(r15), UShort.m307boximpl(r16)).booleanValue() == false) goto L7;
        r12.add(UShort.m307boximpl(r16));
    L7:
        r14 = r14 + 1;
        r15 = r17;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterIndexedTo--6EtJGI, reason: not valid java name */
    private static final <C extends Collection<? super UInt>> C m683filterIndexedTo6EtJGI(int[] r10, C r11, Function2<? super Integer, ? super UInt, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r16 = UIntArray.m187getpVg5ArA(r10, r14);
        int r17 = r15 + 1;
        if (r12.invoke(Integer.valueOf(r15), UInt.m121boximpl(r16)).booleanValue() == false) goto L7;
        r11.add(UInt.m121boximpl(r16));
    L7:
        r14 = r14 + 1;
        r15 = r17;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <C extends Collection<? super UShort>> C m684filterIndexedToQqktQ3k(short[] r10, C r11, Function2<? super Integer, ? super UShort, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L8;
        short r16 = UShortArray.m371getMh2AYeg(r10, r14);
        int r17 = r15 + 1;
        if (r12.invoke(Integer.valueOf(r15), UShort.m307boximpl(r16)).booleanValue() == false) goto L7;
        r11.add(UShort.m307boximpl(r16));
    L7:
        r14 = r14 + 1;
        r15 = r17;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <C extends Collection<? super UByte>> C m685filterIndexedToeNpIKz8(byte[] r10, C r11, Function2<? super Integer, ? super UByte, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L8;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r14);
        int r17 = r15 + 1;
        if (r12.invoke(Integer.valueOf(r15), UByte.m44boximpl(r16)).booleanValue() == false) goto L7;
        r11.add(UByte.m44boximpl(r16));
    L7:
        r14 = r14 + 1;
        r15 = r17;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <C extends Collection<? super ULong>> C m686filterIndexedTope2Q0Dw(long[] r10, C r11, Function2<? super Integer, ? super ULong, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L8;
        long r16 = ULongArray.m266getsVKNKU(r10, r14);
        int r17 = r15 + 1;
        if (r12.invoke(Integer.valueOf(r15), ULong.m200boximpl(r16)).booleanValue() == false) goto L7;
        r11.add(ULong.m200boximpl(r16));
    L7:
        r14 = r14 + 1;
        r15 = r17;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterNot-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m687filterNotJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterNot");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        if (r11.invoke(UByte.m44boximpl(r15)).booleanValue() == true) goto L7;
        r12.add(UByte.m44boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterNot-MShoTSo, reason: not valid java name */
    private static final List<ULong> m688filterNotMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterNot");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        if (r11.invoke(ULong.m200boximpl(r15)).booleanValue() == true) goto L7;
        r12.add(ULong.m200boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterNot-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m689filterNotjgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterNot");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        if (r11.invoke(UInt.m121boximpl(r15)).booleanValue() == true) goto L7;
        r12.add(UInt.m121boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterNot-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m690filterNotxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterNot");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        if (r11.invoke(UShort.m307boximpl(r15)).booleanValue() == true) goto L7;
        r12.add(UShort.m307boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterNotTo-HqK1JgA, reason: not valid java name */
    private static final <C extends Collection<? super ULong>> C m691filterNotToHqK1JgA(long[] r10, C r11, Function1<? super ULong, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        if (r12.invoke(ULong.m200boximpl(r15)).booleanValue() == true) goto L7;
        r11.add(ULong.m200boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterNotTo-oEOeDjA, reason: not valid java name */
    private static final <C extends Collection<? super UShort>> C m692filterNotTooEOeDjA(short[] r10, C r11, Function1<? super UShort, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        if (r12.invoke(UShort.m307boximpl(r15)).booleanValue() == true) goto L7;
        r11.add(UShort.m307boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterNotTo-wU5IKMo, reason: not valid java name */
    private static final <C extends Collection<? super UInt>> C m693filterNotTowU5IKMo(int[] r10, C r11, Function1<? super UInt, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        if (r12.invoke(UInt.m121boximpl(r15)).booleanValue() == true) goto L7;
        r11.add(UInt.m121boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterNotTo-wzUQCXU, reason: not valid java name */
    private static final <C extends Collection<? super UByte>> C m694filterNotTowzUQCXU(byte[] r10, C r11, Function1<? super UByte, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        if (r12.invoke(UByte.m44boximpl(r15)).booleanValue() == true) goto L7;
        r11.add(UByte.m44boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterTo-HqK1JgA, reason: not valid java name */
    private static final <C extends Collection<? super ULong>> C m695filterToHqK1JgA(long[] r10, C r11, Function1<? super ULong, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        if (r12.invoke(ULong.m200boximpl(r15)).booleanValue() == false) goto L7;
        r11.add(ULong.m200boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterTo-oEOeDjA, reason: not valid java name */
    private static final <C extends Collection<? super UShort>> C m696filterTooEOeDjA(short[] r10, C r11, Function1<? super UShort, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        if (r12.invoke(UShort.m307boximpl(r15)).booleanValue() == false) goto L7;
        r11.add(UShort.m307boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterTo-wU5IKMo, reason: not valid java name */
    private static final <C extends Collection<? super UInt>> C m697filterTowU5IKMo(int[] r10, C r11, Function1<? super UInt, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        if (r12.invoke(UInt.m121boximpl(r15)).booleanValue() == false) goto L7;
        r11.add(UInt.m121boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: filterTo-wzUQCXU, reason: not valid java name */
    private static final <C extends Collection<? super UByte>> C m698filterTowzUQCXU(byte[] r10, C r11, Function1<? super UByte, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$filterTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        if (r12.invoke(UByte.m44boximpl(r15)).booleanValue() == false) goto L7;
        r11.add(UByte.m44boximpl(r15));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: find-JOV_ifY, reason: not valid java name */
    private static final UByte m699findJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$find");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r13);
        if (r11.invoke(UByte.m44boximpl(r14)).booleanValue() == true) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return UByte.m44boximpl(r14);
    L8:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: find-MShoTSo, reason: not valid java name */
    private static final ULong m700findMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$find");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        long r14 = ULongArray.m266getsVKNKU(r10, r13);
        if (r11.invoke(ULong.m200boximpl(r14)).booleanValue() == true) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return ULong.m200boximpl(r14);
    L8:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: find-jgv0xPQ, reason: not valid java name */
    private static final UInt m701findjgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$find");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        int r14 = UIntArray.m187getpVg5ArA(r10, r13);
        if (r11.invoke(UInt.m121boximpl(r14)).booleanValue() == true) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return UInt.m121boximpl(r14);
    L8:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: find-xTcfx_M, reason: not valid java name */
    private static final UShort m702findxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$find");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        short r14 = UShortArray.m371getMh2AYeg(r10, r13);
        if (r11.invoke(UShort.m307boximpl(r14)).booleanValue() == true) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return UShort.m307boximpl(r14);
    L8:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: findLast-JOV_ifY, reason: not valid java name */
    private static final UByte m703findLastJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$findLast");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10) - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r12);
        if (r11.invoke(UByte.m44boximpl(r14)).booleanValue() == true) goto L14;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L14:
        return UByte.m44boximpl(r14);
    L10:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: findLast-MShoTSo, reason: not valid java name */
    private static final ULong m704findLastMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$findLast");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10) - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        long r14 = ULongArray.m266getsVKNKU(r10, r12);
        if (r11.invoke(ULong.m200boximpl(r14)).booleanValue() == true) goto L14;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L14:
        return ULong.m200boximpl(r14);
    L10:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: findLast-jgv0xPQ, reason: not valid java name */
    private static final UInt m705findLastjgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$findLast");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10) - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        int r14 = UIntArray.m187getpVg5ArA(r10, r12);
        if (r11.invoke(UInt.m121boximpl(r14)).booleanValue() == true) goto L14;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L14:
        return UInt.m121boximpl(r14);
    L10:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: findLast-xTcfx_M, reason: not valid java name */
    private static final UShort m706findLastxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$findLast");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10) - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        short r14 = UShortArray.m371getMh2AYeg(r10, r12);
        if (r11.invoke(UShort.m307boximpl(r14)).booleanValue() == true) goto L14;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L14:
        return UShort.m307boximpl(r14);
    L10:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: first--ajY-9A, reason: not valid java name */
    private static final int m707firstajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$first");
        return UInt.m127constructorimpl(ArraysKt.first(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: first-GBYM_sE, reason: not valid java name */
    private static final byte m708firstGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$first");
        return UByte.m50constructorimpl(ArraysKt.first(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: first-JOV_ifY, reason: not valid java name */
    private static final byte m709firstJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$first");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r13);
        if (r11.invoke(UByte.m44boximpl(r14)).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: first-MShoTSo, reason: not valid java name */
    private static final long m710firstMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$first");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        long r14 = ULongArray.m266getsVKNKU(r10, r13);
        if (r11.invoke(ULong.m200boximpl(r14)).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: first-QwZRm1k, reason: not valid java name */
    private static final long m711firstQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$first");
        return ULong.m206constructorimpl(ArraysKt.first(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: first-jgv0xPQ, reason: not valid java name */
    private static final int m712firstjgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$first");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        int r14 = UIntArray.m187getpVg5ArA(r10, r13);
        if (r11.invoke(UInt.m121boximpl(r14)).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: first-rL5Bavg, reason: not valid java name */
    private static final short m713firstrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$first");
        return UShort.m313constructorimpl(ArraysKt.first(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: first-xTcfx_M, reason: not valid java name */
    private static final short m714firstxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$first");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        short r14 = UShortArray.m371getMh2AYeg(r10, r13);
        if (r11.invoke(UShort.m307boximpl(r14)).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: firstOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m715firstOrNullajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$firstOrNull");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        return UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: firstOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m716firstOrNullGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$firstOrNull");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        return UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: firstOrNull-JOV_ifY, reason: not valid java name */
    private static final UByte m717firstOrNullJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r13);
        if (r11.invoke(UByte.m44boximpl(r14)).booleanValue() == true) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return UByte.m44boximpl(r14);
    L9:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: firstOrNull-MShoTSo, reason: not valid java name */
    private static final ULong m718firstOrNullMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        long r14 = ULongArray.m266getsVKNKU(r10, r13);
        if (r11.invoke(ULong.m200boximpl(r14)).booleanValue() == true) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return ULong.m200boximpl(r14);
    L9:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: firstOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m719firstOrNullQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$firstOrNull");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        return ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: firstOrNull-jgv0xPQ, reason: not valid java name */
    private static final UInt m720firstOrNulljgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        int r14 = UIntArray.m187getpVg5ArA(r10, r13);
        if (r11.invoke(UInt.m121boximpl(r14)).booleanValue() == true) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return UInt.m121boximpl(r14);
    L9:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: firstOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m721firstOrNullrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$firstOrNull");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        return UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: firstOrNull-xTcfx_M, reason: not valid java name */
    private static final UShort m722firstOrNullxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        short r14 = UShortArray.m371getMh2AYeg(r10, r13);
        if (r11.invoke(UShort.m307boximpl(r14)).booleanValue() == true) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        return UShort.m307boximpl(r14);
    L9:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: flatMap-JOV_ifY, reason: not valid java name */
    private static final <R> List<R> m723flatMapJOV_ifY(byte[] r10, Function1<? super UByte, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMap");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r12, r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: flatMap-MShoTSo, reason: not valid java name */
    private static final <R> List<R> m724flatMapMShoTSo(long[] r10, Function1<? super ULong, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMap");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r12, r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: flatMap-jgv0xPQ, reason: not valid java name */
    private static final <R> List<R> m725flatMapjgv0xPQ(int[] r10, Function1<? super UInt, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMap");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r12, r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: flatMap-xTcfx_M, reason: not valid java name */
    private static final <R> List<R> m726flatMapxTcfx_M(short[] r10, Function1<? super UShort, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMap");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r12, r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: flatMapIndexed-ELGow60, reason: not valid java name */
    private static final <R> List<R> m727flatMapIndexedELGow60(byte[] r10, Function2<? super Integer, ? super UByte, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r12, r11.invoke(Integer.valueOf(r15), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: flatMapIndexed-WyvcNBI, reason: not valid java name */
    private static final <R> List<R> m728flatMapIndexedWyvcNBI(int[] r10, Function2<? super Integer, ? super UInt, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r12, r11.invoke(Integer.valueOf(r15), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: flatMapIndexed-s8dVfGU, reason: not valid java name */
    private static final <R> List<R> m729flatMapIndexeds8dVfGU(long[] r10, Function2<? super Integer, ? super ULong, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r12, r11.invoke(Integer.valueOf(r15), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: flatMapIndexed-xzaTVY8, reason: not valid java name */
    private static final <R> List<R> m730flatMapIndexedxzaTVY8(short[] r10, Function2<? super Integer, ? super UShort, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapIndexed");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList();
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r12, r11.invoke(Integer.valueOf(r15), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: flatMapIndexedTo--6EtJGI, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m731flatMapIndexedTo6EtJGI(int[] r10, C r11, Function2<? super Integer, ? super UInt, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r11, r12.invoke(Integer.valueOf(r15), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: flatMapIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m732flatMapIndexedToQqktQ3k(short[] r10, C r11, Function2<? super Integer, ? super UShort, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r11, r12.invoke(Integer.valueOf(r15), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: flatMapIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m733flatMapIndexedToeNpIKz8(byte[] r10, C r11, Function2<? super Integer, ? super UByte, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r11, r12.invoke(Integer.valueOf(r15), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: flatMapIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m734flatMapIndexedTope2Q0Dw(long[] r10, C r11, Function2<? super Integer, ? super ULong, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r11, r12.invoke(Integer.valueOf(r15), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: flatMapTo-HqK1JgA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m735flatMapToHqK1JgA(long[] r10, C r11, Function1<? super ULong, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r11, r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: flatMapTo-oEOeDjA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m736flatMapTooEOeDjA(short[] r10, C r11, Function1<? super UShort, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r11, r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: flatMapTo-wU5IKMo, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m737flatMapTowU5IKMo(int[] r10, C r11, Function1<? super UInt, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r11, r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: flatMapTo-wzUQCXU, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m738flatMapTowzUQCXU(byte[] r10, C r11, Function1<? super UByte, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        CollectionsKt.addAll(r11, r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: fold-A8wKCXQ, reason: not valid java name */
    private static final <R> R m739foldA8wKCXQ(long[] r10, R r11, Function2<? super R, ? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$fold");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        R r15 = r11;
        r11 = r12.invoke(r15, ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: fold-yXmHNn8, reason: not valid java name */
    private static final <R> R m740foldyXmHNn8(byte[] r10, R r11, Function2<? super R, ? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$fold");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        R r15 = r11;
        r11 = r12.invoke(r15, UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: fold-zi1B2BA, reason: not valid java name */
    private static final <R> R m741foldzi1B2BA(int[] r10, R r11, Function2<? super R, ? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$fold");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        R r15 = r11;
        r11 = r12.invoke(r15, UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: fold-zww5nb8, reason: not valid java name */
    private static final <R> R m742foldzww5nb8(short[] r10, R r11, Function2<? super R, ? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$fold");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        R r15 = r11;
        r11 = r12.invoke(r15, UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> R m743foldIndexed3iWJZGE(byte[] r10, R r11, Function3<? super Integer, ? super R, ? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r15), r16, UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14)));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldIndexed-bzxtMww, reason: not valid java name */
    private static final <R> R m744foldIndexedbzxtMww(short[] r10, R r11, Function3<? super Integer, ? super R, ? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r15), r16, UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14)));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> R m745foldIndexedmwnnOCs(long[] r10, R r11, Function3<? super Integer, ? super R, ? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r15), r16, ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14)));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> R m746foldIndexedyVwIW0Q(int[] r10, R r11, Function3<? super Integer, ? super R, ? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r15), r16, UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14)));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldRight-A8wKCXQ, reason: not valid java name */
    private static final <R> R m747foldRightA8wKCXQ(long[] r10, R r11, Function2<? super ULong, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldRight");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = ArraysKt.getLastIndex(r10);
    L3:
        if (r13 < 0) goto L5;
        r11 = r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13)), r11);
        r13 = r13 - 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldRight-yXmHNn8, reason: not valid java name */
    private static final <R> R m748foldRightyXmHNn8(byte[] r10, R r11, Function2<? super UByte, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldRight");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = ArraysKt.getLastIndex(r10);
    L3:
        if (r13 < 0) goto L5;
        r11 = r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13)), r11);
        r13 = r13 - 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldRight-zi1B2BA, reason: not valid java name */
    private static final <R> R m749foldRightzi1B2BA(int[] r10, R r11, Function2<? super UInt, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldRight");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = ArraysKt.getLastIndex(r10);
    L3:
        if (r13 < 0) goto L5;
        r11 = r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13)), r11);
        r13 = r13 - 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldRight-zww5nb8, reason: not valid java name */
    private static final <R> R m750foldRightzww5nb8(short[] r10, R r11, Function2<? super UShort, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldRight");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = ArraysKt.getLastIndex(r10);
    L3:
        if (r13 < 0) goto L5;
        r11 = r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13)), r11);
        r13 = r13 - 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldRightIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> R m751foldRightIndexed3iWJZGE(byte[] r10, R r11, Function3<? super Integer, ? super UByte, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = ArraysKt.getLastIndex(r10);
    L3:
        if (r13 < 0) goto L5;
        r11 = r12.invoke(Integer.valueOf(r13), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13)), r11);
        r13 = r13 - 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldRightIndexed-bzxtMww, reason: not valid java name */
    private static final <R> R m752foldRightIndexedbzxtMww(short[] r10, R r11, Function3<? super Integer, ? super UShort, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = ArraysKt.getLastIndex(r10);
    L3:
        if (r13 < 0) goto L5;
        r11 = r12.invoke(Integer.valueOf(r13), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13)), r11);
        r13 = r13 - 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldRightIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> R m753foldRightIndexedmwnnOCs(long[] r10, R r11, Function3<? super Integer, ? super ULong, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = ArraysKt.getLastIndex(r10);
    L3:
        if (r13 < 0) goto L5;
        r11 = r12.invoke(Integer.valueOf(r13), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13)), r11);
        r13 = r13 - 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: foldRightIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> R m754foldRightIndexedyVwIW0Q(int[] r10, R r11, Function3<? super Integer, ? super UInt, ? super R, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        int r13 = ArraysKt.getLastIndex(r10);
    L3:
        if (r13 < 0) goto L5;
        r11 = r12.invoke(Integer.valueOf(r13), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13)), r11);
        r13 = r13 - 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: forEach-JOV_ifY, reason: not valid java name */
    private static final void m755forEachJOV_ifY(byte[] r10, Function1<? super UByte, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$forEach");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13)));
        r13 = r13 + 1;
        goto L3
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: forEach-MShoTSo, reason: not valid java name */
    private static final void m756forEachMShoTSo(long[] r10, Function1<? super ULong, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$forEach");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13)));
        r13 = r13 + 1;
        goto L3
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: forEach-jgv0xPQ, reason: not valid java name */
    private static final void m757forEachjgv0xPQ(int[] r10, Function1<? super UInt, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$forEach");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13)));
        r13 = r13 + 1;
        goto L3
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: forEach-xTcfx_M, reason: not valid java name */
    private static final void m758forEachxTcfx_M(short[] r10, Function1<? super UShort, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$forEach");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13)));
        r13 = r13 + 1;
        goto L3
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: forEachIndexed-ELGow60, reason: not valid java name */
    private static final void m759forEachIndexedELGow60(byte[] r10, Function2<? super Integer, ? super UByte, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r14), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13)));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L3
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: forEachIndexed-WyvcNBI, reason: not valid java name */
    private static final void m760forEachIndexedWyvcNBI(int[] r10, Function2<? super Integer, ? super UInt, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r14), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13)));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L3
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: forEachIndexed-s8dVfGU, reason: not valid java name */
    private static final void m761forEachIndexeds8dVfGU(long[] r10, Function2<? super Integer, ? super ULong, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r14), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13)));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L3
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: forEachIndexed-xzaTVY8, reason: not valid java name */
    private static final void m762forEachIndexedxzaTVY8(short[] r10, Function2<? super Integer, ? super UShort, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r14), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13)));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L3
    }

    /* JADX INFO: renamed from: getIndices--ajY-9A, reason: not valid java name */
    public static final IntRange m763getIndicesajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$indices");
        return ArraysKt.getIndices(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getIndices--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m764getIndicesajY9A$annotations(int[] r10) {
    }

    /* JADX INFO: renamed from: getIndices-GBYM_sE, reason: not valid java name */
    public static final IntRange m765getIndicesGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$indices");
        return ArraysKt.getIndices(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getIndices-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m766getIndicesGBYM_sE$annotations(byte[] r10) {
    }

    /* JADX INFO: renamed from: getIndices-QwZRm1k, reason: not valid java name */
    public static final IntRange m767getIndicesQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$indices");
        return ArraysKt.getIndices(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getIndices-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m768getIndicesQwZRm1k$annotations(long[] r10) {
    }

    /* JADX INFO: renamed from: getIndices-rL5Bavg, reason: not valid java name */
    public static final IntRange m769getIndicesrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$indices");
        return ArraysKt.getIndices(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getIndices-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m770getIndicesrL5Bavg$annotations(short[] r10) {
    }

    /* JADX INFO: renamed from: getLastIndex--ajY-9A, reason: not valid java name */
    public static final int m771getLastIndexajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastIndex");
        return ArraysKt.getLastIndex(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getLastIndex--ajY-9A$annotations, reason: not valid java name */
    public static /* synthetic */ void m772getLastIndexajY9A$annotations(int[] r10) {
    }

    /* JADX INFO: renamed from: getLastIndex-GBYM_sE, reason: not valid java name */
    public static final int m773getLastIndexGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastIndex");
        return ArraysKt.getLastIndex(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getLastIndex-GBYM_sE$annotations, reason: not valid java name */
    public static /* synthetic */ void m774getLastIndexGBYM_sE$annotations(byte[] r10) {
    }

    /* JADX INFO: renamed from: getLastIndex-QwZRm1k, reason: not valid java name */
    public static final int m775getLastIndexQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastIndex");
        return ArraysKt.getLastIndex(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getLastIndex-QwZRm1k$annotations, reason: not valid java name */
    public static /* synthetic */ void m776getLastIndexQwZRm1k$annotations(long[] r10) {
    }

    /* JADX INFO: renamed from: getLastIndex-rL5Bavg, reason: not valid java name */
    public static final int m777getLastIndexrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastIndex");
        return ArraysKt.getLastIndex(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getLastIndex-rL5Bavg$annotations, reason: not valid java name */
    public static /* synthetic */ void m778getLastIndexrL5Bavg$annotations(short[] r10) {
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: getOrElse-CVVdw08, reason: not valid java name */
    private static final short m779getOrElseCVVdw08(short[] r10, int r11, Function1<? super Integer, UShort> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > ArraysKt.getLastIndex(r10)) goto L8;
        return UShortArray.m371getMh2AYeg(r10, r11);
    L8:
        return r12.invoke(Integer.valueOf(r11)).m363unboximpl();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: getOrElse-QxvSvLU, reason: not valid java name */
    private static final int m780getOrElseQxvSvLU(int[] r10, int r11, Function1<? super Integer, UInt> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > ArraysKt.getLastIndex(r10)) goto L8;
        return UIntArray.m187getpVg5ArA(r10, r11);
    L8:
        return r12.invoke(Integer.valueOf(r11)).m179unboximpl();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: getOrElse-Xw8i6dc, reason: not valid java name */
    private static final long m781getOrElseXw8i6dc(long[] r10, int r11, Function1<? super Integer, ULong> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > ArraysKt.getLastIndex(r10)) goto L8;
        return ULongArray.m266getsVKNKU(r10, r11);
    L8:
        return r12.invoke(Integer.valueOf(r11)).m258unboximpl();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: getOrElse-cO-VybQ, reason: not valid java name */
    private static final byte m782getOrElsecOVybQ(byte[] r10, int r11, Function1<? super Integer, UByte> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$getOrElse");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L8;
        if (r11 > ArraysKt.getLastIndex(r10)) goto L8;
        return UByteArray.m108getw2LRezQ(r10, r11);
    L8:
        return r12.invoke(Integer.valueOf(r11)).m100unboximpl();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getOrNull-PpDY95g, reason: not valid java name */
    public static final UByte m783getOrNullPpDY95g(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$getOrNull");
        if (r11 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r11 > ArraysKt.getLastIndex(r10)) goto L7;
        return UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getOrNull-nggk6HY, reason: not valid java name */
    public static final UShort m784getOrNullnggk6HY(short[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$getOrNull");
        if (r11 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r11 > ArraysKt.getLastIndex(r10)) goto L7;
        return UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getOrNull-qFRl0hI, reason: not valid java name */
    public static final UInt m785getOrNullqFRl0hI(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$getOrNull");
        if (r11 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r11 > ArraysKt.getLastIndex(r10)) goto L7;
        return UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: getOrNull-r7IrZao, reason: not valid java name */
    public static final ULong m786getOrNullr7IrZao(long[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$getOrNull");
        if (r11 >= 0) goto L5;
    L7:
        return null;
    L5:
        if (r11 > ArraysKt.getLastIndex(r10)) goto L7;
        return ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupBy--_j2Y-Q, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m787groupBy_j2YQ(long[] r10, Function1<? super ULong, ? extends K> r11, Function1<? super ULong, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupBy");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        Intrinsics.checkNotNullParameter(r12, "valueTransform");
        LinkedHashMap r13 = new LinkedHashMap();
        int r14 = ULongArray.m267getSizeimpl(r10);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        long r16 = ULongArray.m266getsVKNKU(r10, r15);
        K r17 = r11.invoke(ULong.m200boximpl(r16));
        List<V> r18 = r13.get(r17);
        if (r18 != null) goto L7;
        r18 = new ArrayList();
        r13.put(r17, r18);
    L7:
        r18.add(r12.invoke(ULong.m200boximpl(r16)));
        r15 = r15 + 1;
        goto L3
    L8:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupBy-3bBvP4M, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m788groupBy3bBvP4M(short[] r10, Function1<? super UShort, ? extends K> r11, Function1<? super UShort, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupBy");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        Intrinsics.checkNotNullParameter(r12, "valueTransform");
        LinkedHashMap r13 = new LinkedHashMap();
        int r14 = UShortArray.m372getSizeimpl(r10);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        short r16 = UShortArray.m371getMh2AYeg(r10, r15);
        K r17 = r11.invoke(UShort.m307boximpl(r16));
        List<V> r18 = r13.get(r17);
        if (r18 != null) goto L7;
        r18 = new ArrayList();
        r13.put(r17, r18);
    L7:
        r18.add(r12.invoke(UShort.m307boximpl(r16)));
        r15 = r15 + 1;
        goto L3
    L8:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupBy-JOV_ifY, reason: not valid java name */
    private static final <K> Map<K, List<UByte>> m789groupByJOV_ifY(byte[] r10, Function1<? super UByte, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupBy");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        LinkedHashMap r12 = new LinkedHashMap();
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        K r16 = r11.invoke(UByte.m44boximpl(r15));
        Object r17 = r12.get(r16);
        if (r17 != null) goto L7;
        r17 = new ArrayList();
        r12.put(r16, r17);
    L7:
        ((List) r17).add(UByte.m44boximpl(r15));
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupBy-L4rlFek, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m790groupByL4rlFek(int[] r10, Function1<? super UInt, ? extends K> r11, Function1<? super UInt, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupBy");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        Intrinsics.checkNotNullParameter(r12, "valueTransform");
        LinkedHashMap r13 = new LinkedHashMap();
        int r14 = UIntArray.m188getSizeimpl(r10);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        int r16 = UIntArray.m187getpVg5ArA(r10, r15);
        K r17 = r11.invoke(UInt.m121boximpl(r16));
        List<V> r18 = r13.get(r17);
        if (r18 != null) goto L7;
        r18 = new ArrayList();
        r13.put(r17, r18);
    L7:
        r18.add(r12.invoke(UInt.m121boximpl(r16)));
        r15 = r15 + 1;
        goto L3
    L8:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupBy-MShoTSo, reason: not valid java name */
    private static final <K> Map<K, List<ULong>> m791groupByMShoTSo(long[] r10, Function1<? super ULong, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupBy");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        LinkedHashMap r12 = new LinkedHashMap();
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        K r16 = r11.invoke(ULong.m200boximpl(r15));
        Object r17 = r12.get(r16);
        if (r17 != null) goto L7;
        r17 = new ArrayList();
        r12.put(r16, r17);
    L7:
        ((List) r17).add(ULong.m200boximpl(r15));
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupBy-bBsjw1Y, reason: not valid java name */
    private static final <K, V> Map<K, List<V>> m792groupBybBsjw1Y(byte[] r10, Function1<? super UByte, ? extends K> r11, Function1<? super UByte, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupBy");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        Intrinsics.checkNotNullParameter(r12, "valueTransform");
        LinkedHashMap r13 = new LinkedHashMap();
        int r14 = UByteArray.m109getSizeimpl(r10);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r15);
        K r17 = r11.invoke(UByte.m44boximpl(r16));
        List<V> r18 = r13.get(r17);
        if (r18 != null) goto L7;
        r18 = new ArrayList();
        r13.put(r17, r18);
    L7:
        r18.add(r12.invoke(UByte.m44boximpl(r16)));
        r15 = r15 + 1;
        goto L3
    L8:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupBy-jgv0xPQ, reason: not valid java name */
    private static final <K> Map<K, List<UInt>> m793groupByjgv0xPQ(int[] r10, Function1<? super UInt, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupBy");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        LinkedHashMap r12 = new LinkedHashMap();
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        K r16 = r11.invoke(UInt.m121boximpl(r15));
        Object r17 = r12.get(r16);
        if (r17 != null) goto L7;
        r17 = new ArrayList();
        r12.put(r16, r17);
    L7:
        ((List) r17).add(UInt.m121boximpl(r15));
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupBy-xTcfx_M, reason: not valid java name */
    private static final <K> Map<K, List<UShort>> m794groupByxTcfx_M(short[] r10, Function1<? super UShort, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupBy");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        LinkedHashMap r12 = new LinkedHashMap();
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        K r16 = r11.invoke(UShort.m307boximpl(r15));
        Object r17 = r12.get(r16);
        if (r17 != null) goto L7;
        r17 = new ArrayList();
        r12.put(r16, r17);
    L7:
        ((List) r17).add(UShort.m307boximpl(r15));
        r14 = r14 + 1;
        goto L3
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupByTo-4D70W2E, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<UInt>>> M m795groupByTo4D70W2E(int[] r10, M r11, Function1<? super UInt, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        K r16 = r12.invoke(UInt.m121boximpl(r15));
        Object r17 = r11.get(r16);
        if (r17 != null) goto L7;
        r17 = new ArrayList();
        r11.put(r16, r17);
    L7:
        ((List) r17).add(UInt.m121boximpl(r15));
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupByTo-H21X9dk, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<UByte>>> M m796groupByToH21X9dk(byte[] r10, M r11, Function1<? super UByte, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        K r16 = r12.invoke(UByte.m44boximpl(r15));
        Object r17 = r11.get(r16);
        if (r17 != null) goto L7;
        r17 = new ArrayList();
        r11.put(r16, r17);
    L7:
        ((List) r17).add(UByte.m44boximpl(r15));
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupByTo-JM6gNCM, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m797groupByToJM6gNCM(int[] r10, M r11, Function1<? super UInt, ? extends K> r12, Function1<? super UInt, ? extends V> r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Intrinsics.checkNotNullParameter(r13, "valueTransform");
        int r14 = UIntArray.m188getSizeimpl(r10);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        int r16 = UIntArray.m187getpVg5ArA(r10, r15);
        K r17 = r12.invoke(UInt.m121boximpl(r16));
        Object r18 = r11.get(r17);
        if (r18 != null) goto L7;
        r18 = new ArrayList();
        r11.put(r17, r18);
    L7:
        ((List) r18).add(r13.invoke(UInt.m121boximpl(r16)));
        r15 = r15 + 1;
        goto L3
    L8:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupByTo-QxgOkWg, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m798groupByToQxgOkWg(long[] r10, M r11, Function1<? super ULong, ? extends K> r12, Function1<? super ULong, ? extends V> r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Intrinsics.checkNotNullParameter(r13, "valueTransform");
        int r14 = ULongArray.m267getSizeimpl(r10);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        long r16 = ULongArray.m266getsVKNKU(r10, r15);
        K r17 = r12.invoke(ULong.m200boximpl(r16));
        Object r18 = r11.get(r17);
        if (r18 != null) goto L7;
        r18 = new ArrayList();
        r11.put(r17, r18);
    L7:
        ((List) r18).add(r13.invoke(ULong.m200boximpl(r16)));
        r15 = r15 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupByTo-X6OPwNk, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<ULong>>> M m799groupByToX6OPwNk(long[] r10, M r11, Function1<? super ULong, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        K r16 = r12.invoke(ULong.m200boximpl(r15));
        Object r17 = r11.get(r16);
        if (r17 != null) goto L7;
        r17 = new ArrayList();
        r11.put(r16, r17);
    L7:
        ((List) r17).add(ULong.m200boximpl(r15));
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupByTo-ciTST-8, reason: not valid java name */
    private static final <K, M extends Map<? super K, List<UShort>>> M m800groupByTociTST8(short[] r10, M r11, Function1<? super UShort, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        K r16 = r12.invoke(UShort.m307boximpl(r15));
        Object r17 = r11.get(r16);
        if (r17 != null) goto L7;
        r17 = new ArrayList();
        r11.put(r16, r17);
    L7:
        ((List) r17).add(UShort.m307boximpl(r15));
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupByTo-q8RuPII, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m801groupByToq8RuPII(short[] r10, M r11, Function1<? super UShort, ? extends K> r12, Function1<? super UShort, ? extends V> r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Intrinsics.checkNotNullParameter(r13, "valueTransform");
        int r14 = UShortArray.m372getSizeimpl(r10);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        short r16 = UShortArray.m371getMh2AYeg(r10, r15);
        K r17 = r12.invoke(UShort.m307boximpl(r16));
        Object r18 = r11.get(r17);
        if (r18 != null) goto L7;
        r18 = new ArrayList();
        r11.put(r17, r18);
    L7:
        ((List) r18).add(r13.invoke(UShort.m307boximpl(r16)));
        r15 = r15 + 1;
        goto L3
    L8:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: groupByTo-qOZmbk8, reason: not valid java name */
    private static final <K, V, M extends Map<? super K, List<V>>> M m802groupByToqOZmbk8(byte[] r10, M r11, Function1<? super UByte, ? extends K> r12, Function1<? super UByte, ? extends V> r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Intrinsics.checkNotNullParameter(r13, "valueTransform");
        int r14 = UByteArray.m109getSizeimpl(r10);
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L8;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r15);
        K r17 = r12.invoke(UByte.m44boximpl(r16));
        Object r18 = r11.get(r17);
        if (r18 != null) goto L7;
        r18 = new ArrayList();
        r11.put(r17, r18);
    L7:
        ((List) r18).add(r13.invoke(UByte.m44boximpl(r16)));
        r15 = r15 + 1;
        goto L3
    L8:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOf-3uqUaXg, reason: not valid java name */
    private static final int m803indexOf3uqUaXg(long[] r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOf");
        return ArraysKt.indexOf(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOf-XzdR7RA, reason: not valid java name */
    private static final int m804indexOfXzdR7RA(short[] r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOf");
        return ArraysKt.indexOf(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOf-gMuBH34, reason: not valid java name */
    private static final int m805indexOfgMuBH34(byte[] r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOf");
        return ArraysKt.indexOf(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOf-uWY9BYg, reason: not valid java name */
    private static final int m806indexOfuWY9BYg(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOf");
        return ArraysKt.indexOf(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOfFirst-JOV_ifY, reason: not valid java name */
    private static final int m807indexOfFirstJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UByte.m44boximpl(UByte.m50constructorimpl(r10[r13]))).booleanValue() == true) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return r13;
    L8:
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOfFirst-MShoTSo, reason: not valid java name */
    private static final int m808indexOfFirstMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(ULong.m200boximpl(ULong.m206constructorimpl(r10[r13]))).booleanValue() == true) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return r13;
    L8:
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOfFirst-jgv0xPQ, reason: not valid java name */
    private static final int m809indexOfFirstjgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UInt.m121boximpl(UInt.m127constructorimpl(r10[r13]))).booleanValue() == true) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return r13;
    L8:
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOfFirst-xTcfx_M, reason: not valid java name */
    private static final int m810indexOfFirstxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UShort.m307boximpl(UShort.m313constructorimpl(r10[r13]))).booleanValue() == true) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return r13;
    L8:
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOfLast-JOV_ifY, reason: not valid java name */
    private static final int m811indexOfLastJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        if (r11.invoke(UByte.m44boximpl(UByte.m50constructorimpl(r10[r12]))).booleanValue() == true) goto L13;
        if (r13 < 0) goto L14;
        r12 = r13;
        goto L4
    L14:
        return -1;
    L13:
        return r12;
    L10:
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOfLast-MShoTSo, reason: not valid java name */
    private static final int m812indexOfLastMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        if (r11.invoke(ULong.m200boximpl(ULong.m206constructorimpl(r10[r12]))).booleanValue() == true) goto L13;
        if (r13 < 0) goto L14;
        r12 = r13;
        goto L4
    L14:
        return -1;
    L13:
        return r12;
    L10:
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOfLast-jgv0xPQ, reason: not valid java name */
    private static final int m813indexOfLastjgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        if (r11.invoke(UInt.m121boximpl(UInt.m127constructorimpl(r10[r12]))).booleanValue() == true) goto L13;
        if (r13 < 0) goto L14;
        r12 = r13;
        goto L4
    L14:
        return -1;
    L13:
        return r12;
    L10:
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: indexOfLast-xTcfx_M, reason: not valid java name */
    private static final int m814indexOfLastxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = r10.length - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        if (r11.invoke(UShort.m307boximpl(UShort.m313constructorimpl(r10[r12]))).booleanValue() == true) goto L13;
        if (r13 < 0) goto L14;
        r12 = r13;
        goto L4
    L14:
        return -1;
    L13:
        return r12;
    L10:
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: last--ajY-9A, reason: not valid java name */
    private static final int m815lastajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$last");
        return UInt.m127constructorimpl(ArraysKt.last(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: last-GBYM_sE, reason: not valid java name */
    private static final byte m816lastGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$last");
        return UByte.m50constructorimpl(ArraysKt.last(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: last-JOV_ifY, reason: not valid java name */
    private static final byte m817lastJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$last");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10) - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r12);
        if (r11.invoke(UByte.m44boximpl(r14)).booleanValue() == true) goto L6;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L6:
        return r14;
    L10:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: last-MShoTSo, reason: not valid java name */
    private static final long m818lastMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$last");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10) - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        long r14 = ULongArray.m266getsVKNKU(r10, r12);
        if (r11.invoke(ULong.m200boximpl(r14)).booleanValue() == true) goto L6;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L6:
        return r14;
    L10:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: last-QwZRm1k, reason: not valid java name */
    private static final long m819lastQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$last");
        return ULong.m206constructorimpl(ArraysKt.last(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: last-jgv0xPQ, reason: not valid java name */
    private static final int m820lastjgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$last");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10) - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        int r14 = UIntArray.m187getpVg5ArA(r10, r12);
        if (r11.invoke(UInt.m121boximpl(r14)).booleanValue() == true) goto L6;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L6:
        return r14;
    L10:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: last-rL5Bavg, reason: not valid java name */
    private static final short m821lastrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$last");
        return UShort.m313constructorimpl(ArraysKt.last(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: last-xTcfx_M, reason: not valid java name */
    private static final short m822lastxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$last");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10) - 1;
        if (r12 < 0) goto L10;
    L4:
        int r13 = r12 - 1;
        short r14 = UShortArray.m371getMh2AYeg(r10, r12);
        if (r11.invoke(UShort.m307boximpl(r14)).booleanValue() == true) goto L6;
        if (r13 < 0) goto L10;
        r12 = r13;
        goto L4
    L6:
        return r14;
    L10:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: lastIndexOf-3uqUaXg, reason: not valid java name */
    private static final int m823lastIndexOf3uqUaXg(long[] r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastIndexOf");
        return ArraysKt.lastIndexOf(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: lastIndexOf-XzdR7RA, reason: not valid java name */
    private static final int m824lastIndexOfXzdR7RA(short[] r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastIndexOf");
        return ArraysKt.lastIndexOf(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: lastIndexOf-gMuBH34, reason: not valid java name */
    private static final int m825lastIndexOfgMuBH34(byte[] r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastIndexOf");
        return ArraysKt.lastIndexOf(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: lastIndexOf-uWY9BYg, reason: not valid java name */
    private static final int m826lastIndexOfuWY9BYg(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastIndexOf");
        return ArraysKt.lastIndexOf(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: lastOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m827lastOrNullajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastOrNull");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        return UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, UIntArray.m188getSizeimpl(r10) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: lastOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m828lastOrNullGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastOrNull");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        return UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, UByteArray.m109getSizeimpl(r10) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: lastOrNull-JOV_ifY, reason: not valid java name */
    private static final UByte m829lastOrNullJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10) - 1;
        if (r12 < 0) goto L11;
    L4:
        int r13 = r12 - 1;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r12);
        if (r11.invoke(UByte.m44boximpl(r14)).booleanValue() == true) goto L7;
        if (r13 < 0) goto L15;
        r12 = r13;
        goto L4
    L15:
        return null;
    L7:
        return UByte.m44boximpl(r14);
    L11:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: lastOrNull-MShoTSo, reason: not valid java name */
    private static final ULong m830lastOrNullMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10) - 1;
        if (r12 < 0) goto L11;
    L4:
        int r13 = r12 - 1;
        long r14 = ULongArray.m266getsVKNKU(r10, r12);
        if (r11.invoke(ULong.m200boximpl(r14)).booleanValue() == true) goto L7;
        if (r13 < 0) goto L15;
        r12 = r13;
        goto L4
    L15:
        return null;
    L7:
        return ULong.m200boximpl(r14);
    L11:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: lastOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m831lastOrNullQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastOrNull");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        return ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, ULongArray.m267getSizeimpl(r10) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: lastOrNull-jgv0xPQ, reason: not valid java name */
    private static final UInt m832lastOrNulljgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10) - 1;
        if (r12 < 0) goto L11;
    L4:
        int r13 = r12 - 1;
        int r14 = UIntArray.m187getpVg5ArA(r10, r12);
        if (r11.invoke(UInt.m121boximpl(r14)).booleanValue() == true) goto L7;
        if (r13 < 0) goto L15;
        r12 = r13;
        goto L4
    L15:
        return null;
    L7:
        return UInt.m121boximpl(r14);
    L11:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: lastOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m833lastOrNullrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastOrNull");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        return UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, UShortArray.m372getSizeimpl(r10) - 1));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: lastOrNull-xTcfx_M, reason: not valid java name */
    private static final UShort m834lastOrNullxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10) - 1;
        if (r12 < 0) goto L11;
    L4:
        int r13 = r12 - 1;
        short r14 = UShortArray.m371getMh2AYeg(r10, r12);
        if (r11.invoke(UShort.m307boximpl(r14)).booleanValue() == true) goto L7;
        if (r13 < 0) goto L15;
        r12 = r13;
        goto L4
    L15:
        return null;
    L7:
        return UShort.m307boximpl(r14);
    L11:
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: map-JOV_ifY, reason: not valid java name */
    private static final <R> List<R> m835mapJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$map");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(UByteArray.m109getSizeimpl(r10));
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: map-MShoTSo, reason: not valid java name */
    private static final <R> List<R> m836mapMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$map");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(ULongArray.m267getSizeimpl(r10));
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: map-jgv0xPQ, reason: not valid java name */
    private static final <R> List<R> m837mapjgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$map");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(UIntArray.m188getSizeimpl(r10));
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: map-xTcfx_M, reason: not valid java name */
    private static final <R> List<R> m838mapxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$map");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(UShortArray.m372getSizeimpl(r10));
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapIndexed-ELGow60, reason: not valid java name */
    private static final <R> List<R> m839mapIndexedELGow60(byte[] r10, Function2<? super Integer, ? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(UByteArray.m109getSizeimpl(r10));
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(r11.invoke(Integer.valueOf(r15), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapIndexed-WyvcNBI, reason: not valid java name */
    private static final <R> List<R> m840mapIndexedWyvcNBI(int[] r10, Function2<? super Integer, ? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(UIntArray.m188getSizeimpl(r10));
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(r11.invoke(Integer.valueOf(r15), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapIndexed-s8dVfGU, reason: not valid java name */
    private static final <R> List<R> m841mapIndexeds8dVfGU(long[] r10, Function2<? super Integer, ? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(ULongArray.m267getSizeimpl(r10));
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(r11.invoke(Integer.valueOf(r15), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapIndexed-xzaTVY8, reason: not valid java name */
    private static final <R> List<R> m842mapIndexedxzaTVY8(short[] r10, Function2<? super Integer, ? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(r11, "transform");
        ArrayList r12 = new ArrayList(UShortArray.m372getSizeimpl(r10));
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.add(r11.invoke(Integer.valueOf(r15), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapIndexedTo--6EtJGI, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m843mapIndexedTo6EtJGI(int[] r10, C r11, Function2<? super Integer, ? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.add(r12.invoke(Integer.valueOf(r15), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapIndexedTo-QqktQ3k, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m844mapIndexedToQqktQ3k(short[] r10, C r11, Function2<? super Integer, ? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.add(r12.invoke(Integer.valueOf(r15), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapIndexedTo-eNpIKz8, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m845mapIndexedToeNpIKz8(byte[] r10, C r11, Function2<? super Integer, ? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.add(r12.invoke(Integer.valueOf(r15), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapIndexedTo-pe2Q0Dw, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m846mapIndexedTope2Q0Dw(long[] r10, C r11, Function2<? super Integer, ? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.add(r12.invoke(Integer.valueOf(r15), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))));
        r14 = r14 + 1;
        r15 = r15 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapTo-HqK1JgA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m847mapToHqK1JgA(long[] r10, C r11, Function1<? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.add(r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapTo-oEOeDjA, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m848mapTooEOeDjA(short[] r10, C r11, Function1<? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.add(r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapTo-wU5IKMo, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m849mapTowU5IKMo(int[] r10, C r11, Function1<? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.add(r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: mapTo-wzUQCXU, reason: not valid java name */
    private static final <R, C extends Collection<? super R>> C m850mapTowzUQCXU(byte[] r10, C r11, Function1<? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$mapTo");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.add(r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: maxByOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UByte m851maxByOrNullJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L9;
        R r14 = r11.invoke(UByte.m44boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L12:
        if (r15.hasNext() == false) goto L17;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r15.nextInt());
        R r17 = r11.invoke(UByte.m44boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L12;
        r12 = r16;
        r14 = r17;
        goto L12
    L17:
        return UByte.m44boximpl(r12);
    L9:
        return UByte.m44boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: maxByOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> ULong m852maxByOrNullMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L9;
        R r14 = r11.invoke(ULong.m200boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L12:
        if (r15.hasNext() == false) goto L17;
        long r16 = ULongArray.m266getsVKNKU(r10, r15.nextInt());
        R r17 = r11.invoke(ULong.m200boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L12;
        r12 = r16;
        r14 = r17;
        goto L12
    L17:
        return ULong.m200boximpl(r12);
    L9:
        return ULong.m200boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: maxByOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UInt m853maxByOrNulljgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L9;
        R r14 = r11.invoke(UInt.m121boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L12:
        if (r15.hasNext() == false) goto L17;
        int r16 = UIntArray.m187getpVg5ArA(r10, r15.nextInt());
        R r17 = r11.invoke(UInt.m121boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L12;
        r12 = r16;
        r14 = r17;
        goto L12
    L17:
        return UInt.m121boximpl(r12);
    L9:
        return UInt.m121boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: maxByOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UShort m854maxByOrNullxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L9;
        R r14 = r11.invoke(UShort.m307boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L12:
        if (r15.hasNext() == false) goto L17;
        short r16 = UShortArray.m371getMh2AYeg(r10, r15.nextInt());
        R r17 = r11.invoke(UShort.m307boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L12;
        r12 = r16;
        r14 = r17;
        goto L12
    L17:
        return UShort.m307boximpl(r12);
    L9:
        return UShort.m307boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "maxByOrThrow-U")
    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> byte m855maxByOrThrowU(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L15;
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 != 0) goto L7;
        return r12;
    L7:
        R r14 = r11.invoke(UByte.m44boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L9:
        if (r15.hasNext() == false) goto L13;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r15.nextInt());
        R r17 = r11.invoke(UByte.m44boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L9;
        r12 = r16;
        r14 = r17;
        goto L9
    L13:
        return r12;
    L15:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "maxByOrThrow-U")
    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> int m856maxByOrThrowU(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L15;
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 != 0) goto L7;
        return r12;
    L7:
        R r14 = r11.invoke(UInt.m121boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L9:
        if (r15.hasNext() == false) goto L13;
        int r16 = UIntArray.m187getpVg5ArA(r10, r15.nextInt());
        R r17 = r11.invoke(UInt.m121boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L9;
        r12 = r16;
        r14 = r17;
        goto L9
    L13:
        return r12;
    L15:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "maxByOrThrow-U")
    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> long m857maxByOrThrowU(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L15;
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 != 0) goto L7;
        return r12;
    L7:
        R r14 = r11.invoke(ULong.m200boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L9:
        if (r15.hasNext() == false) goto L13;
        long r16 = ULongArray.m266getsVKNKU(r10, r15.nextInt());
        R r17 = r11.invoke(ULong.m200boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L9;
        r12 = r16;
        r14 = r17;
        goto L9
    L13:
        return r12;
    L15:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "maxByOrThrow-U")
    /* JADX INFO: renamed from: maxByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> short m858maxByOrThrowU(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L15;
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 != 0) goto L7;
        return r12;
    L7:
        R r14 = r11.invoke(UShort.m307boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L9:
        if (r15.hasNext() == false) goto L13;
        short r16 = UShortArray.m371getMh2AYeg(r10, r15.nextInt());
        R r17 = r11.invoke(UShort.m307boximpl(r16));
        if (r14.compareTo(r17) >= 0) goto L9;
        r12 = r16;
        r14 = r17;
        goto L9
    L13:
        return r12;
    L15:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final double m859maxOfJOV_ifY(byte[] r10, Function1<? super UByte, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L10;
        double r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt()))).doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final float m860maxOfJOV_ifY(byte[] r10, Function1<? super UByte, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L10;
        float r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt()))).floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m861maxOfJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L12;
        R r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        R r14 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt())));
        if (r12.compareTo(r14) >= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final double m862maxOfMShoTSo(long[] r10, Function1<? super ULong, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L10;
        double r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt()))).doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final float m863maxOfMShoTSo(long[] r10, Function1<? super ULong, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L10;
        float r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt()))).floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m864maxOfMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L12;
        R r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        R r14 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt())));
        if (r12.compareTo(r14) >= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final double m865maxOfjgv0xPQ(int[] r10, Function1<? super UInt, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L10;
        double r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt()))).doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final float m866maxOfjgv0xPQ(int[] r10, Function1<? super UInt, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L10;
        float r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt()))).floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m867maxOfjgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L12;
        R r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        R r14 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt())));
        if (r12.compareTo(r14) >= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final double m868maxOfxTcfx_M(short[] r10, Function1<? super UShort, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L10;
        double r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt()))).doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final float m869maxOfxTcfx_M(short[] r10, Function1<? super UShort, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L10;
        float r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt()))).floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOf-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m870maxOfxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L12;
        R r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        R r14 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt())));
        if (r12.compareTo(r14) >= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m871maxOfOrNullJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L12;
        R r14 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt())));
        if (r12.compareTo(r14) >= 0) goto L8;
        r12 = r14;
        goto L8
    L12:
        return r12;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Double m872maxOfOrNullJOV_ifY(byte[] r10, Function1<? super UByte, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        double r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt()))).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Float m873maxOfOrNullJOV_ifY(byte[] r10, Function1<? super UByte, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        float r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt()))).floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m874maxOfOrNullMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L12;
        R r14 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt())));
        if (r12.compareTo(r14) >= 0) goto L8;
        r12 = r14;
        goto L8
    L12:
        return r12;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final Double m875maxOfOrNullMShoTSo(long[] r10, Function1<? super ULong, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        double r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt()))).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-MShoTSo, reason: not valid java name */
    private static final Float m876maxOfOrNullMShoTSo(long[] r10, Function1<? super ULong, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        float r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt()))).floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m877maxOfOrNulljgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L12;
        R r14 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt())));
        if (r12.compareTo(r14) >= 0) goto L8;
        r12 = r14;
        goto L8
    L12:
        return r12;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Double m878maxOfOrNulljgv0xPQ(int[] r10, Function1<? super UInt, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        double r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt()))).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Float m879maxOfOrNulljgv0xPQ(int[] r10, Function1<? super UInt, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        float r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt()))).floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m880maxOfOrNullxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L12;
        R r14 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt())));
        if (r12.compareTo(r14) >= 0) goto L8;
        r12 = r14;
        goto L8
    L12:
        return r12;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Double m881maxOfOrNullxTcfx_M(short[] r10, Function1<? super UShort, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        double r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt()))).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Float m882maxOfOrNullxTcfx_M(short[] r10, Function1<? super UShort, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        float r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt()))).floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfWith-5NtCtWE, reason: not valid java name */
    private static final <R> R m883maxOfWith5NtCtWE(long[] r10, Comparator<? super R> r11, Function1<? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L12;
        R r13 = r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r14.hasNext() == false) goto L10;
        R r15 = r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14.nextInt())));
        if (r11.compare(r13, r15) >= 0) goto L6;
        r13 = r15;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfWith-LTi4i_s, reason: not valid java name */
    private static final <R> R m884maxOfWithLTi4i_s(byte[] r10, Comparator<? super R> r11, Function1<? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L12;
        R r13 = r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r14.hasNext() == false) goto L10;
        R r15 = r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14.nextInt())));
        if (r11.compare(r13, r15) >= 0) goto L6;
        r13 = r15;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfWith-l8EHGbQ, reason: not valid java name */
    private static final <R> R m885maxOfWithl8EHGbQ(short[] r10, Comparator<? super R> r11, Function1<? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L12;
        R r13 = r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r14.hasNext() == false) goto L10;
        R r15 = r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14.nextInt())));
        if (r11.compare(r13, r15) >= 0) goto L6;
        r13 = r15;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfWith-myNOsp4, reason: not valid java name */
    private static final <R> R m886maxOfWithmyNOsp4(int[] r10, Comparator<? super R> r11, Function1<? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L12;
        R r13 = r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r14.hasNext() == false) goto L10;
        R r15 = r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14.nextInt())));
        if (r11.compare(r13, r15) >= 0) goto L6;
        r13 = r15;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfWithOrNull-5NtCtWE, reason: not valid java name */
    private static final <R> R m887maxOfWithOrNull5NtCtWE(long[] r10, Comparator<? super R> r11, Function1<? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r13 = r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r14.hasNext() == false) goto L12;
        R r15 = r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14.nextInt())));
        if (r11.compare(r13, r15) >= 0) goto L8;
        r13 = r15;
        goto L8
    L12:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfWithOrNull-LTi4i_s, reason: not valid java name */
    private static final <R> R m888maxOfWithOrNullLTi4i_s(byte[] r10, Comparator<? super R> r11, Function1<? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r13 = r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r14.hasNext() == false) goto L12;
        R r15 = r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14.nextInt())));
        if (r11.compare(r13, r15) >= 0) goto L8;
        r13 = r15;
        goto L8
    L12:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfWithOrNull-l8EHGbQ, reason: not valid java name */
    private static final <R> R m889maxOfWithOrNulll8EHGbQ(short[] r10, Comparator<? super R> r11, Function1<? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r13 = r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r14.hasNext() == false) goto L12;
        R r15 = r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14.nextInt())));
        if (r11.compare(r13, r15) >= 0) goto L8;
        r13 = r15;
        goto L8
    L12:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: maxOfWithOrNull-myNOsp4, reason: not valid java name */
    private static final <R> R m890maxOfWithOrNullmyNOsp4(int[] r10, Comparator<? super R> r11, Function1<? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOfWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r13 = r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r14.hasNext() == false) goto L12;
        R r15 = r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14.nextInt())));
        if (r11.compare(r13, r15) >= 0) goto L8;
        r13 = r15;
        goto L8
    L12:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m891maxOrNullajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOrNull");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        int r11 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r12.hasNext() == false) goto L13;
        int r13 = UIntArray.m187getpVg5ArA(r10, r12.nextInt());
        if (Integer.compareUnsigned(r11, r13) >= 0) goto L8;
        r11 = r13;
        goto L8
    L13:
        return UInt.m121boximpl(r11);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m892maxOrNullGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOrNull");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        byte r11 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r12.hasNext() == false) goto L13;
        byte r13 = UByteArray.m108getw2LRezQ(r10, r12.nextInt());
        if (Intrinsics.compare(r11 & 255, r13 & 255) >= 0) goto L8;
        r11 = r13;
        goto L8
    L13:
        return UByte.m44boximpl(r11);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m893maxOrNullQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOrNull");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        long r11 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r12.hasNext() == false) goto L13;
        long r13 = ULongArray.m266getsVKNKU(r10, r12.nextInt());
        if (Long.compareUnsigned(r11, r13) >= 0) goto L8;
        r11 = r13;
        goto L8
    L13:
        return ULong.m200boximpl(r11);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m894maxOrNullrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxOrNull");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        short r11 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r12.hasNext() == false) goto L13;
        short r13 = UShortArray.m371getMh2AYeg(r10, r12.nextInt());
        if (Intrinsics.compare(r11 & UShort.MAX_VALUE, 65535 & r13) >= 0) goto L8;
        r11 = r13;
        goto L8
    L13:
        return UShort.m307boximpl(r11);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final byte m895maxOrThrowU(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$max");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L12;
        byte r11 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r12.hasNext() == false) goto L10;
        byte r13 = UByteArray.m108getw2LRezQ(r10, r12.nextInt());
        if (Intrinsics.compare(r11 & 255, r13 & 255) >= 0) goto L6;
        r11 = r13;
        goto L6
    L10:
        return r11;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final int m896maxOrThrowU(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$max");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L12;
        int r11 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r12.hasNext() == false) goto L10;
        int r13 = UIntArray.m187getpVg5ArA(r10, r12.nextInt());
        if (Integer.compareUnsigned(r11, r13) >= 0) goto L6;
        r11 = r13;
        goto L6
    L10:
        return r11;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final long m897maxOrThrowU(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$max");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L12;
        long r11 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r12.hasNext() == false) goto L10;
        long r13 = ULongArray.m266getsVKNKU(r10, r12.nextInt());
        if (Long.compareUnsigned(r11, r13) >= 0) goto L6;
        r11 = r13;
        goto L6
    L10:
        return r11;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxOrThrow-U")
    /* JADX INFO: renamed from: maxOrThrow-U, reason: not valid java name */
    public static final short m898maxOrThrowU(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$max");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L12;
        short r11 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r12.hasNext() == false) goto L10;
        short r13 = UShortArray.m371getMh2AYeg(r10, r12.nextInt());
        if (Intrinsics.compare(r11 & UShort.MAX_VALUE, 65535 & r13) >= 0) goto L6;
        r11 = r13;
        goto L6
    L10:
        return r11;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m899maxWithOrNullXMRcp5o(byte[] r10, Comparator<? super UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L13;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r13.nextInt());
        if (r11.compare(UByte.m44boximpl(r12), UByte.m44boximpl(r14)) >= 0) goto L8;
        r12 = r14;
        goto L8
    L13:
        return UByte.m44boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m900maxWithOrNullYmdZ_VM(int[] r10, Comparator<? super UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L13;
        int r14 = UIntArray.m187getpVg5ArA(r10, r13.nextInt());
        if (r11.compare(UInt.m121boximpl(r12), UInt.m121boximpl(r14)) >= 0) goto L8;
        r12 = r14;
        goto L8
    L13:
        return UInt.m121boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m901maxWithOrNulleOHTfZs(short[] r10, Comparator<? super UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L13;
        short r14 = UShortArray.m371getMh2AYeg(r10, r13.nextInt());
        if (r11.compare(UShort.m307boximpl(r12), UShort.m307boximpl(r14)) >= 0) goto L8;
        r12 = r14;
        goto L8
    L13:
        return UShort.m307boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: maxWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m902maxWithOrNullzrEWJaI(long[] r10, Comparator<? super ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L13;
        long r14 = ULongArray.m266getsVKNKU(r10, r13.nextInt());
        if (r11.compare(ULong.m200boximpl(r12), ULong.m200boximpl(r14)) >= 0) goto L8;
        r12 = r14;
        goto L8
    L13:
        return ULong.m200boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final byte m903maxWithOrThrowU(byte[] r10, Comparator<? super UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L12;
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r13.nextInt());
        if (r11.compare(UByte.m44boximpl(r12), UByte.m44boximpl(r14)) >= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final int m904maxWithOrThrowU(int[] r10, Comparator<? super UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L12;
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        int r14 = UIntArray.m187getpVg5ArA(r10, r13.nextInt());
        if (r11.compare(UInt.m121boximpl(r12), UInt.m121boximpl(r14)) >= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final long m905maxWithOrThrowU(long[] r10, Comparator<? super ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L12;
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        long r14 = ULongArray.m266getsVKNKU(r10, r13.nextInt());
        if (r11.compare(ULong.m200boximpl(r12), ULong.m200boximpl(r14)) >= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "maxWithOrThrow-U")
    /* JADX INFO: renamed from: maxWithOrThrow-U, reason: not valid java name */
    public static final short m906maxWithOrThrowU(short[] r10, Comparator<? super UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$maxWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L12;
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        short r14 = UShortArray.m371getMh2AYeg(r10, r13.nextInt());
        if (r11.compare(UShort.m307boximpl(r12), UShort.m307boximpl(r14)) >= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: minByOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UByte m907minByOrNullJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L9;
        R r14 = r11.invoke(UByte.m44boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L12:
        if (r15.hasNext() == false) goto L17;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r15.nextInt());
        R r17 = r11.invoke(UByte.m44boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L12;
        r12 = r16;
        r14 = r17;
        goto L12
    L17:
        return UByte.m44boximpl(r12);
    L9:
        return UByte.m44boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: minByOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> ULong m908minByOrNullMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L9;
        R r14 = r11.invoke(ULong.m200boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L12:
        if (r15.hasNext() == false) goto L17;
        long r16 = ULongArray.m266getsVKNKU(r10, r15.nextInt());
        R r17 = r11.invoke(ULong.m200boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L12;
        r12 = r16;
        r14 = r17;
        goto L12
    L17:
        return ULong.m200boximpl(r12);
    L9:
        return ULong.m200boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: minByOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UInt m909minByOrNulljgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L9;
        R r14 = r11.invoke(UInt.m121boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L12:
        if (r15.hasNext() == false) goto L17;
        int r16 = UIntArray.m187getpVg5ArA(r10, r15.nextInt());
        R r17 = r11.invoke(UInt.m121boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L12;
        r12 = r16;
        r14 = r17;
        goto L12
    L17:
        return UInt.m121boximpl(r12);
    L9:
        return UInt.m121boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: minByOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> UShort m910minByOrNullxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 == 0) goto L9;
        R r14 = r11.invoke(UShort.m307boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L12:
        if (r15.hasNext() == false) goto L17;
        short r16 = UShortArray.m371getMh2AYeg(r10, r15.nextInt());
        R r17 = r11.invoke(UShort.m307boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L12;
        r12 = r16;
        r14 = r17;
        goto L12
    L17:
        return UShort.m307boximpl(r12);
    L9:
        return UShort.m307boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "minByOrThrow-U")
    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> byte m911minByOrThrowU(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L15;
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 != 0) goto L7;
        return r12;
    L7:
        R r14 = r11.invoke(UByte.m44boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L9:
        if (r15.hasNext() == false) goto L13;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r15.nextInt());
        R r17 = r11.invoke(UByte.m44boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L9;
        r12 = r16;
        r14 = r17;
        goto L9
    L13:
        return r12;
    L15:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "minByOrThrow-U")
    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> int m912minByOrThrowU(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L15;
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 != 0) goto L7;
        return r12;
    L7:
        R r14 = r11.invoke(UInt.m121boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L9:
        if (r15.hasNext() == false) goto L13;
        int r16 = UIntArray.m187getpVg5ArA(r10, r15.nextInt());
        R r17 = r11.invoke(UInt.m121boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L9;
        r12 = r16;
        r14 = r17;
        goto L9
    L13:
        return r12;
    L15:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "minByOrThrow-U")
    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> long m913minByOrThrowU(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L15;
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 != 0) goto L7;
        return r12;
    L7:
        R r14 = r11.invoke(ULong.m200boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L9:
        if (r15.hasNext() == false) goto L13;
        long r16 = ULongArray.m266getsVKNKU(r10, r15.nextInt());
        R r17 = r11.invoke(ULong.m200boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L9;
        r12 = r16;
        r14 = r17;
        goto L9
    L13:
        return r12;
    L15:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "minByOrThrow-U")
    /* JADX INFO: renamed from: minByOrThrow-U, reason: not valid java name */
    private static final <R extends Comparable<? super R>> short m914minByOrThrowU(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L15;
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        int r13 = ArraysKt.getLastIndex(r10);
        if (r13 != 0) goto L7;
        return r12;
    L7:
        R r14 = r11.invoke(UShort.m307boximpl(r12));
        ?? r15 = new IntRange(1, r13).iterator2();
    L9:
        if (r15.hasNext() == false) goto L13;
        short r16 = UShortArray.m371getMh2AYeg(r10, r15.nextInt());
        R r17 = r11.invoke(UShort.m307boximpl(r16));
        if (r14.compareTo(r17) <= 0) goto L9;
        r12 = r16;
        r14 = r17;
        goto L9
    L13:
        return r12;
    L15:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final double m915minOfJOV_ifY(byte[] r10, Function1<? super UByte, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L10;
        double r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt()))).doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final float m916minOfJOV_ifY(byte[] r10, Function1<? super UByte, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L10;
        float r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt()))).floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m917minOfJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L12;
        R r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        R r14 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt())));
        if (r12.compareTo(r14) <= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final double m918minOfMShoTSo(long[] r10, Function1<? super ULong, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L10;
        double r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt()))).doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final float m919minOfMShoTSo(long[] r10, Function1<? super ULong, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L10;
        float r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt()))).floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m920minOfMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L12;
        R r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        R r14 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt())));
        if (r12.compareTo(r14) <= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final double m921minOfjgv0xPQ(int[] r10, Function1<? super UInt, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L10;
        double r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt()))).doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final float m922minOfjgv0xPQ(int[] r10, Function1<? super UInt, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L10;
        float r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt()))).floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m923minOfjgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L12;
        R r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        R r14 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt())));
        if (r12.compareTo(r14) <= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final double m924minOfxTcfx_M(short[] r10, Function1<? super UShort, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L10;
        double r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt()))).doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final float m925minOfxTcfx_M(short[] r10, Function1<? super UShort, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L10;
        float r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt()))).floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOf-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m926minOfxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L12;
        R r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        R r14 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt())));
        if (r12.compareTo(r14) <= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m927minOfOrNullJOV_ifY(byte[] r10, Function1<? super UByte, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L12;
        R r14 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt())));
        if (r12.compareTo(r14) <= 0) goto L8;
        r12 = r14;
        goto L8
    L12:
        return r12;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Double m928minOfOrNullJOV_ifY(byte[] r10, Function1<? super UByte, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        double r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt()))).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-JOV_ifY, reason: not valid java name */
    private static final Float m929minOfOrNullJOV_ifY(byte[] r10, Function1<? super UByte, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        float r12 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13.nextInt()))).floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m930minOfOrNullMShoTSo(long[] r10, Function1<? super ULong, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L12;
        R r14 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt())));
        if (r12.compareTo(r14) <= 0) goto L8;
        r12 = r14;
        goto L8
    L12:
        return r12;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final Double m931minOfOrNullMShoTSo(long[] r10, Function1<? super ULong, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        double r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt()))).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-MShoTSo, reason: not valid java name */
    private static final Float m932minOfOrNullMShoTSo(long[] r10, Function1<? super ULong, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        float r12 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13.nextInt()))).floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m933minOfOrNulljgv0xPQ(int[] r10, Function1<? super UInt, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L12;
        R r14 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt())));
        if (r12.compareTo(r14) <= 0) goto L8;
        r12 = r14;
        goto L8
    L12:
        return r12;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Double m934minOfOrNulljgv0xPQ(int[] r10, Function1<? super UInt, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        double r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt()))).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-jgv0xPQ, reason: not valid java name */
    private static final Float m935minOfOrNulljgv0xPQ(int[] r10, Function1<? super UInt, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        float r12 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13.nextInt()))).floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final <R extends Comparable<? super R>> R m936minOfOrNullxTcfx_M(short[] r10, Function1<? super UShort, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0)));
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L12;
        R r14 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt())));
        if (r12.compareTo(r14) <= 0) goto L8;
        r12 = r14;
        goto L8
    L12:
        return r12;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Double m937minOfOrNullxTcfx_M(short[] r10, Function1<? super UShort, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        double r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0))).doubleValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt()))).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfOrNull-xTcfx_M, reason: not valid java name */
    private static final Float m938minOfOrNullxTcfx_M(short[] r10, Function1<? super UShort, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfOrNull");
        Intrinsics.checkNotNullParameter(r11, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        float r12 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0))).floatValue();
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13.nextInt()))).floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfWith-5NtCtWE, reason: not valid java name */
    private static final <R> R m939minOfWith5NtCtWE(long[] r10, Comparator<? super R> r11, Function1<? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L12;
        R r13 = r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r14.hasNext() == false) goto L10;
        R r15 = r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14.nextInt())));
        if (r11.compare(r13, r15) <= 0) goto L6;
        r13 = r15;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfWith-LTi4i_s, reason: not valid java name */
    private static final <R> R m940minOfWithLTi4i_s(byte[] r10, Comparator<? super R> r11, Function1<? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L12;
        R r13 = r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r14.hasNext() == false) goto L10;
        R r15 = r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14.nextInt())));
        if (r11.compare(r13, r15) <= 0) goto L6;
        r13 = r15;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfWith-l8EHGbQ, reason: not valid java name */
    private static final <R> R m941minOfWithl8EHGbQ(short[] r10, Comparator<? super R> r11, Function1<? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L12;
        R r13 = r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r14.hasNext() == false) goto L10;
        R r15 = r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14.nextInt())));
        if (r11.compare(r13, r15) <= 0) goto L6;
        r13 = r15;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfWith-myNOsp4, reason: not valid java name */
    private static final <R> R m942minOfWithmyNOsp4(int[] r10, Comparator<? super R> r11, Function1<? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L12;
        R r13 = r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r14.hasNext() == false) goto L10;
        R r15 = r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14.nextInt())));
        if (r11.compare(r13, r15) <= 0) goto L6;
        r13 = r15;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfWithOrNull-5NtCtWE, reason: not valid java name */
    private static final <R> R m943minOfWithOrNull5NtCtWE(long[] r10, Comparator<? super R> r11, Function1<? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r13 = r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r14.hasNext() == false) goto L12;
        R r15 = r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14.nextInt())));
        if (r11.compare(r13, r15) <= 0) goto L8;
        r13 = r15;
        goto L8
    L12:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfWithOrNull-LTi4i_s, reason: not valid java name */
    private static final <R> R m944minOfWithOrNullLTi4i_s(byte[] r10, Comparator<? super R> r11, Function1<? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r13 = r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r14.hasNext() == false) goto L12;
        R r15 = r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14.nextInt())));
        if (r11.compare(r13, r15) <= 0) goto L8;
        r13 = r15;
        goto L8
    L12:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfWithOrNull-l8EHGbQ, reason: not valid java name */
    private static final <R> R m945minOfWithOrNulll8EHGbQ(short[] r10, Comparator<? super R> r11, Function1<? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r13 = r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r14.hasNext() == false) goto L12;
        R r15 = r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14.nextInt())));
        if (r11.compare(r13, r15) <= 0) goto L8;
        r13 = r15;
        goto L8
    L12:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @OverloadResolutionByLambdaReturnType
    /* JADX INFO: renamed from: minOfWithOrNull-myNOsp4, reason: not valid java name */
    private static final <R> R m946minOfWithOrNullmyNOsp4(int[] r10, Comparator<? super R> r11, Function1<? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOfWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        R r13 = r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0)));
        ?? r14 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r14.hasNext() == false) goto L12;
        R r15 = r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14.nextInt())));
        if (r11.compare(r13, r15) <= 0) goto L8;
        r13 = r15;
        goto L8
    L12:
        return r13;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m947minOrNullajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOrNull");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        int r11 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r12.hasNext() == false) goto L13;
        int r13 = UIntArray.m187getpVg5ArA(r10, r12.nextInt());
        if (Integer.compareUnsigned(r11, r13) <= 0) goto L8;
        r11 = r13;
        goto L8
    L13:
        return UInt.m121boximpl(r11);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m948minOrNullGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOrNull");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        byte r11 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r12.hasNext() == false) goto L13;
        byte r13 = UByteArray.m108getw2LRezQ(r10, r12.nextInt());
        if (Intrinsics.compare(r11 & 255, r13 & 255) <= 0) goto L8;
        r11 = r13;
        goto L8
    L13:
        return UByte.m44boximpl(r11);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m949minOrNullQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOrNull");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        long r11 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r12.hasNext() == false) goto L13;
        long r13 = ULongArray.m266getsVKNKU(r10, r12.nextInt());
        if (Long.compareUnsigned(r11, r13) <= 0) goto L8;
        r11 = r13;
        goto L8
    L13:
        return ULong.m200boximpl(r11);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m950minOrNullrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$minOrNull");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        short r11 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r12.hasNext() == false) goto L13;
        short r13 = UShortArray.m371getMh2AYeg(r10, r12.nextInt());
        if (Intrinsics.compare(r11 & UShort.MAX_VALUE, 65535 & r13) <= 0) goto L8;
        r11 = r13;
        goto L8
    L13:
        return UShort.m307boximpl(r11);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final byte m951minOrThrowU(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$min");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L12;
        byte r11 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r12.hasNext() == false) goto L10;
        byte r13 = UByteArray.m108getw2LRezQ(r10, r12.nextInt());
        if (Intrinsics.compare(r11 & 255, r13 & 255) <= 0) goto L6;
        r11 = r13;
        goto L6
    L10:
        return r11;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final int m952minOrThrowU(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$min");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L12;
        int r11 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r12.hasNext() == false) goto L10;
        int r13 = UIntArray.m187getpVg5ArA(r10, r12.nextInt());
        if (Integer.compareUnsigned(r11, r13) <= 0) goto L6;
        r11 = r13;
        goto L6
    L10:
        return r11;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final long m953minOrThrowU(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$min");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L12;
        long r11 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r12.hasNext() == false) goto L10;
        long r13 = ULongArray.m266getsVKNKU(r10, r12.nextInt());
        if (Long.compareUnsigned(r11, r13) <= 0) goto L6;
        r11 = r13;
        goto L6
    L10:
        return r11;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minOrThrow-U")
    /* JADX INFO: renamed from: minOrThrow-U, reason: not valid java name */
    public static final short m954minOrThrowU(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$min");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L12;
        short r11 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r12 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r12.hasNext() == false) goto L10;
        short r13 = UShortArray.m371getMh2AYeg(r10, r12.nextInt());
        if (Intrinsics.compare(r11 & UShort.MAX_VALUE, 65535 & r13) <= 0) goto L6;
        r11 = r13;
        goto L6
    L10:
        return r11;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minWithOrNull-XMRcp5o, reason: not valid java name */
    public static final UByte m955minWithOrNullXMRcp5o(byte[] r10, Comparator<? super UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L13;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r13.nextInt());
        if (r11.compare(UByte.m44boximpl(r12), UByte.m44boximpl(r14)) <= 0) goto L8;
        r12 = r14;
        goto L8
    L13:
        return UByte.m44boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minWithOrNull-YmdZ_VM, reason: not valid java name */
    public static final UInt m956minWithOrNullYmdZ_VM(int[] r10, Comparator<? super UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L13;
        int r14 = UIntArray.m187getpVg5ArA(r10, r13.nextInt());
        if (r11.compare(UInt.m121boximpl(r12), UInt.m121boximpl(r14)) <= 0) goto L8;
        r12 = r14;
        goto L8
    L13:
        return UInt.m121boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minWithOrNull-eOHTfZs, reason: not valid java name */
    public static final UShort m957minWithOrNulleOHTfZs(short[] r10, Comparator<? super UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L13;
        short r14 = UShortArray.m371getMh2AYeg(r10, r13.nextInt());
        if (r11.compare(UShort.m307boximpl(r12), UShort.m307boximpl(r14)) <= 0) goto L8;
        r12 = r14;
        goto L8
    L13:
        return UShort.m307boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: minWithOrNull-zrEWJaI, reason: not valid java name */
    public static final ULong m958minWithOrNullzrEWJaI(long[] r10, Comparator<? super ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L13;
        long r14 = ULongArray.m266getsVKNKU(r10, r13.nextInt());
        if (r11.compare(ULong.m200boximpl(r12), ULong.m200boximpl(r14)) <= 0) goto L8;
        r12 = r14;
        goto L8
    L13:
        return ULong.m200boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final byte m959minWithOrThrowU(byte[] r10, Comparator<? super UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L12;
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r13.nextInt());
        if (r11.compare(UByte.m44boximpl(r12), UByte.m44boximpl(r14)) <= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final int m960minWithOrThrowU(int[] r10, Comparator<? super UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L12;
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        int r14 = UIntArray.m187getpVg5ArA(r10, r13.nextInt());
        if (r11.compare(UInt.m121boximpl(r12), UInt.m121boximpl(r14)) <= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final long m961minWithOrThrowU(long[] r10, Comparator<? super ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L12;
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        long r14 = ULongArray.m266getsVKNKU(r10, r13.nextInt());
        if (r11.compare(ULong.m200boximpl(r12), ULong.m200boximpl(r14)) <= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.7")
    @ExperimentalUnsignedTypes
    @JvmName(name = "minWithOrThrow-U")
    /* JADX INFO: renamed from: minWithOrThrow-U, reason: not valid java name */
    public static final short m962minWithOrThrowU(short[] r10, Comparator<? super UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$minWith");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L12;
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L10;
        short r14 = UShortArray.m371getMh2AYeg(r10, r13.nextInt());
        if (r11.compare(UShort.m307boximpl(r12), UShort.m307boximpl(r14)) <= 0) goto L6;
        r12 = r14;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: none--ajY-9A, reason: not valid java name */
    private static final boolean m963noneajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$none");
        return UIntArray.m190isEmptyimpl(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: none-GBYM_sE, reason: not valid java name */
    private static final boolean m964noneGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$none");
        return UByteArray.m111isEmptyimpl(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: none-JOV_ifY, reason: not valid java name */
    private static final boolean m965noneJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$none");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13))).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: none-MShoTSo, reason: not valid java name */
    private static final boolean m966noneMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$none");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13))).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: none-QwZRm1k, reason: not valid java name */
    private static final boolean m967noneQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$none");
        return ULongArray.m269isEmptyimpl(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: none-jgv0xPQ, reason: not valid java name */
    private static final boolean m968nonejgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$none");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13))).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: none-rL5Bavg, reason: not valid java name */
    private static final boolean m969nonerL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$none");
        return UShortArray.m374isEmptyimpl(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: none-xTcfx_M, reason: not valid java name */
    private static final boolean m970nonexTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$none");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13))).booleanValue() == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: onEach-JOV_ifY, reason: not valid java name */
    private static final byte[] m971onEachJOV_ifY(byte[] r10, Function1<? super UByte, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$onEach");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: onEach-MShoTSo, reason: not valid java name */
    private static final long[] m972onEachMShoTSo(long[] r10, Function1<? super ULong, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$onEach");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: onEach-jgv0xPQ, reason: not valid java name */
    private static final int[] m973onEachjgv0xPQ(int[] r10, Function1<? super UInt, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$onEach");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: onEach-xTcfx_M, reason: not valid java name */
    private static final short[] m974onEachxTcfx_M(short[] r10, Function1<? super UShort, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$onEach");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: onEachIndexed-ELGow60, reason: not valid java name */
    private static final byte[] m975onEachIndexedELGow60(byte[] r10, Function2<? super Integer, ? super UByte, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r14), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13)));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: onEachIndexed-WyvcNBI, reason: not valid java name */
    private static final int[] m976onEachIndexedWyvcNBI(int[] r10, Function2<? super Integer, ? super UInt, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r14), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13)));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: onEachIndexed-s8dVfGU, reason: not valid java name */
    private static final long[] m977onEachIndexeds8dVfGU(long[] r10, Function2<? super Integer, ? super ULong, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r14), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13)));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: onEachIndexed-xzaTVY8, reason: not valid java name */
    private static final short[] m978onEachIndexedxzaTVY8(short[] r10, Function2<? super Integer, ? super UShort, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.invoke(Integer.valueOf(r14), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13)));
        r13 = r13 + 1;
        r14 = r14 + 1;
        goto L3
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: plus-3uqUaXg, reason: not valid java name */
    private static final long[] m979plus3uqUaXg(long[] r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        return ULongArray.m261constructorimpl(ArraysKt.plus(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: plus-CFIt9YE, reason: not valid java name */
    public static final int[] m980plusCFIt9YE(int[] r10, Collection<UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int[] r13 = Arrays.copyOf(r10, UIntArray.m188getSizeimpl(r10) + r11.size());
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(this, newSize)");
        Iterator<UInt> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        r13[r12] = r14.next().m179unboximpl();
        r12 = r12 + 1;
        goto L4
    L7:
        return UIntArray.m182constructorimpl(r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: plus-XzdR7RA, reason: not valid java name */
    private static final short[] m981plusXzdR7RA(short[] r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        return UShortArray.m366constructorimpl(ArraysKt.plus(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: plus-ctEhBpI, reason: not valid java name */
    private static final int[] m982plusctEhBpI(int[] r10, int[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return UIntArray.m182constructorimpl(ArraysKt.plus(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: plus-gMuBH34, reason: not valid java name */
    private static final byte[] m983plusgMuBH34(byte[] r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        return UByteArray.m103constructorimpl(ArraysKt.plus(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: plus-kdPth3s, reason: not valid java name */
    private static final byte[] m984pluskdPth3s(byte[] r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return UByteArray.m103constructorimpl(ArraysKt.plus(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: plus-kzHmqpY, reason: not valid java name */
    public static final long[] m985pluskzHmqpY(long[] r10, Collection<ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = ULongArray.m267getSizeimpl(r10);
        long[] r13 = Arrays.copyOf(r10, ULongArray.m267getSizeimpl(r10) + r11.size());
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(this, newSize)");
        Iterator<ULong> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        r13[r12] = r14.next().m258unboximpl();
        r12 = r12 + 1;
        goto L4
    L7:
        return ULongArray.m261constructorimpl(r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: plus-mazbYpA, reason: not valid java name */
    private static final short[] m986plusmazbYpA(short[] r10, short[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return UShortArray.m366constructorimpl(ArraysKt.plus(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: plus-ojwP5H8, reason: not valid java name */
    public static final short[] m987plusojwP5H8(short[] r10, Collection<UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = UShortArray.m372getSizeimpl(r10);
        short[] r13 = Arrays.copyOf(r10, UShortArray.m372getSizeimpl(r10) + r11.size());
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(this, newSize)");
        Iterator<UShort> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        r13[r12] = r14.next().m363unboximpl();
        r12 = r12 + 1;
        goto L4
    L7:
        return UShortArray.m366constructorimpl(r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: plus-uWY9BYg, reason: not valid java name */
    private static final int[] m988plusuWY9BYg(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        return UIntArray.m182constructorimpl(ArraysKt.plus(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: plus-us8wMrg, reason: not valid java name */
    private static final long[] m989plusus8wMrg(long[] r10, long[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return ULongArray.m261constructorimpl(ArraysKt.plus(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: plus-xo_DsdI, reason: not valid java name */
    public static final byte[] m990plusxo_DsdI(byte[] r10, Collection<UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$plus");
        Intrinsics.checkNotNullParameter(r11, "elements");
        int r12 = UByteArray.m109getSizeimpl(r10);
        byte[] r13 = Arrays.copyOf(r10, UByteArray.m109getSizeimpl(r10) + r11.size());
        Intrinsics.checkNotNullExpressionValue(r13, "copyOf(this, newSize)");
        Iterator<UByte> r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L7;
        r13[r12] = r14.next().m100unboximpl();
        r12 = r12 + 1;
        goto L4
    L7:
        return UByteArray.m103constructorimpl(r13);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: random--ajY-9A, reason: not valid java name */
    private static final int m991randomajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$random");
        return m992random2D5oskM(r10, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: random-2D5oskM, reason: not valid java name */
    public static final int m992random2D5oskM(int[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$random");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L7;
        return UIntArray.m187getpVg5ArA(r10, r11.nextInt(UIntArray.m188getSizeimpl(r10)));
    L7:
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: random-GBYM_sE, reason: not valid java name */
    private static final byte m993randomGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$random");
        return m996randomoSF2wD8(r10, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: random-JzugnMA, reason: not valid java name */
    public static final long m994randomJzugnMA(long[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$random");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L7;
        return ULongArray.m266getsVKNKU(r10, r11.nextInt(ULongArray.m267getSizeimpl(r10)));
    L7:
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: random-QwZRm1k, reason: not valid java name */
    private static final long m995randomQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$random");
        return m994randomJzugnMA(r10, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: random-oSF2wD8, reason: not valid java name */
    public static final byte m996randomoSF2wD8(byte[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$random");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L7;
        return UByteArray.m108getw2LRezQ(r10, r11.nextInt(UByteArray.m109getSizeimpl(r10)));
    L7:
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: random-rL5Bavg, reason: not valid java name */
    private static final short m997randomrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$random");
        return m998randoms5X_as8(r10, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: random-s5X_as8, reason: not valid java name */
    public static final short m998randoms5X_as8(short[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$random");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L7;
        return UShortArray.m371getMh2AYeg(r10, r11.nextInt(UShortArray.m372getSizeimpl(r10)));
    L7:
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: randomOrNull--ajY-9A, reason: not valid java name */
    private static final UInt m999randomOrNullajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$randomOrNull");
        return m1000randomOrNull2D5oskM(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: randomOrNull-2D5oskM, reason: not valid java name */
    public static final UInt m1000randomOrNull2D5oskM(int[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L7;
        return null;
    L7:
        return UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r11.nextInt(UIntArray.m188getSizeimpl(r10))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: randomOrNull-GBYM_sE, reason: not valid java name */
    private static final UByte m1001randomOrNullGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$randomOrNull");
        return m1004randomOrNulloSF2wD8(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: randomOrNull-JzugnMA, reason: not valid java name */
    public static final ULong m1002randomOrNullJzugnMA(long[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L7;
        return null;
    L7:
        return ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r11.nextInt(ULongArray.m267getSizeimpl(r10))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: randomOrNull-QwZRm1k, reason: not valid java name */
    private static final ULong m1003randomOrNullQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$randomOrNull");
        return m1002randomOrNullJzugnMA(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: randomOrNull-oSF2wD8, reason: not valid java name */
    public static final UByte m1004randomOrNulloSF2wD8(byte[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L7;
        return null;
    L7:
        return UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r11.nextInt(UByteArray.m109getSizeimpl(r10))));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: randomOrNull-rL5Bavg, reason: not valid java name */
    private static final UShort m1005randomOrNullrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$randomOrNull");
        return m1006randomOrNulls5X_as8(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: randomOrNull-s5X_as8, reason: not valid java name */
    public static final UShort m1006randomOrNulls5X_as8(short[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L7;
        return null;
    L7:
        return UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r11.nextInt(UShortArray.m372getSizeimpl(r10))));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduce-ELGow60, reason: not valid java name */
    private static final byte m1007reduceELGow60(byte[] r10, Function2<? super UByte, ? super UByte, UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduce");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L10;
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        int r14 = r13.nextInt();
        r12 = r11.invoke(UByte.m44boximpl(r12), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))).m100unboximpl();
        goto L6
    L8:
        return r12;
    L10:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduce-WyvcNBI, reason: not valid java name */
    private static final int m1008reduceWyvcNBI(int[] r10, Function2<? super UInt, ? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduce");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L10;
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        int r14 = r13.nextInt();
        r12 = r11.invoke(UInt.m121boximpl(r12), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))).m179unboximpl();
        goto L6
    L8:
        return r12;
    L10:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduce-s8dVfGU, reason: not valid java name */
    private static final long m1009reduces8dVfGU(long[] r10, Function2<? super ULong, ? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduce");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L10;
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        int r14 = r13.nextInt();
        r12 = r11.invoke(ULong.m200boximpl(r12), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))).m258unboximpl();
        goto L6
    L8:
        return r12;
    L10:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduce-xzaTVY8, reason: not valid java name */
    private static final short m1010reducexzaTVY8(short[] r10, Function2<? super UShort, ? super UShort, UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduce");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L10;
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        int r14 = r13.nextInt();
        r12 = r11.invoke(UShort.m307boximpl(r12), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))).m363unboximpl();
        goto L6
    L8:
        return r12;
    L10:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceIndexed-D40WMg8, reason: not valid java name */
    private static final int m1011reduceIndexedD40WMg8(int[] r10, Function3<? super Integer, ? super UInt, ? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L10;
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        int r14 = r13.nextInt();
        r12 = r11.invoke(Integer.valueOf(r14), UInt.m121boximpl(r12), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))).m179unboximpl();
        goto L6
    L8:
        return r12;
    L10:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceIndexed-EOyYB1Y, reason: not valid java name */
    private static final byte m1012reduceIndexedEOyYB1Y(byte[] r10, Function3<? super Integer, ? super UByte, ? super UByte, UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L10;
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        int r14 = r13.nextInt();
        r12 = r11.invoke(Integer.valueOf(r14), UByte.m44boximpl(r12), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))).m100unboximpl();
        goto L6
    L8:
        return r12;
    L10:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceIndexed-aLgx1Fo, reason: not valid java name */
    private static final short m1013reduceIndexedaLgx1Fo(short[] r10, Function3<? super Integer, ? super UShort, ? super UShort, UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L10;
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        int r14 = r13.nextInt();
        r12 = r11.invoke(Integer.valueOf(r14), UShort.m307boximpl(r12), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))).m363unboximpl();
        goto L6
    L8:
        return r12;
    L10:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceIndexed-z1zDJgo, reason: not valid java name */
    private static final long m1014reduceIndexedz1zDJgo(long[] r10, Function3<? super Integer, ? super ULong, ? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L10;
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L6:
        if (r13.hasNext() == false) goto L8;
        int r14 = r13.nextInt();
        r12 = r11.invoke(Integer.valueOf(r14), ULong.m200boximpl(r12), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))).m258unboximpl();
        goto L6
    L8:
        return r12;
    L10:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceIndexedOrNull-D40WMg8, reason: not valid java name */
    private static final UInt m1015reduceIndexedOrNullD40WMg8(int[] r10, Function3<? super Integer, ? super UInt, ? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        int r14 = r13.nextInt();
        r12 = r11.invoke(Integer.valueOf(r14), UInt.m121boximpl(r12), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))).m179unboximpl();
        goto L8
    L11:
        return UInt.m121boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceIndexedOrNull-EOyYB1Y, reason: not valid java name */
    private static final UByte m1016reduceIndexedOrNullEOyYB1Y(byte[] r10, Function3<? super Integer, ? super UByte, ? super UByte, UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        int r14 = r13.nextInt();
        r12 = r11.invoke(Integer.valueOf(r14), UByte.m44boximpl(r12), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))).m100unboximpl();
        goto L8
    L11:
        return UByte.m44boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceIndexedOrNull-aLgx1Fo, reason: not valid java name */
    private static final UShort m1017reduceIndexedOrNullaLgx1Fo(short[] r10, Function3<? super Integer, ? super UShort, ? super UShort, UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        int r14 = r13.nextInt();
        r12 = r11.invoke(Integer.valueOf(r14), UShort.m307boximpl(r12), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))).m363unboximpl();
        goto L8
    L11:
        return UShort.m307boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceIndexedOrNull-z1zDJgo, reason: not valid java name */
    private static final ULong m1018reduceIndexedOrNullz1zDJgo(long[] r10, Function3<? super Integer, ? super ULong, ? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        int r14 = r13.nextInt();
        r12 = r11.invoke(Integer.valueOf(r14), ULong.m200boximpl(r12), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))).m258unboximpl();
        goto L8
    L11:
        return ULong.m200boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: reduceOrNull-ELGow60, reason: not valid java name */
    private static final UByte m1019reduceOrNullELGow60(byte[] r10, Function2<? super UByte, ? super UByte, UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        int r14 = r13.nextInt();
        r12 = r11.invoke(UByte.m44boximpl(r12), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))).m100unboximpl();
        goto L8
    L11:
        return UByte.m44boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: reduceOrNull-WyvcNBI, reason: not valid java name */
    private static final UInt m1020reduceOrNullWyvcNBI(int[] r10, Function2<? super UInt, ? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        int r14 = r13.nextInt();
        r12 = r11.invoke(UInt.m121boximpl(r12), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))).m179unboximpl();
        goto L8
    L11:
        return UInt.m121boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: reduceOrNull-s8dVfGU, reason: not valid java name */
    private static final ULong m1021reduceOrNulls8dVfGU(long[] r10, Function2<? super ULong, ? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        int r14 = r13.nextInt();
        r12 = r11.invoke(ULong.m200boximpl(r12), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))).m258unboximpl();
        goto L8
    L11:
        return ULong.m200boximpl(r12);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: reduceOrNull-xzaTVY8, reason: not valid java name */
    private static final UShort m1022reduceOrNullxzaTVY8(short[] r10, Function2<? super UShort, ? super UShort, UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L6;
        return null;
    L6:
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        ?? r13 = new IntRange(1, ArraysKt.getLastIndex(r10)).iterator2();
    L8:
        if (r13.hasNext() == false) goto L11;
        int r14 = r13.nextInt();
        r12 = r11.invoke(UShort.m307boximpl(r12), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))).m363unboximpl();
        goto L8
    L11:
        return UShort.m307boximpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRight-ELGow60, reason: not valid java name */
    private static final byte m1023reduceRightELGow60(byte[] r10, Function2<? super UByte, ? super UByte, UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 < 0) goto L9;
        int r13 = r12 - 1;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r12);
    L5:
        if (r13 < 0) goto L7;
        r14 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13)), UByte.m44boximpl(r14)).m100unboximpl();
        r13 = r13 - 1;
        goto L5
    L7:
        return r14;
    L9:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRight-WyvcNBI, reason: not valid java name */
    private static final int m1024reduceRightWyvcNBI(int[] r10, Function2<? super UInt, ? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 < 0) goto L9;
        int r13 = r12 - 1;
        int r14 = UIntArray.m187getpVg5ArA(r10, r12);
    L5:
        if (r13 < 0) goto L7;
        r14 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13)), UInt.m121boximpl(r14)).m179unboximpl();
        r13 = r13 - 1;
        goto L5
    L7:
        return r14;
    L9:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRight-s8dVfGU, reason: not valid java name */
    private static final long m1025reduceRights8dVfGU(long[] r10, Function2<? super ULong, ? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 < 0) goto L9;
        int r13 = r12 - 1;
        long r14 = ULongArray.m266getsVKNKU(r10, r12);
    L5:
        if (r13 < 0) goto L7;
        r14 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13)), ULong.m200boximpl(r14)).m258unboximpl();
        r13 = r13 - 1;
        goto L5
    L7:
        return r14;
    L9:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRight-xzaTVY8, reason: not valid java name */
    private static final short m1026reduceRightxzaTVY8(short[] r10, Function2<? super UShort, ? super UShort, UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 < 0) goto L9;
        int r13 = r12 - 1;
        short r14 = UShortArray.m371getMh2AYeg(r10, r12);
    L5:
        if (r13 < 0) goto L7;
        r14 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13)), UShort.m307boximpl(r14)).m363unboximpl();
        r13 = r13 - 1;
        goto L5
    L7:
        return r14;
    L9:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRightIndexed-D40WMg8, reason: not valid java name */
    private static final int m1027reduceRightIndexedD40WMg8(int[] r10, Function3<? super Integer, ? super UInt, ? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 < 0) goto L9;
        int r13 = r12 - 1;
        int r14 = UIntArray.m187getpVg5ArA(r10, r12);
    L5:
        if (r13 < 0) goto L7;
        r14 = r11.invoke(Integer.valueOf(r13), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13)), UInt.m121boximpl(r14)).m179unboximpl();
        r13 = r13 - 1;
        goto L5
    L7:
        return r14;
    L9:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRightIndexed-EOyYB1Y, reason: not valid java name */
    private static final byte m1028reduceRightIndexedEOyYB1Y(byte[] r10, Function3<? super Integer, ? super UByte, ? super UByte, UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 < 0) goto L9;
        int r13 = r12 - 1;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r12);
    L5:
        if (r13 < 0) goto L7;
        r14 = r11.invoke(Integer.valueOf(r13), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13)), UByte.m44boximpl(r14)).m100unboximpl();
        r13 = r13 - 1;
        goto L5
    L7:
        return r14;
    L9:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRightIndexed-aLgx1Fo, reason: not valid java name */
    private static final short m1029reduceRightIndexedaLgx1Fo(short[] r10, Function3<? super Integer, ? super UShort, ? super UShort, UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 < 0) goto L9;
        int r13 = r12 - 1;
        short r14 = UShortArray.m371getMh2AYeg(r10, r12);
    L5:
        if (r13 < 0) goto L7;
        r14 = r11.invoke(Integer.valueOf(r13), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13)), UShort.m307boximpl(r14)).m363unboximpl();
        r13 = r13 - 1;
        goto L5
    L7:
        return r14;
    L9:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRightIndexed-z1zDJgo, reason: not valid java name */
    private static final long m1030reduceRightIndexedz1zDJgo(long[] r10, Function3<? super Integer, ? super ULong, ? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 < 0) goto L9;
        int r13 = r12 - 1;
        long r14 = ULongArray.m266getsVKNKU(r10, r12);
    L5:
        if (r13 < 0) goto L7;
        r14 = r11.invoke(Integer.valueOf(r13), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13)), ULong.m200boximpl(r14)).m258unboximpl();
        r13 = r13 - 1;
        goto L5
    L7:
        return r14;
    L9:
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRightIndexedOrNull-D40WMg8, reason: not valid java name */
    private static final UInt m1031reduceRightIndexedOrNullD40WMg8(int[] r10, Function3<? super Integer, ? super UInt, ? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 >= 0) goto L6;
        return null;
    L6:
        int r13 = r12 - 1;
        int r14 = UIntArray.m187getpVg5ArA(r10, r12);
    L7:
        if (r13 < 0) goto L10;
        r14 = r11.invoke(Integer.valueOf(r13), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13)), UInt.m121boximpl(r14)).m179unboximpl();
        r13 = r13 - 1;
        goto L7
    L10:
        return UInt.m121boximpl(r14);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRightIndexedOrNull-EOyYB1Y, reason: not valid java name */
    private static final UByte m1032reduceRightIndexedOrNullEOyYB1Y(byte[] r10, Function3<? super Integer, ? super UByte, ? super UByte, UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 >= 0) goto L6;
        return null;
    L6:
        int r13 = r12 - 1;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r12);
    L7:
        if (r13 < 0) goto L10;
        r14 = r11.invoke(Integer.valueOf(r13), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13)), UByte.m44boximpl(r14)).m100unboximpl();
        r13 = r13 - 1;
        goto L7
    L10:
        return UByte.m44boximpl(r14);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRightIndexedOrNull-aLgx1Fo, reason: not valid java name */
    private static final UShort m1033reduceRightIndexedOrNullaLgx1Fo(short[] r10, Function3<? super Integer, ? super UShort, ? super UShort, UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 >= 0) goto L6;
        return null;
    L6:
        int r13 = r12 - 1;
        short r14 = UShortArray.m371getMh2AYeg(r10, r12);
    L7:
        if (r13 < 0) goto L10;
        r14 = r11.invoke(Integer.valueOf(r13), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13)), UShort.m307boximpl(r14)).m363unboximpl();
        r13 = r13 - 1;
        goto L7
    L10:
        return UShort.m307boximpl(r14);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reduceRightIndexedOrNull-z1zDJgo, reason: not valid java name */
    private static final ULong m1034reduceRightIndexedOrNullz1zDJgo(long[] r10, Function3<? super Integer, ? super ULong, ? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 >= 0) goto L6;
        return null;
    L6:
        int r13 = r12 - 1;
        long r14 = ULongArray.m266getsVKNKU(r10, r12);
    L7:
        if (r13 < 0) goto L10;
        r14 = r11.invoke(Integer.valueOf(r13), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13)), ULong.m200boximpl(r14)).m258unboximpl();
        r13 = r13 - 1;
        goto L7
    L10:
        return ULong.m200boximpl(r14);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: reduceRightOrNull-ELGow60, reason: not valid java name */
    private static final UByte m1035reduceRightOrNullELGow60(byte[] r10, Function2<? super UByte, ? super UByte, UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 >= 0) goto L6;
        return null;
    L6:
        int r13 = r12 - 1;
        byte r14 = UByteArray.m108getw2LRezQ(r10, r12);
    L7:
        if (r13 < 0) goto L10;
        r14 = r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13)), UByte.m44boximpl(r14)).m100unboximpl();
        r13 = r13 - 1;
        goto L7
    L10:
        return UByte.m44boximpl(r14);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: reduceRightOrNull-WyvcNBI, reason: not valid java name */
    private static final UInt m1036reduceRightOrNullWyvcNBI(int[] r10, Function2<? super UInt, ? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 >= 0) goto L6;
        return null;
    L6:
        int r13 = r12 - 1;
        int r14 = UIntArray.m187getpVg5ArA(r10, r12);
    L7:
        if (r13 < 0) goto L10;
        r14 = r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13)), UInt.m121boximpl(r14)).m179unboximpl();
        r13 = r13 - 1;
        goto L7
    L10:
        return UInt.m121boximpl(r14);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: reduceRightOrNull-s8dVfGU, reason: not valid java name */
    private static final ULong m1037reduceRightOrNulls8dVfGU(long[] r10, Function2<? super ULong, ? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 >= 0) goto L6;
        return null;
    L6:
        int r13 = r12 - 1;
        long r14 = ULongArray.m266getsVKNKU(r10, r12);
    L7:
        if (r13 < 0) goto L10;
        r14 = r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13)), ULong.m200boximpl(r14)).m258unboximpl();
        r13 = r13 - 1;
        goto L7
    L10:
        return ULong.m200boximpl(r14);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: reduceRightOrNull-xzaTVY8, reason: not valid java name */
    private static final UShort m1038reduceRightOrNullxzaTVY8(short[] r10, Function2<? super UShort, ? super UShort, UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(r11, "operation");
        int r12 = ArraysKt.getLastIndex(r10);
        if (r12 >= 0) goto L6;
        return null;
    L6:
        int r13 = r12 - 1;
        short r14 = UShortArray.m371getMh2AYeg(r10, r12);
    L7:
        if (r13 < 0) goto L10;
        r14 = r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13)), UShort.m307boximpl(r14)).m363unboximpl();
        r13 = r13 - 1;
        goto L7
    L10:
        return UShort.m307boximpl(r14);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reverse--ajY-9A, reason: not valid java name */
    private static final void m1039reverseajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reverse");
        ArraysKt.reverse(r10);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reverse--nroSd4, reason: not valid java name */
    private static final void m1040reversenroSd4(long[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$reverse");
        ArraysKt.reverse(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reverse-4UcCI2c, reason: not valid java name */
    private static final void m1041reverse4UcCI2c(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$reverse");
        ArraysKt.reverse(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reverse-Aa5vz7o, reason: not valid java name */
    private static final void m1042reverseAa5vz7o(short[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$reverse");
        ArraysKt.reverse(r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reverse-GBYM_sE, reason: not valid java name */
    private static final void m1043reverseGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reverse");
        ArraysKt.reverse(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reverse-QwZRm1k, reason: not valid java name */
    private static final void m1044reverseQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reverse");
        ArraysKt.reverse(r10);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reverse-oBK06Vg, reason: not valid java name */
    private static final void m1045reverseoBK06Vg(int[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$reverse");
        ArraysKt.reverse(r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reverse-rL5Bavg, reason: not valid java name */
    private static final void m1046reverserL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reverse");
        ArraysKt.reverse(r10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: reversed--ajY-9A, reason: not valid java name */
    public static final List<UInt> m1047reversedajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reversed");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L5;
        List<UInt> r11 = CollectionsKt.toMutableList(UIntArray.m180boximpl(r10));
        CollectionsKt.reverse(r11);
        return r11;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: reversed-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m1048reversedGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reversed");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L5;
        List<UByte> r11 = CollectionsKt.toMutableList(UByteArray.m101boximpl(r10));
        CollectionsKt.reverse(r11);
        return r11;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: reversed-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m1049reversedQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reversed");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L5;
        List<ULong> r11 = CollectionsKt.toMutableList(ULongArray.m259boximpl(r10));
        CollectionsKt.reverse(r11);
        return r11;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: reversed-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m1050reversedrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reversed");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L5;
        List<UShort> r11 = CollectionsKt.toMutableList(UShortArray.m364boximpl(r10));
        CollectionsKt.reverse(r11);
        return r11;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reversedArray--ajY-9A, reason: not valid java name */
    private static final int[] m1051reversedArrayajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reversedArray");
        return UIntArray.m182constructorimpl(ArraysKt.reversedArray(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reversedArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m1052reversedArrayGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reversedArray");
        return UByteArray.m103constructorimpl(ArraysKt.reversedArray(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reversedArray-QwZRm1k, reason: not valid java name */
    private static final long[] m1053reversedArrayQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reversedArray");
        return ULongArray.m261constructorimpl(ArraysKt.reversedArray(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: reversedArray-rL5Bavg, reason: not valid java name */
    private static final short[] m1054reversedArrayrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$reversedArray");
        return UShortArray.m366constructorimpl(ArraysKt.reversedArray(r10));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningFold-A8wKCXQ, reason: not valid java name */
    private static final <R> List<R> m1055runningFoldA8wKCXQ(long[] r10, R r11, Function2<? super R, ? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningFold");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L5;
        ArrayList r13 = new ArrayList(ULongArray.m267getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = ULongArray.m267getSizeimpl(r10);
    L7:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(r16, ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningFold-yXmHNn8, reason: not valid java name */
    private static final <R> List<R> m1056runningFoldyXmHNn8(byte[] r10, R r11, Function2<? super R, ? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningFold");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L5;
        ArrayList r13 = new ArrayList(UByteArray.m109getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UByteArray.m109getSizeimpl(r10);
    L7:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(r16, UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningFold-zi1B2BA, reason: not valid java name */
    private static final <R> List<R> m1057runningFoldzi1B2BA(int[] r10, R r11, Function2<? super R, ? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningFold");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L5;
        ArrayList r13 = new ArrayList(UIntArray.m188getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UIntArray.m188getSizeimpl(r10);
    L7:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(r16, UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningFold-zww5nb8, reason: not valid java name */
    private static final <R> List<R> m1058runningFoldzww5nb8(short[] r10, R r11, Function2<? super R, ? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningFold");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L5;
        ArrayList r13 = new ArrayList(UShortArray.m372getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UShortArray.m372getSizeimpl(r10);
    L7:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(r16, UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningFoldIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> List<R> m1059runningFoldIndexed3iWJZGE(byte[] r10, R r11, Function3<? super Integer, ? super R, ? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L5;
        ArrayList r13 = new ArrayList(UByteArray.m109getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UByteArray.m109getSizeimpl(r10);
    L7:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r14), r16, UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningFoldIndexed-bzxtMww, reason: not valid java name */
    private static final <R> List<R> m1060runningFoldIndexedbzxtMww(short[] r10, R r11, Function3<? super Integer, ? super R, ? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L5;
        ArrayList r13 = new ArrayList(UShortArray.m372getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UShortArray.m372getSizeimpl(r10);
    L7:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r14), r16, UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningFoldIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> List<R> m1061runningFoldIndexedmwnnOCs(long[] r10, R r11, Function3<? super Integer, ? super R, ? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L5;
        ArrayList r13 = new ArrayList(ULongArray.m267getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = ULongArray.m267getSizeimpl(r10);
    L7:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r14), r16, ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningFoldIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> List<R> m1062runningFoldIndexedyVwIW0Q(int[] r10, R r11, Function3<? super Integer, ? super R, ? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L5;
        ArrayList r13 = new ArrayList(UIntArray.m188getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UIntArray.m188getSizeimpl(r10);
    L7:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r14), r16, UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningReduce-ELGow60, reason: not valid java name */
    private static final List<UByte> m1063runningReduceELGow60(byte[] r10, Function2<? super UByte, ? super UByte, UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L5;
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        ArrayList r13 = new ArrayList(UByteArray.m109getSizeimpl(r10));
        r13.add(UByte.m44boximpl(r12));
        int r14 = UByteArray.m109getSizeimpl(r10);
        int r15 = 1;
    L7:
        if (r15 >= r14) goto L9;
        r12 = r11.invoke(UByte.m44boximpl(r12), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r15))).m100unboximpl();
        r13.add(UByte.m44boximpl(r12));
        r15 = r15 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningReduce-WyvcNBI, reason: not valid java name */
    private static final List<UInt> m1064runningReduceWyvcNBI(int[] r10, Function2<? super UInt, ? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L5;
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        ArrayList r13 = new ArrayList(UIntArray.m188getSizeimpl(r10));
        r13.add(UInt.m121boximpl(r12));
        int r14 = UIntArray.m188getSizeimpl(r10);
        int r15 = 1;
    L7:
        if (r15 >= r14) goto L9;
        r12 = r11.invoke(UInt.m121boximpl(r12), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r15))).m179unboximpl();
        r13.add(UInt.m121boximpl(r12));
        r15 = r15 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningReduce-s8dVfGU, reason: not valid java name */
    private static final List<ULong> m1065runningReduces8dVfGU(long[] r10, Function2<? super ULong, ? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L5;
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        ArrayList r13 = new ArrayList(ULongArray.m267getSizeimpl(r10));
        r13.add(ULong.m200boximpl(r12));
        int r14 = ULongArray.m267getSizeimpl(r10);
        int r15 = 1;
    L7:
        if (r15 >= r14) goto L9;
        r12 = r11.invoke(ULong.m200boximpl(r12), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r15))).m258unboximpl();
        r13.add(ULong.m200boximpl(r12));
        r15 = r15 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningReduce-xzaTVY8, reason: not valid java name */
    private static final List<UShort> m1066runningReducexzaTVY8(short[] r10, Function2<? super UShort, ? super UShort, UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L5;
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        ArrayList r13 = new ArrayList(UShortArray.m372getSizeimpl(r10));
        r13.add(UShort.m307boximpl(r12));
        int r14 = UShortArray.m372getSizeimpl(r10);
        int r15 = 1;
    L7:
        if (r15 >= r14) goto L9;
        r12 = r11.invoke(UShort.m307boximpl(r12), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r15))).m363unboximpl();
        r13.add(UShort.m307boximpl(r12));
        r15 = r15 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningReduceIndexed-D40WMg8, reason: not valid java name */
    private static final List<UInt> m1067runningReduceIndexedD40WMg8(int[] r10, Function3<? super Integer, ? super UInt, ? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L5;
        int r12 = UIntArray.m187getpVg5ArA(r10, 0);
        ArrayList r13 = new ArrayList(UIntArray.m188getSizeimpl(r10));
        r13.add(UInt.m121boximpl(r12));
        int r14 = UIntArray.m188getSizeimpl(r10);
        int r15 = 1;
    L7:
        if (r15 >= r14) goto L9;
        r12 = r11.invoke(Integer.valueOf(r15), UInt.m121boximpl(r12), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r15))).m179unboximpl();
        r13.add(UInt.m121boximpl(r12));
        r15 = r15 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningReduceIndexed-EOyYB1Y, reason: not valid java name */
    private static final List<UByte> m1068runningReduceIndexedEOyYB1Y(byte[] r10, Function3<? super Integer, ? super UByte, ? super UByte, UByte> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L5;
        byte r12 = UByteArray.m108getw2LRezQ(r10, 0);
        ArrayList r13 = new ArrayList(UByteArray.m109getSizeimpl(r10));
        r13.add(UByte.m44boximpl(r12));
        int r14 = UByteArray.m109getSizeimpl(r10);
        int r15 = 1;
    L7:
        if (r15 >= r14) goto L9;
        r12 = r11.invoke(Integer.valueOf(r15), UByte.m44boximpl(r12), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r15))).m100unboximpl();
        r13.add(UByte.m44boximpl(r12));
        r15 = r15 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningReduceIndexed-aLgx1Fo, reason: not valid java name */
    private static final List<UShort> m1069runningReduceIndexedaLgx1Fo(short[] r10, Function3<? super Integer, ? super UShort, ? super UShort, UShort> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L5;
        short r12 = UShortArray.m371getMh2AYeg(r10, 0);
        ArrayList r13 = new ArrayList(UShortArray.m372getSizeimpl(r10));
        r13.add(UShort.m307boximpl(r12));
        int r14 = UShortArray.m372getSizeimpl(r10);
        int r15 = 1;
    L7:
        if (r15 >= r14) goto L9;
        r12 = r11.invoke(Integer.valueOf(r15), UShort.m307boximpl(r12), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r15))).m363unboximpl();
        r13.add(UShort.m307boximpl(r12));
        r15 = r15 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: runningReduceIndexed-z1zDJgo, reason: not valid java name */
    private static final List<ULong> m1070runningReduceIndexedz1zDJgo(long[] r10, Function3<? super Integer, ? super ULong, ? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(r11, "operation");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L5;
        long r12 = ULongArray.m266getsVKNKU(r10, 0);
        ArrayList r13 = new ArrayList(ULongArray.m267getSizeimpl(r10));
        r13.add(ULong.m200boximpl(r12));
        int r14 = ULongArray.m267getSizeimpl(r10);
        int r15 = 1;
    L7:
        if (r15 >= r14) goto L9;
        r12 = r11.invoke(Integer.valueOf(r15), ULong.m200boximpl(r12), ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r15))).m258unboximpl();
        r13.add(ULong.m200boximpl(r12));
        r15 = r15 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: scan-A8wKCXQ, reason: not valid java name */
    private static final <R> List<R> m1071scanA8wKCXQ(long[] r10, R r11, Function2<? super R, ? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$scan");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L11;
        ArrayList r13 = new ArrayList(ULongArray.m267getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = ULongArray.m267getSizeimpl(r10);
    L6:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(r16, ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L6
    L9:
        return r13;
    L11:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: scan-yXmHNn8, reason: not valid java name */
    private static final <R> List<R> m1072scanyXmHNn8(byte[] r10, R r11, Function2<? super R, ? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$scan");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L11;
        ArrayList r13 = new ArrayList(UByteArray.m109getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UByteArray.m109getSizeimpl(r10);
    L6:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(r16, UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L6
    L9:
        return r13;
    L11:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: scan-zi1B2BA, reason: not valid java name */
    private static final <R> List<R> m1073scanzi1B2BA(int[] r10, R r11, Function2<? super R, ? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$scan");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L11;
        ArrayList r13 = new ArrayList(UIntArray.m188getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UIntArray.m188getSizeimpl(r10);
    L6:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(r16, UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L6
    L9:
        return r13;
    L11:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: scan-zww5nb8, reason: not valid java name */
    private static final <R> List<R> m1074scanzww5nb8(short[] r10, R r11, Function2<? super R, ? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$scan");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L11;
        ArrayList r13 = new ArrayList(UShortArray.m372getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UShortArray.m372getSizeimpl(r10);
    L6:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(r16, UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L6
    L9:
        return r13;
    L11:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: scanIndexed-3iWJZGE, reason: not valid java name */
    private static final <R> List<R> m1075scanIndexed3iWJZGE(byte[] r10, R r11, Function3<? super Integer, ? super R, ? super UByte, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UByteArray.m111isEmptyimpl(r10) == true) goto L11;
        ArrayList r13 = new ArrayList(UByteArray.m109getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UByteArray.m109getSizeimpl(r10);
    L6:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r14), r16, UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L6
    L9:
        return r13;
    L11:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: scanIndexed-bzxtMww, reason: not valid java name */
    private static final <R> List<R> m1076scanIndexedbzxtMww(short[] r10, R r11, Function3<? super Integer, ? super R, ? super UShort, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UShortArray.m374isEmptyimpl(r10) == true) goto L11;
        ArrayList r13 = new ArrayList(UShortArray.m372getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UShortArray.m372getSizeimpl(r10);
    L6:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r14), r16, UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L6
    L9:
        return r13;
    L11:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: scanIndexed-mwnnOCs, reason: not valid java name */
    private static final <R> List<R> m1077scanIndexedmwnnOCs(long[] r10, R r11, Function3<? super Integer, ? super R, ? super ULong, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (ULongArray.m269isEmptyimpl(r10) == true) goto L11;
        ArrayList r13 = new ArrayList(ULongArray.m267getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = ULongArray.m267getSizeimpl(r10);
    L6:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r14), r16, ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L6
    L9:
        return r13;
    L11:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: scanIndexed-yVwIW0Q, reason: not valid java name */
    private static final <R> List<R> m1078scanIndexedyVwIW0Q(int[] r10, R r11, Function3<? super Integer, ? super R, ? super UInt, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(r12, "operation");
        if (UIntArray.m190isEmptyimpl(r10) == true) goto L11;
        ArrayList r13 = new ArrayList(UIntArray.m188getSizeimpl(r10) + 1);
        r13.add(r11);
        int r14 = 0;
        int r15 = UIntArray.m188getSizeimpl(r10);
    L6:
        if (r14 >= r15) goto L9;
        R r16 = r11;
        r11 = r12.invoke(Integer.valueOf(r14), r16, UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14)));
        r13.add(r11);
        r14 = r14 + 1;
        goto L6
    L9:
        return r13;
    L11:
        return CollectionsKt.listOf(r11);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle--ajY-9A, reason: not valid java name */
    public static final void m1079shuffleajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$shuffle");
        m1080shuffle2D5oskM(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-2D5oskM, reason: not valid java name */
    public static final void m1080shuffle2D5oskM(int[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$shuffle");
        Intrinsics.checkNotNullParameter(r11, "random");
        int r12 = ArraysKt.getLastIndex(r10);
    L3:
        if (r12 <= 0) goto L5;
        int r13 = r11.nextInt(r12 + 1);
        int r14 = UIntArray.m187getpVg5ArA(r10, r12);
        UIntArray.m192setVXSXFK8(r10, r12, UIntArray.m187getpVg5ArA(r10, r13));
        UIntArray.m192setVXSXFK8(r10, r13, r14);
        r12 = r12 - 1;
        goto L3
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-GBYM_sE, reason: not valid java name */
    public static final void m1081shuffleGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$shuffle");
        m1084shuffleoSF2wD8(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-JzugnMA, reason: not valid java name */
    public static final void m1082shuffleJzugnMA(long[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$shuffle");
        Intrinsics.checkNotNullParameter(r11, "random");
        int r12 = ArraysKt.getLastIndex(r10);
    L3:
        if (r12 <= 0) goto L5;
        int r13 = r11.nextInt(r12 + 1);
        long r14 = ULongArray.m266getsVKNKU(r10, r12);
        ULongArray.m271setk8EXiF4(r10, r12, ULongArray.m266getsVKNKU(r10, r13));
        ULongArray.m271setk8EXiF4(r10, r13, r14);
        r12 = r12 - 1;
        goto L3
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-QwZRm1k, reason: not valid java name */
    public static final void m1083shuffleQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$shuffle");
        m1082shuffleJzugnMA(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-oSF2wD8, reason: not valid java name */
    public static final void m1084shuffleoSF2wD8(byte[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$shuffle");
        Intrinsics.checkNotNullParameter(r11, "random");
        int r12 = ArraysKt.getLastIndex(r10);
    L3:
        if (r12 <= 0) goto L5;
        int r13 = r11.nextInt(r12 + 1);
        byte r14 = UByteArray.m108getw2LRezQ(r10, r12);
        UByteArray.m113setVurrAj0(r10, r12, UByteArray.m108getw2LRezQ(r10, r13));
        UByteArray.m113setVurrAj0(r10, r13, r14);
        r12 = r12 - 1;
        goto L3
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-rL5Bavg, reason: not valid java name */
    public static final void m1085shufflerL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$shuffle");
        m1086shuffles5X_as8(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: shuffle-s5X_as8, reason: not valid java name */
    public static final void m1086shuffles5X_as8(short[] r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$shuffle");
        Intrinsics.checkNotNullParameter(r11, "random");
        int r12 = ArraysKt.getLastIndex(r10);
    L3:
        if (r12 <= 0) goto L5;
        int r13 = r11.nextInt(r12 + 1);
        short r14 = UShortArray.m371getMh2AYeg(r10, r12);
        UShortArray.m376set01HTLdE(r10, r12, UShortArray.m371getMh2AYeg(r10, r13));
        UShortArray.m376set01HTLdE(r10, r13, r14);
        r12 = r12 - 1;
        goto L3
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: single--ajY-9A, reason: not valid java name */
    private static final int m1087singleajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$single");
        return UInt.m127constructorimpl(ArraysKt.single(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: single-GBYM_sE, reason: not valid java name */
    private static final byte m1088singleGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$single");
        return UByte.m50constructorimpl(ArraysKt.single(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: single-JOV_ifY, reason: not valid java name */
    private static final byte m1089singleJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$single");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
        UByte r14 = null;
        boolean r15 = false;
    L3:
        if (r13 >= r12) goto L11;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r13);
        if (r11.invoke(UByte.m44boximpl(r16)).booleanValue() == false) goto L10;
        if (r15 == true) goto L9;
        r14 = UByte.m44boximpl(r16);
        r15 = true;
        goto L10
    L9:
        throw new IllegalArgumentException("Array contains more than one matching element.");
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        if (r15 == false) goto L15;
        return r14.m100unboximpl();
    L15:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: single-MShoTSo, reason: not valid java name */
    private static final long m1090singleMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$single");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
        ULong r14 = null;
        boolean r15 = false;
    L3:
        if (r13 >= r12) goto L11;
        long r16 = ULongArray.m266getsVKNKU(r10, r13);
        if (r11.invoke(ULong.m200boximpl(r16)).booleanValue() == false) goto L10;
        if (r15 == true) goto L9;
        r14 = ULong.m200boximpl(r16);
        r15 = true;
        goto L10
    L9:
        throw new IllegalArgumentException("Array contains more than one matching element.");
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        if (r15 == false) goto L15;
        return r14.m258unboximpl();
    L15:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: single-QwZRm1k, reason: not valid java name */
    private static final long m1091singleQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$single");
        return ULong.m206constructorimpl(ArraysKt.single(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: single-jgv0xPQ, reason: not valid java name */
    private static final int m1092singlejgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$single");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
        UInt r14 = null;
        boolean r15 = false;
    L3:
        if (r13 >= r12) goto L11;
        int r16 = UIntArray.m187getpVg5ArA(r10, r13);
        if (r11.invoke(UInt.m121boximpl(r16)).booleanValue() == false) goto L10;
        if (r15 == true) goto L9;
        r14 = UInt.m121boximpl(r16);
        r15 = true;
        goto L10
    L9:
        throw new IllegalArgumentException("Array contains more than one matching element.");
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        if (r15 == false) goto L15;
        return r14.m179unboximpl();
    L15:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: single-rL5Bavg, reason: not valid java name */
    private static final short m1093singlerL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$single");
        return UShort.m313constructorimpl(ArraysKt.single(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: single-xTcfx_M, reason: not valid java name */
    private static final short m1094singlexTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$single");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
        UShort r14 = null;
        boolean r15 = false;
    L3:
        if (r13 >= r12) goto L11;
        short r16 = UShortArray.m371getMh2AYeg(r10, r13);
        if (r11.invoke(UShort.m307boximpl(r16)).booleanValue() == false) goto L10;
        if (r15 == true) goto L9;
        r14 = UShort.m307boximpl(r16);
        r15 = true;
        goto L10
    L9:
        throw new IllegalArgumentException("Array contains more than one matching element.");
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        if (r15 == false) goto L15;
        return r14.m363unboximpl();
    L15:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: singleOrNull--ajY-9A, reason: not valid java name */
    public static final UInt m1095singleOrNullajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$singleOrNull");
        if (UIntArray.m188getSizeimpl(r10) == 1) goto L7;
        return null;
    L7:
        return UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: singleOrNull-GBYM_sE, reason: not valid java name */
    public static final UByte m1096singleOrNullGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$singleOrNull");
        if (UByteArray.m109getSizeimpl(r10) == 1) goto L7;
        return null;
    L7:
        return UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: singleOrNull-JOV_ifY, reason: not valid java name */
    private static final UByte m1097singleOrNullJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
        boolean r14 = false;
        UByte r15 = null;
    L3:
        if (r13 >= r12) goto L10;
        byte r16 = UByteArray.m108getw2LRezQ(r10, r13);
        if (r11.invoke(UByte.m44boximpl(r16)).booleanValue() == false) goto L9;
        if (r14 == true) goto L7;
        r15 = UByte.m44boximpl(r16);
        r14 = true;
        goto L9
    L7:
        return null;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        if (r14 == true) goto L12;
        return null;
    L12:
        return r15;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: singleOrNull-MShoTSo, reason: not valid java name */
    private static final ULong m1098singleOrNullMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
        boolean r14 = false;
        ULong r15 = null;
    L3:
        if (r13 >= r12) goto L10;
        long r16 = ULongArray.m266getsVKNKU(r10, r13);
        if (r11.invoke(ULong.m200boximpl(r16)).booleanValue() == false) goto L9;
        if (r14 == true) goto L7;
        r15 = ULong.m200boximpl(r16);
        r14 = true;
        goto L9
    L7:
        return null;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        if (r14 == true) goto L12;
        return null;
    L12:
        return r15;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: singleOrNull-QwZRm1k, reason: not valid java name */
    public static final ULong m1099singleOrNullQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$singleOrNull");
        if (ULongArray.m267getSizeimpl(r10) == 1) goto L7;
        return null;
    L7:
        return ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: singleOrNull-jgv0xPQ, reason: not valid java name */
    private static final UInt m1100singleOrNulljgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
        boolean r14 = false;
        UInt r15 = null;
    L3:
        if (r13 >= r12) goto L10;
        int r16 = UIntArray.m187getpVg5ArA(r10, r13);
        if (r11.invoke(UInt.m121boximpl(r16)).booleanValue() == false) goto L9;
        if (r14 == true) goto L7;
        r15 = UInt.m121boximpl(r16);
        r14 = true;
        goto L9
    L7:
        return null;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        if (r14 == true) goto L12;
        return null;
    L12:
        return r15;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: singleOrNull-rL5Bavg, reason: not valid java name */
    public static final UShort m1101singleOrNullrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$singleOrNull");
        if (UShortArray.m372getSizeimpl(r10) == 1) goto L7;
        return null;
    L7:
        return UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: singleOrNull-xTcfx_M, reason: not valid java name */
    private static final UShort m1102singleOrNullxTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
        boolean r14 = false;
        UShort r15 = null;
    L3:
        if (r13 >= r12) goto L10;
        short r16 = UShortArray.m371getMh2AYeg(r10, r13);
        if (r11.invoke(UShort.m307boximpl(r16)).booleanValue() == false) goto L9;
        if (r14 == true) goto L7;
        r15 = UShort.m307boximpl(r16);
        r14 = true;
        goto L9
    L7:
        return null;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        if (r14 == true) goto L12;
        return null;
    L12:
        return r15;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: slice-F7u83W8, reason: not valid java name */
    public static final List<ULong> m1103sliceF7u83W8(long[] r10, Iterable<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$slice");
        Intrinsics.checkNotNullParameter(r11, "indices");
        int r12 = CollectionsKt.collectionSizeOrDefault(r11, 10);
        if (r12 == 0) goto L5;
        ArrayList r13 = new ArrayList(r12);
        Iterator<Integer> r14 = r11.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.add(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14.next().intValue())));
        goto L8
    L10:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: slice-HwE9HBo, reason: not valid java name */
    public static final List<UInt> m1104sliceHwE9HBo(int[] r10, Iterable<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$slice");
        Intrinsics.checkNotNullParameter(r11, "indices");
        int r12 = CollectionsKt.collectionSizeOrDefault(r11, 10);
        if (r12 == 0) goto L5;
        ArrayList r13 = new ArrayList(r12);
        Iterator<Integer> r14 = r11.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.add(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14.next().intValue())));
        goto L8
    L10:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: slice-JGPC0-M, reason: not valid java name */
    public static final List<UShort> m1105sliceJGPC0M(short[] r10, Iterable<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$slice");
        Intrinsics.checkNotNullParameter(r11, "indices");
        int r12 = CollectionsKt.collectionSizeOrDefault(r11, 10);
        if (r12 == 0) goto L5;
        ArrayList r13 = new ArrayList(r12);
        Iterator<Integer> r14 = r11.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.add(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14.next().intValue())));
        goto L8
    L10:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: slice-JQknh5Q, reason: not valid java name */
    public static final List<UByte> m1106sliceJQknh5Q(byte[] r10, Iterable<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$slice");
        Intrinsics.checkNotNullParameter(r11, "indices");
        int r12 = CollectionsKt.collectionSizeOrDefault(r11, 10);
        if (r12 == 0) goto L5;
        ArrayList r13 = new ArrayList(r12);
        Iterator<Integer> r14 = r11.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.add(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14.next().intValue())));
        goto L8
    L10:
        return r13;
    L5:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: slice-Q6IL4kU, reason: not valid java name */
    public static final List<UShort> m1107sliceQ6IL4kU(short[] r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$slice");
        Intrinsics.checkNotNullParameter(r11, "indices");
        if (r11.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return UArraysKt___UArraysJvmKt.m510asListrL5Bavg(UShortArray.m366constructorimpl(ArraysKt.copyOfRange(r10, r11.getStart().intValue(), r11.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: slice-ZRhS8yI, reason: not valid java name */
    public static final List<ULong> m1108sliceZRhS8yI(long[] r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$slice");
        Intrinsics.checkNotNullParameter(r11, "indices");
        if (r11.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return UArraysKt___UArraysJvmKt.m509asListQwZRm1k(ULongArray.m261constructorimpl(ArraysKt.copyOfRange(r10, r11.getStart().intValue(), r11.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: slice-c0bezYM, reason: not valid java name */
    public static final List<UByte> m1109slicec0bezYM(byte[] r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$slice");
        Intrinsics.checkNotNullParameter(r11, "indices");
        if (r11.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return UArraysKt___UArraysJvmKt.m508asListGBYM_sE(UByteArray.m103constructorimpl(ArraysKt.copyOfRange(r10, r11.getStart().intValue(), r11.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: slice-tAntMlw, reason: not valid java name */
    public static final List<UInt> m1110slicetAntMlw(int[] r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$slice");
        Intrinsics.checkNotNullParameter(r11, "indices");
        if (r11.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return UArraysKt___UArraysJvmKt.m507asListajY9A(UIntArray.m182constructorimpl(ArraysKt.copyOfRange(r10, r11.getStart().intValue(), r11.getEndInclusive().intValue() + 1)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sliceArray-CFIt9YE, reason: not valid java name */
    public static final int[] m1111sliceArrayCFIt9YE(int[] r10, Collection<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(r11, "indices");
        return UIntArray.m182constructorimpl(ArraysKt.sliceArray(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sliceArray-Q6IL4kU, reason: not valid java name */
    public static final short[] m1112sliceArrayQ6IL4kU(short[] r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(r11, "indices");
        return UShortArray.m366constructorimpl(ArraysKt.sliceArray(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sliceArray-ZRhS8yI, reason: not valid java name */
    public static final long[] m1113sliceArrayZRhS8yI(long[] r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(r11, "indices");
        return ULongArray.m261constructorimpl(ArraysKt.sliceArray(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sliceArray-c0bezYM, reason: not valid java name */
    public static final byte[] m1114sliceArrayc0bezYM(byte[] r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(r11, "indices");
        return UByteArray.m103constructorimpl(ArraysKt.sliceArray(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sliceArray-kzHmqpY, reason: not valid java name */
    public static final long[] m1115sliceArraykzHmqpY(long[] r10, Collection<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(r11, "indices");
        return ULongArray.m261constructorimpl(ArraysKt.sliceArray(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sliceArray-ojwP5H8, reason: not valid java name */
    public static final short[] m1116sliceArrayojwP5H8(short[] r10, Collection<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(r11, "indices");
        return UShortArray.m366constructorimpl(ArraysKt.sliceArray(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sliceArray-tAntMlw, reason: not valid java name */
    public static final int[] m1117sliceArraytAntMlw(int[] r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(r11, "indices");
        return UIntArray.m182constructorimpl(ArraysKt.sliceArray(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sliceArray-xo_DsdI, reason: not valid java name */
    public static final byte[] m1118sliceArrayxo_DsdI(byte[] r10, Collection<Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(r11, "indices");
        return UByteArray.m103constructorimpl(ArraysKt.sliceArray(r10, r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort--ajY-9A, reason: not valid java name */
    public static final void m1119sortajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sort");
        if (UIntArray.m188getSizeimpl(r10) <= 1) goto L6;
        UArraySortingKt.m498sortArrayoBK06Vg(r10, 0, UIntArray.m188getSizeimpl(r10));
        return;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort--nroSd4, reason: not valid java name */
    public static final void m1120sortnroSd4(long[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r11, r12, ULongArray.m267getSizeimpl(r10));
        UArraySortingKt.m495sortArraynroSd4(r10, r11, r12);
    }

    /* JADX INFO: renamed from: sort--nroSd4$default, reason: not valid java name */
    public static /* synthetic */ void m1121sortnroSd4$default(long[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = ULongArray.m267getSizeimpl(r10);
    L8:
        m1120sortnroSd4(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-4UcCI2c, reason: not valid java name */
    public static final void m1122sort4UcCI2c(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r11, r12, UByteArray.m109getSizeimpl(r10));
        UArraySortingKt.m496sortArray4UcCI2c(r10, r11, r12);
    }

    /* JADX INFO: renamed from: sort-4UcCI2c$default, reason: not valid java name */
    public static /* synthetic */ void m1123sort4UcCI2c$default(byte[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = UByteArray.m109getSizeimpl(r10);
    L8:
        m1122sort4UcCI2c(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-Aa5vz7o, reason: not valid java name */
    public static final void m1124sortAa5vz7o(short[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r11, r12, UShortArray.m372getSizeimpl(r10));
        UArraySortingKt.m497sortArrayAa5vz7o(r10, r11, r12);
    }

    /* JADX INFO: renamed from: sort-Aa5vz7o$default, reason: not valid java name */
    public static /* synthetic */ void m1125sortAa5vz7o$default(short[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = UShortArray.m372getSizeimpl(r10);
    L8:
        m1124sortAa5vz7o(r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-GBYM_sE, reason: not valid java name */
    public static final void m1126sortGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sort");
        if (UByteArray.m109getSizeimpl(r10) <= 1) goto L6;
        UArraySortingKt.m496sortArray4UcCI2c(r10, 0, UByteArray.m109getSizeimpl(r10));
        return;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-QwZRm1k, reason: not valid java name */
    public static final void m1127sortQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sort");
        if (ULongArray.m267getSizeimpl(r10) <= 1) goto L6;
        UArraySortingKt.m495sortArraynroSd4(r10, 0, ULongArray.m267getSizeimpl(r10));
        return;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-oBK06Vg, reason: not valid java name */
    public static final void m1128sortoBK06Vg(int[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$sort");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r11, r12, UIntArray.m188getSizeimpl(r10));
        UArraySortingKt.m498sortArrayoBK06Vg(r10, r11, r12);
    }

    /* JADX INFO: renamed from: sort-oBK06Vg$default, reason: not valid java name */
    public static /* synthetic */ void m1129sortoBK06Vg$default(int[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = UIntArray.m188getSizeimpl(r10);
    L8:
        m1128sortoBK06Vg(r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sort-rL5Bavg, reason: not valid java name */
    public static final void m1130sortrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sort");
        if (UShortArray.m372getSizeimpl(r10) <= 1) goto L6;
        UArraySortingKt.m497sortArrayAa5vz7o(r10, 0, UShortArray.m372getSizeimpl(r10));
        return;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending--ajY-9A, reason: not valid java name */
    public static final void m1131sortDescendingajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortDescending");
        if (UIntArray.m188getSizeimpl(r10) <= 1) goto L6;
        m1119sortajY9A(r10);
        ArraysKt.reverse(r10);
        return;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending--nroSd4, reason: not valid java name */
    public static final void m1132sortDescendingnroSd4(long[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortDescending");
        m1120sortnroSd4(r10, r11, r12);
        ArraysKt.reverse(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-4UcCI2c, reason: not valid java name */
    public static final void m1133sortDescending4UcCI2c(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortDescending");
        m1122sort4UcCI2c(r10, r11, r12);
        ArraysKt.reverse(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-Aa5vz7o, reason: not valid java name */
    public static final void m1134sortDescendingAa5vz7o(short[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortDescending");
        m1124sortAa5vz7o(r10, r11, r12);
        ArraysKt.reverse(r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-GBYM_sE, reason: not valid java name */
    public static final void m1135sortDescendingGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortDescending");
        if (UByteArray.m109getSizeimpl(r10) <= 1) goto L6;
        m1126sortGBYM_sE(r10);
        ArraysKt.reverse(r10);
        return;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-QwZRm1k, reason: not valid java name */
    public static final void m1136sortDescendingQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortDescending");
        if (ULongArray.m267getSizeimpl(r10) <= 1) goto L6;
        m1127sortQwZRm1k(r10);
        ArraysKt.reverse(r10);
        return;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-oBK06Vg, reason: not valid java name */
    public static final void m1137sortDescendingoBK06Vg(int[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortDescending");
        m1128sortoBK06Vg(r10, r11, r12);
        ArraysKt.reverse(r10, r11, r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortDescending-rL5Bavg, reason: not valid java name */
    public static final void m1138sortDescendingrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortDescending");
        if (UShortArray.m372getSizeimpl(r10) <= 1) goto L6;
        m1130sortrL5Bavg(r10);
        ArraysKt.reverse(r10);
        return;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sorted--ajY-9A, reason: not valid java name */
    public static final List<UInt> m1139sortedajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sorted");
        int[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        int[] r12 = UIntArray.m182constructorimpl(r11);
        m1119sortajY9A(r12);
        return UArraysKt___UArraysJvmKt.m507asListajY9A(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sorted-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m1140sortedGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sorted");
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        byte[] r12 = UByteArray.m103constructorimpl(r11);
        m1126sortGBYM_sE(r12);
        return UArraysKt___UArraysJvmKt.m508asListGBYM_sE(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sorted-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m1141sortedQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sorted");
        long[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        long[] r12 = ULongArray.m261constructorimpl(r11);
        m1127sortQwZRm1k(r12);
        return UArraysKt___UArraysJvmKt.m509asListQwZRm1k(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sorted-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m1142sortedrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sorted");
        short[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        short[] r12 = UShortArray.m366constructorimpl(r11);
        m1130sortrL5Bavg(r12);
        return UArraysKt___UArraysJvmKt.m510asListrL5Bavg(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedArray--ajY-9A, reason: not valid java name */
    public static final int[] m1143sortedArrayajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedArray");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L5;
        return r10;
    L5:
        int[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        int[] r12 = UIntArray.m182constructorimpl(r11);
        m1119sortajY9A(r12);
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedArray-GBYM_sE, reason: not valid java name */
    public static final byte[] m1144sortedArrayGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedArray");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L5;
        return r10;
    L5:
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        byte[] r12 = UByteArray.m103constructorimpl(r11);
        m1126sortGBYM_sE(r12);
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedArray-QwZRm1k, reason: not valid java name */
    public static final long[] m1145sortedArrayQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedArray");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L5;
        return r10;
    L5:
        long[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        long[] r12 = ULongArray.m261constructorimpl(r11);
        m1127sortQwZRm1k(r12);
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedArray-rL5Bavg, reason: not valid java name */
    public static final short[] m1146sortedArrayrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedArray");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L5;
        return r10;
    L5:
        short[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        short[] r12 = UShortArray.m366constructorimpl(r11);
        m1130sortrL5Bavg(r12);
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedArrayDescending--ajY-9A, reason: not valid java name */
    public static final int[] m1147sortedArrayDescendingajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedArrayDescending");
        if (UIntArray.m190isEmptyimpl(r10) == false) goto L5;
        return r10;
    L5:
        int[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        int[] r12 = UIntArray.m182constructorimpl(r11);
        m1131sortDescendingajY9A(r12);
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedArrayDescending-GBYM_sE, reason: not valid java name */
    public static final byte[] m1148sortedArrayDescendingGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedArrayDescending");
        if (UByteArray.m111isEmptyimpl(r10) == false) goto L5;
        return r10;
    L5:
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        byte[] r12 = UByteArray.m103constructorimpl(r11);
        m1135sortDescendingGBYM_sE(r12);
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedArrayDescending-QwZRm1k, reason: not valid java name */
    public static final long[] m1149sortedArrayDescendingQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedArrayDescending");
        if (ULongArray.m269isEmptyimpl(r10) == false) goto L5;
        return r10;
    L5:
        long[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        long[] r12 = ULongArray.m261constructorimpl(r11);
        m1136sortDescendingQwZRm1k(r12);
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedArrayDescending-rL5Bavg, reason: not valid java name */
    public static final short[] m1150sortedArrayDescendingrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedArrayDescending");
        if (UShortArray.m374isEmptyimpl(r10) == false) goto L5;
        return r10;
    L5:
        short[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        short[] r12 = UShortArray.m366constructorimpl(r11);
        m1138sortDescendingrL5Bavg(r12);
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedDescending--ajY-9A, reason: not valid java name */
    public static final List<UInt> m1151sortedDescendingajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedDescending");
        int[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        int[] r12 = UIntArray.m182constructorimpl(r11);
        m1119sortajY9A(r12);
        return m1047reversedajY9A(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedDescending-GBYM_sE, reason: not valid java name */
    public static final List<UByte> m1152sortedDescendingGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedDescending");
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        byte[] r12 = UByteArray.m103constructorimpl(r11);
        m1126sortGBYM_sE(r12);
        return m1048reversedGBYM_sE(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedDescending-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m1153sortedDescendingQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedDescending");
        long[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        long[] r12 = ULongArray.m261constructorimpl(r11);
        m1127sortQwZRm1k(r12);
        return m1049reversedQwZRm1k(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortedDescending-rL5Bavg, reason: not valid java name */
    public static final List<UShort> m1154sortedDescendingrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sortedDescending");
        short[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        short[] r12 = UShortArray.m366constructorimpl(r11);
        m1130sortrL5Bavg(r12);
        return m1050reversedrL5Bavg(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: sum--ajY-9A, reason: not valid java name */
    private static final int m1155sumajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sum");
        return UInt.m127constructorimpl(ArraysKt.sum(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: sum-GBYM_sE, reason: not valid java name */
    private static final int m1156sumGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sum");
        int r11 = 0;
        int r12 = UInt.m127constructorimpl(0);
        int r13 = UByteArray.m109getSizeimpl(r10);
    L3:
        if (r11 >= r13) goto L5;
        r12 = UInt.m127constructorimpl(r12 + UInt.m127constructorimpl(UByteArray.m108getw2LRezQ(r10, r11) & 255));
        r11 = r11 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: sum-QwZRm1k, reason: not valid java name */
    private static final long m1157sumQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sum");
        return ULong.m206constructorimpl(ArraysKt.sum(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: sum-rL5Bavg, reason: not valid java name */
    private static final int m1158sumrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$sum");
        int r11 = 0;
        int r12 = UInt.m127constructorimpl(0);
        int r13 = UShortArray.m372getSizeimpl(r10);
    L3:
        if (r11 >= r13) goto L5;
        r12 = UInt.m127constructorimpl(r12 + UInt.m127constructorimpl(UShortArray.m371getMh2AYeg(r10, r11) & UShort.MAX_VALUE));
        r11 = r11 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumBy-JOV_ifY, reason: not valid java name */
    private static final int m1159sumByJOV_ifY(byte[] r10, Function1<? super UByte, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r14 = UInt.m127constructorimpl(r14 + r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13))).m179unboximpl());
        r13 = r13 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumBy-MShoTSo, reason: not valid java name */
    private static final int m1160sumByMShoTSo(long[] r10, Function1<? super ULong, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r14 = UInt.m127constructorimpl(r14 + r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13))).m179unboximpl());
        r13 = r13 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumBy-jgv0xPQ, reason: not valid java name */
    private static final int m1161sumByjgv0xPQ(int[] r10, Function1<? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r14 = UInt.m127constructorimpl(r14 + r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13))).m179unboximpl());
        r13 = r13 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumBy-xTcfx_M, reason: not valid java name */
    private static final int m1162sumByxTcfx_M(short[] r10, Function1<? super UShort, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumBy");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r14 = UInt.m127constructorimpl(r14 + r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13))).m179unboximpl());
        r13 = r13 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumByDouble-JOV_ifY, reason: not valid java name */
    private static final double m1163sumByDoubleJOV_ifY(byte[] r10, Function1<? super UByte, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UByteArray.m109getSizeimpl(r10);
        double r13 = 0.0d;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))).doubleValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumByDouble-MShoTSo, reason: not valid java name */
    private static final double m1164sumByDoubleMShoTSo(long[] r10, Function1<? super ULong, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = ULongArray.m267getSizeimpl(r10);
        double r13 = 0.0d;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))).doubleValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumByDouble-jgv0xPQ, reason: not valid java name */
    private static final double m1165sumByDoublejgv0xPQ(int[] r10, Function1<? super UInt, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UIntArray.m188getSizeimpl(r10);
        double r13 = 0.0d;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))).doubleValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    /* JADX INFO: renamed from: sumByDouble-xTcfx_M, reason: not valid java name */
    private static final double m1166sumByDoublexTcfx_M(short[] r10, Function1<? super UShort, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UShortArray.m372getSizeimpl(r10);
        double r13 = 0.0d;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))).doubleValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double sumOfDouble(byte[] r10, Function1<? super UByte, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UByteArray.m109getSizeimpl(r10);
        double r13 = 0.0d;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))).doubleValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double sumOfDouble(int[] r10, Function1<? super UInt, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UIntArray.m188getSizeimpl(r10);
        double r13 = 0.0d;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))).doubleValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double sumOfDouble(long[] r10, Function1<? super ULong, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = ULongArray.m267getSizeimpl(r10);
        double r13 = 0.0d;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))).doubleValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final double sumOfDouble(short[] r10, Function1<? super UShort, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UShortArray.m372getSizeimpl(r10);
        double r13 = 0.0d;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))).doubleValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfInt")
    @OverloadResolutionByLambdaReturnType
    private static final int sumOfInt(byte[] r10, Function1<? super UByte, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UByteArray.m109getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r14 = r14 + r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13))).intValue();
        r13 = r13 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfInt")
    @OverloadResolutionByLambdaReturnType
    private static final int sumOfInt(int[] r10, Function1<? super UInt, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UIntArray.m188getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r14 = r14 + r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13))).intValue();
        r13 = r13 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfInt")
    @OverloadResolutionByLambdaReturnType
    private static final int sumOfInt(long[] r10, Function1<? super ULong, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = ULongArray.m267getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r14 = r14 + r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13))).intValue();
        r13 = r13 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfInt")
    @OverloadResolutionByLambdaReturnType
    private static final int sumOfInt(short[] r10, Function1<? super UShort, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UShortArray.m372getSizeimpl(r10);
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r14 = r14 + r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13))).intValue();
        r13 = r13 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long sumOfLong(byte[] r10, Function1<? super UByte, Long> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UByteArray.m109getSizeimpl(r10);
        long r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))).longValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long sumOfLong(int[] r10, Function1<? super UInt, Long> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UIntArray.m188getSizeimpl(r10);
        long r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))).longValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long sumOfLong(long[] r10, Function1<? super ULong, Long> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = ULongArray.m267getSizeimpl(r10);
        long r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))).longValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final long sumOfLong(short[] r10, Function1<? super UShort, Long> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UShortArray.m372getSizeimpl(r10);
        long r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r13 = r13 + r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))).longValue();
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(UByte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = UInt.m127constructorimpl(r13 + UInt.m127constructorimpl(r10[r12].m100unboximpl() & 255));
        r12 = r12 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int sumOfUInt(byte[] r10, Function1<? super UByte, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = 0;
        int r13 = UInt.m127constructorimpl(0);
        int r14 = UByteArray.m109getSizeimpl(r10);
    L3:
        if (r12 >= r14) goto L5;
        r13 = UInt.m127constructorimpl(r13 + r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r12))).m179unboximpl());
        r12 = r12 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int sumOfUInt(int[] r10, Function1<? super UInt, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = 0;
        int r13 = UInt.m127constructorimpl(0);
        int r14 = UIntArray.m188getSizeimpl(r10);
    L3:
        if (r12 >= r14) goto L5;
        r13 = UInt.m127constructorimpl(r13 + r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r12))).m179unboximpl());
        r12 = r12 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int sumOfUInt(long[] r10, Function1<? super ULong, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = 0;
        int r13 = UInt.m127constructorimpl(0);
        int r14 = ULongArray.m267getSizeimpl(r10);
    L3:
        if (r12 >= r14) goto L5;
        r13 = UInt.m127constructorimpl(r13 + r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r12))).m179unboximpl());
        r12 = r12 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(UInt[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = UInt.m127constructorimpl(r13 + r10[r12].m179unboximpl());
        r12 = r12 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int sumOfUInt(short[] r10, Function1<? super UShort, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = 0;
        int r13 = UInt.m127constructorimpl(0);
        int r14 = UShortArray.m372getSizeimpl(r10);
    L3:
        if (r12 >= r14) goto L5;
        r13 = UInt.m127constructorimpl(r13 + r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r12))).m179unboximpl());
        r12 = r12 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final long sumOfULong(byte[] r10, Function1<? super UByte, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        long r12 = ULong.m206constructorimpl(0);
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = ULong.m206constructorimpl(r12 + r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r14))).m258unboximpl());
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final long sumOfULong(int[] r10, Function1<? super UInt, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        long r12 = ULong.m206constructorimpl(0);
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = ULong.m206constructorimpl(r12 + r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r14))).m258unboximpl());
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final long sumOfULong(long[] r10, Function1<? super ULong, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        long r12 = ULong.m206constructorimpl(0);
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = ULong.m206constructorimpl(r12 + r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r14))).m258unboximpl());
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(ULong[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length;
        long r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12 = ULong.m206constructorimpl(r12 + r10[r13].m258unboximpl());
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final long sumOfULong(short[] r10, Function1<? super UShort, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$sumOf");
        Intrinsics.checkNotNullParameter(r11, "selector");
        long r12 = ULong.m206constructorimpl(0);
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12 = ULong.m206constructorimpl(r12 + r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r14))).m258unboximpl());
        r14 = r14 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(UShort[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = UInt.m127constructorimpl(r13 + UInt.m127constructorimpl(r10[r12].m363unboximpl() & UShort.MAX_VALUE));
        r12 = r12 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: take-PpDY95g, reason: not valid java name */
    public static final List<UByte> m1167takePpDY95g(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$take");
        int r12 = 0;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L25;
        if (r11 != 0) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (r11 >= UByteArray.m109getSizeimpl(r10)) goto L13;
        if (r11 == 1) goto L16;
        ArrayList r14 = new ArrayList(r11);
        int r15 = UByteArray.m109getSizeimpl(r10);
        int r16 = 0;
    L18:
        if (r12 >= r15) goto L23;
        r14.add(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r12)));
        r16 = r16 + 1;
        if (r16 == r11) goto L23;
        r12 = r12 + 1;
    L23:
        return r14;
    L16:
        return CollectionsKt.listOf(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, 0)));
    L13:
        return CollectionsKt.toList(UByteArray.m101boximpl(r10));
    L25:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r13 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: take-nggk6HY, reason: not valid java name */
    public static final List<UShort> m1168takenggk6HY(short[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$take");
        int r12 = 0;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L25;
        if (r11 != 0) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (r11 >= UShortArray.m372getSizeimpl(r10)) goto L13;
        if (r11 == 1) goto L16;
        ArrayList r14 = new ArrayList(r11);
        int r15 = UShortArray.m372getSizeimpl(r10);
        int r16 = 0;
    L18:
        if (r12 >= r15) goto L23;
        r14.add(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r12)));
        r16 = r16 + 1;
        if (r16 == r11) goto L23;
        r12 = r12 + 1;
    L23:
        return r14;
    L16:
        return CollectionsKt.listOf(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, 0)));
    L13:
        return CollectionsKt.toList(UShortArray.m364boximpl(r10));
    L25:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r13 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: take-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m1169takeqFRl0hI(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$take");
        int r12 = 0;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L25;
        if (r11 != 0) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (r11 >= UIntArray.m188getSizeimpl(r10)) goto L13;
        if (r11 == 1) goto L16;
        ArrayList r14 = new ArrayList(r11);
        int r15 = UIntArray.m188getSizeimpl(r10);
        int r16 = 0;
    L18:
        if (r12 >= r15) goto L23;
        r14.add(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r12)));
        r16 = r16 + 1;
        if (r16 == r11) goto L23;
        r12 = r12 + 1;
    L23:
        return r14;
    L16:
        return CollectionsKt.listOf(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, 0)));
    L13:
        return CollectionsKt.toList(UIntArray.m180boximpl(r10));
    L25:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r13 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: take-r7IrZao, reason: not valid java name */
    public static final List<ULong> m1170taker7IrZao(long[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$take");
        int r12 = 0;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L25;
        if (r11 != 0) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (r11 >= ULongArray.m267getSizeimpl(r10)) goto L13;
        if (r11 == 1) goto L16;
        ArrayList r14 = new ArrayList(r11);
        int r15 = ULongArray.m267getSizeimpl(r10);
        int r16 = 0;
    L18:
        if (r12 >= r15) goto L23;
        r14.add(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r12)));
        r16 = r16 + 1;
        if (r16 == r11) goto L23;
        r12 = r12 + 1;
    L23:
        return r14;
    L16:
        return CollectionsKt.listOf(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, 0)));
    L13:
        return CollectionsKt.toList(ULongArray.m259boximpl(r10));
    L25:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r13 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: takeLast-PpDY95g, reason: not valid java name */
    public static final List<UByte> m1171takeLastPpDY95g(byte[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeLast");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L22;
        if (r11 == 0) goto L9;
        int r13 = UByteArray.m109getSizeimpl(r10);
        if (r11 >= r13) goto L13;
        if (r11 == 1) goto L16;
        ArrayList r14 = new ArrayList(r11);
        int r15 = r13 - r11;
    L18:
        if (r15 >= r13) goto L20;
        r14.add(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r15)));
        r15 = r15 + 1;
        goto L18
    L20:
        return r14;
    L16:
        return CollectionsKt.listOf(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13 - 1)));
    L13:
        return CollectionsKt.toList(UByteArray.m101boximpl(r10));
    L9:
        return CollectionsKt.emptyList();
    L22:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: takeLast-nggk6HY, reason: not valid java name */
    public static final List<UShort> m1172takeLastnggk6HY(short[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeLast");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L22;
        if (r11 == 0) goto L9;
        int r13 = UShortArray.m372getSizeimpl(r10);
        if (r11 >= r13) goto L13;
        if (r11 == 1) goto L16;
        ArrayList r14 = new ArrayList(r11);
        int r15 = r13 - r11;
    L18:
        if (r15 >= r13) goto L20;
        r14.add(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r15)));
        r15 = r15 + 1;
        goto L18
    L20:
        return r14;
    L16:
        return CollectionsKt.listOf(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13 - 1)));
    L13:
        return CollectionsKt.toList(UShortArray.m364boximpl(r10));
    L9:
        return CollectionsKt.emptyList();
    L22:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: takeLast-qFRl0hI, reason: not valid java name */
    public static final List<UInt> m1173takeLastqFRl0hI(int[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeLast");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L22;
        if (r11 == 0) goto L9;
        int r13 = UIntArray.m188getSizeimpl(r10);
        if (r11 >= r13) goto L13;
        if (r11 == 1) goto L16;
        ArrayList r14 = new ArrayList(r11);
        int r15 = r13 - r11;
    L18:
        if (r15 >= r13) goto L20;
        r14.add(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r15)));
        r15 = r15 + 1;
        goto L18
    L20:
        return r14;
    L16:
        return CollectionsKt.listOf(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13 - 1)));
    L13:
        return CollectionsKt.toList(UIntArray.m180boximpl(r10));
    L9:
        return CollectionsKt.emptyList();
    L22:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: takeLast-r7IrZao, reason: not valid java name */
    public static final List<ULong> m1174takeLastr7IrZao(long[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeLast");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L22;
        if (r11 == 0) goto L9;
        int r13 = ULongArray.m267getSizeimpl(r10);
        if (r11 >= r13) goto L13;
        if (r11 == 1) goto L16;
        ArrayList r14 = new ArrayList(r11);
        int r15 = r13 - r11;
    L18:
        if (r15 >= r13) goto L20;
        r14.add(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r15)));
        r15 = r15 + 1;
        goto L18
    L20:
        return r14;
    L16:
        return CollectionsKt.listOf(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13 - 1)));
    L13:
        return CollectionsKt.toList(ULongArray.m259boximpl(r10));
    L9:
        return CollectionsKt.emptyList();
    L22:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: takeLastWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m1175takeLastWhileJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ArraysKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L11;
        if (r11.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r12))).booleanValue() == false) goto L8;
        r12 = r12 - 1;
        goto L4
    L8:
        return m643dropPpDY95g(r10, r12 + 1);
    L11:
        return CollectionsKt.toList(UByteArray.m101boximpl(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: takeLastWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m1176takeLastWhileMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ArraysKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L11;
        if (r11.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r12))).booleanValue() == false) goto L8;
        r12 = r12 - 1;
        goto L4
    L8:
        return m646dropr7IrZao(r10, r12 + 1);
    L11:
        return CollectionsKt.toList(ULongArray.m259boximpl(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: takeLastWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m1177takeLastWhilejgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ArraysKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L11;
        if (r11.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r12))).booleanValue() == false) goto L8;
        r12 = r12 - 1;
        goto L4
    L8:
        return m645dropqFRl0hI(r10, r12 + 1);
    L11:
        return CollectionsKt.toList(UIntArray.m180boximpl(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: takeLastWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m1178takeLastWhilexTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        int r12 = ArraysKt.getLastIndex(r10);
    L4:
        if ((-1) >= r12) goto L11;
        if (r11.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r12))).booleanValue() == false) goto L8;
        r12 = r12 - 1;
        goto L4
    L8:
        return m644dropnggk6HY(r10, r12 + 1);
    L11:
        return CollectionsKt.toList(UShortArray.m364boximpl(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: takeWhile-JOV_ifY, reason: not valid java name */
    private static final List<UByte> m1179takeWhileJOV_ifY(byte[] r10, Function1<? super UByte, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UByteArray.m109getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        if (r11.invoke(UByte.m44boximpl(r15)).booleanValue() == false) goto L8;
        r12.add(UByte.m44boximpl(r15));
        r14 = r14 + 1;
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: takeWhile-MShoTSo, reason: not valid java name */
    private static final List<ULong> m1180takeWhileMShoTSo(long[] r10, Function1<? super ULong, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = ULongArray.m267getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        if (r11.invoke(ULong.m200boximpl(r15)).booleanValue() == false) goto L8;
        r12.add(ULong.m200boximpl(r15));
        r14 = r14 + 1;
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: takeWhile-jgv0xPQ, reason: not valid java name */
    private static final List<UInt> m1181takeWhilejgv0xPQ(int[] r10, Function1<? super UInt, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UIntArray.m188getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        if (r11.invoke(UInt.m121boximpl(r15)).booleanValue() == false) goto L8;
        r12.add(UInt.m121boximpl(r15));
        r14 = r14 + 1;
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: takeWhile-xTcfx_M, reason: not valid java name */
    private static final List<UShort> m1182takeWhilexTcfx_M(short[] r10, Function1<? super UShort, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        int r13 = UShortArray.m372getSizeimpl(r10);
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        if (r11.invoke(UShort.m307boximpl(r15)).booleanValue() == false) goto L8;
        r12.add(UShort.m307boximpl(r15));
        r14 = r14 + 1;
    L8:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: toByteArray-GBYM_sE, reason: not valid java name */
    private static final byte[] m1183toByteArrayGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toByteArray");
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: toIntArray--ajY-9A, reason: not valid java name */
    private static final int[] m1184toIntArrayajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toIntArray");
        int[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: toLongArray-QwZRm1k, reason: not valid java name */
    private static final long[] m1185toLongArrayQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toLongArray");
        long[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: toShortArray-rL5Bavg, reason: not valid java name */
    private static final short[] m1186toShortArrayrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toShortArray");
        short[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: toTypedArray--ajY-9A, reason: not valid java name */
    public static final UInt[] m1187toTypedArrayajY9A(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toTypedArray");
        int r11 = UIntArray.m188getSizeimpl(r10);
        UInt[] r12 = new UInt[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: toTypedArray-GBYM_sE, reason: not valid java name */
    public static final UByte[] m1188toTypedArrayGBYM_sE(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toTypedArray");
        int r11 = UByteArray.m109getSizeimpl(r10);
        UByte[] r12 = new UByte[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: toTypedArray-QwZRm1k, reason: not valid java name */
    public static final ULong[] m1189toTypedArrayQwZRm1k(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toTypedArray");
        int r11 = ULongArray.m267getSizeimpl(r10);
        ULong[] r12 = new ULong[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: toTypedArray-rL5Bavg, reason: not valid java name */
    public static final UShort[] m1190toTypedArrayrL5Bavg(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$toTypedArray");
        int r11 = UShortArray.m372getSizeimpl(r10);
        UShort[] r12 = new UShort[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r13));
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final byte[] toUByteArray(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        byte[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return UByteArray.m103constructorimpl(r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] toUByteArray(UByte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length;
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L6;
        r12[r13] = r10[r13].m100unboximpl();
        r13 = r13 + 1;
        goto L3
    L6:
        return UByteArray.m103constructorimpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final int[] toUIntArray(int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return UIntArray.m182constructorimpl(r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int[] toUIntArray(UInt[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length;
        int[] r12 = new int[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L6;
        r12[r13] = r10[r13].m179unboximpl();
        r13 = r13 + 1;
        goto L3
    L6:
        return UIntArray.m182constructorimpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final long[] toULongArray(long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        long[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return ULongArray.m261constructorimpl(r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long[] toULongArray(ULong[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length;
        long[] r12 = new long[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L6;
        r12[r13] = r10[r13].m258unboximpl();
        r13 = r13 + 1;
        goto L3
    L6:
        return ULongArray.m261constructorimpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short[] toUShortArray(UShort[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r11 = r10.length;
        short[] r12 = new short[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L6;
        r12[r13] = r10[r13].m363unboximpl();
        r13 = r13 + 1;
        goto L3
    L6:
        return UShortArray.m366constructorimpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] toUShortArray(short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        short[] r11 = Arrays.copyOf(r10, r10.length);
        Intrinsics.checkNotNullExpressionValue(r11, "copyOf(this, size)");
        return UShortArray.m366constructorimpl(r11);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: withIndex--ajY-9A, reason: not valid java name */
    public static final Iterable<IndexedValue<UInt>> m1191withIndexajY9A(final int[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$withIndex");
        return new IndexingIterable(new UArraysKt___UArraysKt$withIndex$1(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: withIndex-GBYM_sE, reason: not valid java name */
    public static final Iterable<IndexedValue<UByte>> m1192withIndexGBYM_sE(final byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$withIndex");
        return new IndexingIterable(new UArraysKt___UArraysKt$withIndex$3(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: withIndex-QwZRm1k, reason: not valid java name */
    public static final Iterable<IndexedValue<ULong>> m1193withIndexQwZRm1k(final long[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$withIndex");
        return new IndexingIterable(new UArraysKt___UArraysKt$withIndex$2(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: withIndex-rL5Bavg, reason: not valid java name */
    public static final Iterable<IndexedValue<UShort>> m1194withIndexrL5Bavg(final short[] r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$withIndex");
        return new IndexingIterable(new UArraysKt___UArraysKt$withIndex$4(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-7znnbtw, reason: not valid java name */
    private static final <R, V> List<V> m1195zip7znnbtw(int[] r10, Iterable<? extends R> r11, Function2<? super UInt, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UIntArray.m188getSizeimpl(r10);
        ArrayList r14 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r11, 10), r13));
        Iterator<? extends R> r15 = r11.iterator();
        int r16 = 0;
    L4:
        if (r15.hasNext() == false) goto L8;
        R r17 = r15.next();
        if (r16 >= r13) goto L8;
        int r18 = r16 + 1;
        r14.add(r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r16)), r17));
        r16 = r18;
    L8:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-8LME4QE, reason: not valid java name */
    private static final <R, V> List<V> m1196zip8LME4QE(long[] r10, R[] r11, Function2<? super ULong, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = Math.min(ULongArray.m267getSizeimpl(r10), r11.length);
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r14.add(r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r15)), r11[r15]));
        r15 = r15 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-C-E_24M, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m1197zipCE_24M(int[] r10, R[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = Math.min(UIntArray.m188getSizeimpl(r10), r11.length);
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        R r16 = r11[r14];
        r13.add(TuplesKt.to(UInt.m121boximpl(r15), r16));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-F7u83W8, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m1198zipF7u83W8(long[] r10, Iterable<? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = ULongArray.m267getSizeimpl(r10);
        ArrayList r13 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r11, 10), r12));
        Iterator<? extends R> r14 = r11.iterator();
        int r15 = 0;
    L4:
        if (r14.hasNext() == false) goto L8;
        R r16 = r14.next();
        if (r15 >= r12) goto L8;
        int r17 = r15 + 1;
        r13.add(TuplesKt.to(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r15)), r16));
        r15 = r17;
    L8:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-HwE9HBo, reason: not valid java name */
    public static final <R> List<Pair<UInt, R>> m1199zipHwE9HBo(int[] r10, Iterable<? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = UIntArray.m188getSizeimpl(r10);
        ArrayList r13 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r11, 10), r12));
        Iterator<? extends R> r14 = r11.iterator();
        int r15 = 0;
    L4:
        if (r14.hasNext() == false) goto L8;
        R r16 = r14.next();
        if (r15 >= r12) goto L8;
        int r17 = r15 + 1;
        r13.add(TuplesKt.to(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r15)), r16));
        r15 = r17;
    L8:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-JAKpvQM, reason: not valid java name */
    private static final <V> List<V> m1200zipJAKpvQM(byte[] r10, byte[] r11, Function2<? super UByte, ? super UByte, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = Math.min(UByteArray.m109getSizeimpl(r10), UByteArray.m109getSizeimpl(r11));
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r14.add(r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r15)), UByte.m44boximpl(UByteArray.m108getw2LRezQ(r11, r15))));
        r15 = r15 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-JGPC0-M, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m1201zipJGPC0M(short[] r10, Iterable<? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = UShortArray.m372getSizeimpl(r10);
        ArrayList r13 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r11, 10), r12));
        Iterator<? extends R> r14 = r11.iterator();
        int r15 = 0;
    L4:
        if (r14.hasNext() == false) goto L8;
        R r16 = r14.next();
        if (r15 >= r12) goto L8;
        int r17 = r15 + 1;
        r13.add(TuplesKt.to(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r15)), r16));
        r15 = r17;
    L8:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-JQknh5Q, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m1202zipJQknh5Q(byte[] r10, Iterable<? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = UByteArray.m109getSizeimpl(r10);
        ArrayList r13 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r11, 10), r12));
        Iterator<? extends R> r14 = r11.iterator();
        int r15 = 0;
    L4:
        if (r14.hasNext() == false) goto L8;
        R r16 = r14.next();
        if (r15 >= r12) goto L8;
        int r17 = r15 + 1;
        r13.add(TuplesKt.to(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r15)), r16));
        r15 = r17;
    L8:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-L83TJbI, reason: not valid java name */
    private static final <V> List<V> m1203zipL83TJbI(int[] r10, int[] r11, Function2<? super UInt, ? super UInt, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = Math.min(UIntArray.m188getSizeimpl(r10), UIntArray.m188getSizeimpl(r11));
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r14.add(r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r15)), UInt.m121boximpl(UIntArray.m187getpVg5ArA(r11, r15))));
        r15 = r15 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-LuipOMY, reason: not valid java name */
    private static final <R, V> List<V> m1204zipLuipOMY(byte[] r10, R[] r11, Function2<? super UByte, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = Math.min(UByteArray.m109getSizeimpl(r10), r11.length);
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r14.add(r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r15)), r11[r15]));
        r15 = r15 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-PabeH-Q, reason: not valid java name */
    private static final <V> List<V> m1205zipPabeHQ(long[] r10, long[] r11, Function2<? super ULong, ? super ULong, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = Math.min(ULongArray.m267getSizeimpl(r10), ULongArray.m267getSizeimpl(r11));
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r14.add(r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r15)), ULong.m200boximpl(ULongArray.m266getsVKNKU(r11, r15))));
        r15 = r15 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-TUPTUsU, reason: not valid java name */
    private static final <R, V> List<V> m1206zipTUPTUsU(long[] r10, Iterable<? extends R> r11, Function2<? super ULong, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = ULongArray.m267getSizeimpl(r10);
        ArrayList r14 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r11, 10), r13));
        Iterator<? extends R> r15 = r11.iterator();
        int r16 = 0;
    L4:
        if (r15.hasNext() == false) goto L8;
        R r17 = r15.next();
        if (r16 >= r13) goto L8;
        int r18 = r16 + 1;
        r14.add(r12.invoke(ULong.m200boximpl(ULongArray.m266getsVKNKU(r10, r16)), r17));
        r16 = r18;
    L8:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-UCnP4_w, reason: not valid java name */
    private static final <R, V> List<V> m1207zipUCnP4_w(byte[] r10, Iterable<? extends R> r11, Function2<? super UByte, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UByteArray.m109getSizeimpl(r10);
        ArrayList r14 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r11, 10), r13));
        Iterator<? extends R> r15 = r11.iterator();
        int r16 = 0;
    L4:
        if (r15.hasNext() == false) goto L8;
        R r17 = r15.next();
        if (r16 >= r13) goto L8;
        int r18 = r16 + 1;
        r14.add(r12.invoke(UByte.m44boximpl(UByteArray.m108getw2LRezQ(r10, r16)), r17));
        r16 = r18;
    L8:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-ZjwqOic, reason: not valid java name */
    private static final <R, V> List<V> m1208zipZjwqOic(int[] r10, R[] r11, Function2<? super UInt, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = Math.min(UIntArray.m188getSizeimpl(r10), r11.length);
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r14.add(r12.invoke(UInt.m121boximpl(UIntArray.m187getpVg5ArA(r10, r15)), r11[r15]));
        r15 = r15 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-ctEhBpI, reason: not valid java name */
    public static final List<Pair<UInt, UInt>> m1209zipctEhBpI(int[] r10, int[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = Math.min(UIntArray.m188getSizeimpl(r10), UIntArray.m188getSizeimpl(r11));
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        int r15 = UIntArray.m187getpVg5ArA(r10, r14);
        int r16 = UIntArray.m187getpVg5ArA(r11, r14);
        r13.add(TuplesKt.to(UInt.m121boximpl(r15), UInt.m121boximpl(r16)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-ePBmRWY, reason: not valid java name */
    private static final <R, V> List<V> m1210zipePBmRWY(short[] r10, R[] r11, Function2<? super UShort, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = Math.min(UShortArray.m372getSizeimpl(r10), r11.length);
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r14.add(r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r15)), r11[r15]));
        r15 = r15 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-f7H3mmw, reason: not valid java name */
    public static final <R> List<Pair<ULong, R>> m1211zipf7H3mmw(long[] r10, R[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = Math.min(ULongArray.m267getSizeimpl(r10), r11.length);
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        R r16 = r11[r14];
        r13.add(TuplesKt.to(ULong.m200boximpl(r15), r16));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-gVVukQo, reason: not valid java name */
    private static final <V> List<V> m1212zipgVVukQo(short[] r10, short[] r11, Function2<? super UShort, ? super UShort, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = Math.min(UShortArray.m372getSizeimpl(r10), UShortArray.m372getSizeimpl(r11));
        ArrayList r14 = new ArrayList(r13);
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r14.add(r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r15)), UShort.m307boximpl(UShortArray.m371getMh2AYeg(r11, r15))));
        r15 = r15 + 1;
        goto L3
    L5:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: zip-kBb4a-s, reason: not valid java name */
    private static final <R, V> List<V> m1213zipkBb4as(short[] r10, Iterable<? extends R> r11, Function2<? super UShort, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        int r13 = UShortArray.m372getSizeimpl(r10);
        ArrayList r14 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r11, 10), r13));
        Iterator<? extends R> r15 = r11.iterator();
        int r16 = 0;
    L4:
        if (r15.hasNext() == false) goto L8;
        R r17 = r15.next();
        if (r16 >= r13) goto L8;
        int r18 = r16 + 1;
        r14.add(r12.invoke(UShort.m307boximpl(UShortArray.m371getMh2AYeg(r10, r16)), r17));
        r16 = r18;
    L8:
        return r14;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-kdPth3s, reason: not valid java name */
    public static final List<Pair<UByte, UByte>> m1214zipkdPth3s(byte[] r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = Math.min(UByteArray.m109getSizeimpl(r10), UByteArray.m109getSizeimpl(r11));
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        byte r16 = UByteArray.m108getw2LRezQ(r11, r14);
        r13.add(TuplesKt.to(UByte.m44boximpl(r15), UByte.m44boximpl(r16)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-mazbYpA, reason: not valid java name */
    public static final List<Pair<UShort, UShort>> m1215zipmazbYpA(short[] r10, short[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = Math.min(UShortArray.m372getSizeimpl(r10), UShortArray.m372getSizeimpl(r11));
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        short r16 = UShortArray.m371getMh2AYeg(r11, r14);
        r13.add(TuplesKt.to(UShort.m307boximpl(r15), UShort.m307boximpl(r16)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-nl983wc, reason: not valid java name */
    public static final <R> List<Pair<UByte, R>> m1216zipnl983wc(byte[] r10, R[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = Math.min(UByteArray.m109getSizeimpl(r10), r11.length);
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        byte r15 = UByteArray.m108getw2LRezQ(r10, r14);
        R r16 = r11[r14];
        r13.add(TuplesKt.to(UByte.m44boximpl(r15), r16));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-uaTIQ5s, reason: not valid java name */
    public static final <R> List<Pair<UShort, R>> m1217zipuaTIQ5s(short[] r10, R[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = Math.min(UShortArray.m372getSizeimpl(r10), r11.length);
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        short r15 = UShortArray.m371getMh2AYeg(r10, r14);
        R r16 = r11[r14];
        r13.add(TuplesKt.to(UShort.m307boximpl(r15), r16));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: zip-us8wMrg, reason: not valid java name */
    public static final List<Pair<ULong, ULong>> m1218zipus8wMrg(long[] r10, long[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$zip");
        Intrinsics.checkNotNullParameter(r11, "other");
        int r12 = Math.min(ULongArray.m267getSizeimpl(r10), ULongArray.m267getSizeimpl(r11));
        ArrayList r13 = new ArrayList(r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        long r15 = ULongArray.m266getsVKNKU(r10, r14);
        long r16 = ULongArray.m266getsVKNKU(r11, r14);
        r13.add(TuplesKt.to(ULong.m200boximpl(r15), ULong.m200boximpl(r16)));
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }
}
