package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001NB\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J)\u0010%\u001a\u00020\u001b2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\u0082\bJ\u0016\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001dJ\u0016\u0010*\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010+\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0096\u0002¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001bH\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0096\u0002J\u0015\u00102\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0016J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J.\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u0002H60'H\u0082\b¢\u0006\u0002\u00107J\"\u00108\u001a\u00020\u001b2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u001b0'H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0015\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010<\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010,J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010J\u0016\u0010A\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J+\u0010B\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0010H\u0000¢\u0006\u0002\bEJ\u001e\u0010F\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J)\u0010J\u001a\u00020\u001e2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\u0082\bJ3\u0010K\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bLH\u0082\b¢\u0006\u0002\u00107J3\u0010M\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bLH\u0082\b¢\u0006\u0002\u00107R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068AX\u0080\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012¨\u0006O"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "toList", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Stable
@SourceDebugExtension({"SMAP\nSnapshotStateList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateList.kt\nandroidx/compose/runtime/snapshots/SnapshotStateList\n+ 2 Snapshot.kt\nandroidx/compose/runtime/snapshots/SnapshotKt\n+ 3 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,457:1\n153#1:458\n189#1,6:460\n195#1:467\n153#1:468\n196#1,9:470\n149#1:479\n205#1,6:485\n214#1,6:494\n185#1,10:500\n195#1:511\n153#1:512\n196#1,9:514\n149#1:523\n205#1,6:529\n214#1,6:538\n186#1:544\n189#1,6:545\n195#1:552\n153#1:553\n196#1,9:555\n149#1:564\n205#1,6:570\n214#1,6:579\n149#1:585\n189#1,6:596\n195#1:603\n153#1:604\n196#1,9:606\n149#1:615\n205#1,6:621\n214#1,6:630\n189#1,6:636\n195#1:643\n153#1:644\n196#1,9:646\n149#1:655\n205#1,6:661\n214#1,6:670\n185#1,10:677\n195#1:688\n153#1:689\n196#1,9:691\n149#1:700\n205#1,6:706\n214#1,6:715\n186#1:721\n185#1,10:722\n195#1:733\n153#1:734\n196#1,9:736\n149#1:745\n205#1,6:751\n214#1,6:760\n186#1:766\n159#1,4:767\n163#1:772\n153#1:773\n164#1,7:775\n149#1:782\n171#1,6:788\n179#1,3:797\n159#1,4:800\n163#1:805\n153#1:806\n164#1,7:808\n149#1:815\n171#1,6:821\n179#1,3:830\n153#1:833\n159#1,4:845\n163#1:850\n153#1:851\n164#1,7:853\n149#1:860\n171#1,6:866\n179#1,3:875\n153#1:879\n149#1:881\n189#1,6:892\n195#1:899\n153#1:900\n196#1,9:902\n149#1:911\n205#1,6:917\n214#1,6:926\n153#1:933\n149#1:935\n2279#2:459\n2279#2:469\n2172#2,2:480\n1722#2:482\n2174#2,2:483\n2176#2,3:491\n2279#2:513\n2172#2,2:524\n1722#2:526\n2174#2,2:527\n2176#2,3:535\n2279#2:554\n2172#2,2:565\n1722#2:567\n2174#2,2:568\n2176#2,3:576\n2172#2,2:586\n1722#2:588\n2174#2,2:590\n2176#2,3:593\n2279#2:605\n2172#2,2:616\n1722#2:618\n2174#2,2:619\n2176#2,3:627\n2279#2:645\n2172#2,2:656\n1722#2:658\n2174#2,2:659\n2176#2,3:667\n2279#2:690\n2172#2,2:701\n1722#2:703\n2174#2,2:704\n2176#2,3:712\n2279#2:735\n2172#2,2:746\n1722#2:748\n2174#2,2:749\n2176#2,3:757\n2279#2:774\n2172#2,2:783\n1722#2:785\n2174#2,2:786\n2176#2,3:794\n2279#2:807\n2172#2,2:816\n1722#2:818\n2174#2,2:819\n2176#2,3:827\n2279#2:834\n2172#2,2:835\n1722#2:837\n2174#2,5:839\n2279#2:844\n2279#2:852\n2172#2,2:861\n1722#2:863\n2174#2,2:864\n2176#2,3:872\n2279#2:880\n2172#2,2:882\n1722#2:884\n2174#2,2:886\n2176#2,3:889\n2279#2:901\n2172#2,2:912\n1722#2:914\n2174#2,2:915\n2176#2,3:923\n2279#2:934\n2172#2,2:936\n1722#2:938\n2174#2,2:940\n2176#2,3:943\n70#3:466\n70#3:510\n70#3:551\n70#3:589\n70#3:592\n70#3:602\n70#3:642\n70#3:687\n70#3:732\n70#3:771\n70#3:804\n70#3:838\n70#3:849\n70#3:878\n70#3:885\n70#3:888\n70#3:898\n70#3:932\n70#3:939\n70#3:942\n1#4:676\n*S KotlinDebug\n*F\n+ 1 SnapshotStateList.kt\nandroidx/compose/runtime/snapshots/SnapshotStateList\n*L\n62#1:458\n101#1:460,6\n101#1:467\n101#1:468\n101#1:470,9\n101#1:479\n101#1:485,6\n101#1:494,6\n102#1:500,10\n102#1:511\n102#1:512\n102#1:514,9\n102#1:523\n102#1:529,6\n102#1:538,6\n102#1:544\n107#1:545,6\n107#1:552\n107#1:553\n107#1:555,9\n107#1:564\n107#1:570,6\n107#1:579,6\n109#1:585\n116#1:596,6\n116#1:603\n116#1:604\n116#1:606,9\n116#1:615\n116#1:621,6\n116#1:630,6\n117#1:636,6\n117#1:643\n117#1:644\n117#1:646,9\n117#1:655\n117#1:661,6\n117#1:670,6\n118#1:677,10\n118#1:688\n118#1:689\n118#1:691,9\n118#1:700\n118#1:706,6\n118#1:715,6\n118#1:721\n121#1:722,10\n121#1:733\n121#1:734\n121#1:736,9\n121#1:745\n121#1:751,6\n121#1:760,6\n121#1:766\n125#1:767,4\n125#1:772\n125#1:773\n125#1:775,7\n125#1:782\n125#1:788,6\n125#1:797,3\n132#1:800,4\n132#1:805\n132#1:806\n132#1:808,7\n132#1:815\n132#1:821,6\n132#1:830,3\n145#1:833\n155#1:845,4\n155#1:850\n155#1:851\n155#1:853,7\n155#1:860\n155#1:866,6\n155#1:875,3\n163#1:879\n170#1:881\n185#1:892,6\n185#1:899\n185#1:900\n185#1:902,9\n185#1:911\n185#1:917,6\n185#1:926,6\n195#1:933\n204#1:935\n62#1:459\n101#1:469\n101#1:480,2\n101#1:482\n101#1:483,2\n101#1:491,3\n102#1:513\n102#1:524,2\n102#1:526\n102#1:527,2\n102#1:535,3\n107#1:554\n107#1:565,2\n107#1:567\n107#1:568,2\n107#1:576,3\n109#1:586,2\n109#1:588\n109#1:590,2\n109#1:593,3\n116#1:605\n116#1:616,2\n116#1:618\n116#1:619,2\n116#1:627,3\n117#1:645\n117#1:656,2\n117#1:658\n117#1:659,2\n117#1:667,3\n118#1:690\n118#1:701,2\n118#1:703\n118#1:704,2\n118#1:712,3\n121#1:735\n121#1:746,2\n121#1:748\n121#1:749,2\n121#1:757,3\n125#1:774\n125#1:783,2\n125#1:785\n125#1:786,2\n125#1:794,3\n132#1:807\n132#1:816,2\n132#1:818\n132#1:819,2\n132#1:827,3\n145#1:834\n149#1:835,2\n149#1:837\n149#1:839,5\n153#1:844\n155#1:852\n155#1:861,2\n155#1:863\n155#1:864,2\n155#1:872,3\n163#1:880\n170#1:882,2\n170#1:884\n170#1:886,2\n170#1:889,3\n185#1:901\n185#1:912,2\n185#1:914\n185#1:915,2\n185#1:923,3\n195#1:934\n204#1:936,2\n204#1:938\n204#1:940,2\n204#1:943,3\n101#1:466\n102#1:510\n107#1:551\n109#1:589\n110#1:592\n116#1:602\n117#1:642\n118#1:687\n121#1:732\n125#1:771\n132#1:804\n149#1:838\n155#1:849\n162#1:878\n170#1:885\n171#1:888\n185#1:898\n194#1:932\n204#1:939\n205#1:942\n*E\n"})
public final class SnapshotStateList<T> implements List<T>, StateObject, KMutableList {
    public static final int $stable = 0;
    private StateRecord firstStateRecord;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSnapshotStateList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SnapshotStateList.kt\nandroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n*L\n1#1,457:1\n70#2:458\n*S KotlinDebug\n*F\n+ 1 SnapshotStateList.kt\nandroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord\n*L\n76#1:458\n*E\n"})
    public static final class StateListStateRecord<T> extends StateRecord {
        private PersistentList<? extends T> list;
        private int modification;

        public StateListStateRecord(PersistentList<? extends T> r5) {
            Intrinsics.checkNotNullParameter(r5, "list");
            this.list = r5;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            Object r10 = SnapshotStateListKt.access$getSync$p();
            monitor-enter(r10);
            this.list = ((StateListStateRecord) r5).list;     // Catch: Throwable -> L7
            this.modification = ((StateListStateRecord) r5).modification;     // Catch: Throwable -> L7
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r10);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setList$runtime_release(PersistentList<? extends T> r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.list = r5;
        }

        public final void setModification$runtime_release(int r5) {
            this.modification = r5;
        }
    }

    public SnapshotStateList() {
        this.firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());
    }

    private final boolean conditionalUpdate(Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> r10) {
    L2:
        Object r5 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L39
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L39
        StateListStateRecord r12 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r11);     // Catch: Throwable -> L39
        int r13 = r12.getModification$runtime_release();     // Catch: Throwable -> L39
        PersistentList<T> r14 = r12.getList$runtime_release();     // Catch: Throwable -> L39
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L39
        InlineMarker.finallyStart(1);
        monitor-exit(r5);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r14);
        PersistentList<? extends T> r16 = r10.invoke(r14);
        boolean r17 = false;
        if (Intrinsics.areEqual(r16, r14) == true) goto L28;
        StateRecord r18 = getFirstStateRecord();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r19 = (StateListStateRecord) r18;
        SnapshotKt.getSnapshotInitializer();
        Object r20 = SnapshotKt.getLock();
        monitor-enter(r20);
        Snapshot r21 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L29
        StateListStateRecord r22 = (StateListStateRecord) SnapshotKt.writableRecord(r19, this, r21);     // Catch: Throwable -> L29
        Object r23 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L29
        monitor-enter(r23);     // Catch: Throwable -> L29
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L29
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L16:
        if (r22.getModification$runtime_release() != r13) goto L21;
        r22.setList$runtime_release(r16);     // Catch: Throwable -> L19
        r22.setModification$runtime_release(r22.getModification$runtime_release() + 1);     // Catch: Throwable -> L19
        r17 = true;
        goto L21
    L21:
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L29
        monitor-exit(r23);     // Catch: Throwable -> L29
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L29
        InlineMarker.finallyStart(1);
        monitor-exit(r20);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r21, this);
        if (r17 == false) goto L2;
        return true;
    L29:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L28:
        return false;
    L39:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> r10) {
    L2:
        Object r5 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L40
        StateListStateRecord r12 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r11);     // Catch: Throwable -> L40
        int r13 = r12.getModification$runtime_release();     // Catch: Throwable -> L40
        PersistentList<T> r14 = r12.getList$runtime_release();     // Catch: Throwable -> L40
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L40
        InlineMarker.finallyStart(1);
        monitor-exit(r5);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r14);
        PersistentList.Builder<T> r16 = r14.builder();
        R r17 = r10.invoke(r16);
        PersistentList<T> r18 = r16.build();
        if (Intrinsics.areEqual(r18, r14) == true) goto L39;
        StateRecord r19 = getFirstStateRecord();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r20 = (StateListStateRecord) r19;
        SnapshotKt.getSnapshotInitializer();
        Object r21 = SnapshotKt.getLock();
        monitor-enter(r21);
        Snapshot r22 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L29
        StateListStateRecord r23 = (StateListStateRecord) SnapshotKt.writableRecord(r20, this, r22);     // Catch: Throwable -> L29
        Object r24 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L29
        monitor-enter(r24);     // Catch: Throwable -> L29
    L18:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L29
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L15:
        if (r23.getModification$runtime_release() != r13) goto L20;
        r23.setList$runtime_release(r18);     // Catch: Throwable -> L18
        r23.setModification$runtime_release(r23.getModification$runtime_release() + 1);     // Catch: Throwable -> L18
        boolean r25 = true;
    L21:
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L29
        monitor-exit(r24);     // Catch: Throwable -> L29
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L29
        InlineMarker.finallyStart(1);
        monitor-exit(r21);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r22, this);
        if (r25 == false) goto L2;
    L20:
        r25 = false;
    L29:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L39:
        return r17;
    L40:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> r10) {
    L2:
        Object r5 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L32
        StateListStateRecord r12 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r11);     // Catch: Throwable -> L32
        int r13 = r12.getModification$runtime_release();     // Catch: Throwable -> L32
        PersistentList<T> r14 = r12.getList$runtime_release();     // Catch: Throwable -> L32
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r5);
        Intrinsics.checkNotNull(r14);
        PersistentList.Builder<T> r16 = r14.builder();
        Boolean r17 = r10.invoke(r16);
        PersistentList<T> r18 = r16.build();
        if (Intrinsics.areEqual(r18, r14) == true) goto L31;
        StateRecord r19 = getFirstStateRecord();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r20 = (StateListStateRecord) r19;
        SnapshotKt.getSnapshotInitializer();
        Object r21 = SnapshotKt.getLock();
        monitor-enter(r21);
        Snapshot r22 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L24
        StateListStateRecord r23 = (StateListStateRecord) SnapshotKt.writableRecord(r20, this, r22);     // Catch: Throwable -> L24
        Object r24 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L24
        monitor-enter(r24);     // Catch: Throwable -> L24
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L13:
        if (r23.getModification$runtime_release() != r13) goto L18;
        r23.setList$runtime_release(r18);     // Catch: Throwable -> L16
        boolean r25 = true;
        r23.setModification$runtime_release(r23.getModification$runtime_release() + 1);     // Catch: Throwable -> L16
    L19:
        monitor-exit(r24);     // Catch: Throwable -> L24
        monitor-exit(r21);
        SnapshotKt.notifyWrite(r22, this);
        if (r25 == false) goto L2;
    L18:
        r25 = false;
    L24:
        th = move-exception;
        throw th;
    L31:
        return r17.booleanValue();
    L32:
        th = move-exception;
        throw th;
    }

    private final void update(Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> r10) {
    L2:
        Object r5 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L40
        StateListStateRecord r12 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r11);     // Catch: Throwable -> L40
        int r13 = r12.getModification$runtime_release();     // Catch: Throwable -> L40
        PersistentList<T> r14 = r12.getList$runtime_release();     // Catch: Throwable -> L40
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L40
        InlineMarker.finallyStart(1);
        monitor-exit(r5);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r14);
        PersistentList<? extends T> r16 = r10.invoke(r14);
        if (Intrinsics.areEqual(r16, r14) == true) goto L29;
        StateRecord r17 = getFirstStateRecord();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r18 = (StateListStateRecord) r17;
        SnapshotKt.getSnapshotInitializer();
        Object r19 = SnapshotKt.getLock();
        monitor-enter(r19);
        Snapshot r20 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L30
        StateListStateRecord r21 = (StateListStateRecord) SnapshotKt.writableRecord(r18, this, r20);     // Catch: Throwable -> L30
        Object r22 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L30
        monitor-enter(r22);     // Catch: Throwable -> L30
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L30
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L16:
        if (r21.getModification$runtime_release() != r13) goto L21;
        r21.setList$runtime_release(r16);     // Catch: Throwable -> L19
        r21.setModification$runtime_release(r21.getModification$runtime_release() + 1);     // Catch: Throwable -> L19
        boolean r23 = true;
    L22:
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L30
        monitor-exit(r22);     // Catch: Throwable -> L30
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L30
        InlineMarker.finallyStart(1);
        monitor-exit(r19);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r20, this);
        if (r23 == false) goto L2;
        return;
    L21:
        r23 = false;
    L30:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L29:
        return;
    L40:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> r5) {
        StateRecord r10 = getFirstStateRecord();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return r5.invoke(SnapshotKt.current((StateListStateRecord) r10));
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> r5) {
        StateRecord r10 = getFirstStateRecord();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r11 = (StateListStateRecord) r10;
        SnapshotKt.getSnapshotInitializer();
        Object r12 = SnapshotKt.getLock();
        monitor-enter(r12);
        Snapshot r13 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L10
        R r14 = r5.invoke(SnapshotKt.writableRecord(r11, this, r13));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r12);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r13, this);
        return r14;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T r10) {
    L2:
        Object r5 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L31
        StateListStateRecord r12 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r11);     // Catch: Throwable -> L31
        int r13 = r12.getModification$runtime_release();     // Catch: Throwable -> L31
        PersistentList<T> r14 = r12.getList$runtime_release();     // Catch: Throwable -> L31
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r5);
        Intrinsics.checkNotNull(r14);
        PersistentList<T> r16 = r14.add(r10);
        boolean r17 = false;
        if (Intrinsics.areEqual(r16, r14) == true) goto L43;
        StateRecord r18 = getFirstStateRecord();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r19 = (StateListStateRecord) r18;
        SnapshotKt.getSnapshotInitializer();
        Object r20 = SnapshotKt.getLock();
        monitor-enter(r20);
        Snapshot r21 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L25
        StateListStateRecord r22 = (StateListStateRecord) SnapshotKt.writableRecord(r19, this, r21);     // Catch: Throwable -> L25
        Object r23 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L25
        monitor-enter(r23);     // Catch: Throwable -> L25
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L14:
        if (r22.getModification$runtime_release() != r13) goto L19;
        r22.setList$runtime_release(r16);     // Catch: Throwable -> L17
        r22.setModification$runtime_release(r22.getModification$runtime_release() + 1);     // Catch: Throwable -> L17
        r17 = true;
        goto L19
    L19:
        monitor-exit(r23);     // Catch: Throwable -> L25
        monitor-exit(r20);
        SnapshotKt.notifyWrite(r21, this);
        if (r17 == false) goto L2;
        return true;
    L25:
        th = move-exception;
        throw th;
    L43:
        return false;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public boolean addAll(final int r5, final Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return mutateBoolean(new AnonymousClass1(r5, r10));
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        StateRecord r5 = getFirstStateRecord();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r10 = (StateListStateRecord) r5;
        SnapshotKt.getSnapshotInitializer();
        Object r11 = SnapshotKt.getLock();
        monitor-enter(r11);
        Snapshot r12 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L11
        StateListStateRecord r13 = (StateListStateRecord) SnapshotKt.writableRecord(r10, this, r12);     // Catch: Throwable -> L11
        Object r14 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L11
        monitor-enter(r14);     // Catch: Throwable -> L11
        r13.setList$runtime_release(ExtensionsKt.persistentListOf());     // Catch: Throwable -> L13
        r13.setModification$runtime_release(r13.getModification$runtime_release() + 1);     // Catch: Throwable -> L13
        monitor-exit(r14);     // Catch: Throwable -> L11
        monitor-exit(r11);
        SnapshotKt.notifyWrite(r12, this);
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r5) {
        return getReadable$runtime_release().getList$runtime_release().contains(r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(r5);
    }

    @Override // java.util.List
    public T get(int r5) {
        return getReadable$runtime_release().getList$runtime_release().get(r5);
    }

    @JvmName(name = "getDebuggerDisplayValue")
    public final List<T> getDebuggerDisplayValue() {
        StateRecord r5 = getFirstStateRecord();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) r5)).getList$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final int getModification$runtime_release() {
        StateRecord r5 = getFirstStateRecord();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) r5)).getModification$runtime_release();
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateRecord r5 = getFirstStateRecord();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) r5, this);
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    @Override // java.util.List
    public int indexOf(Object r5) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object r5) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(r5);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        r5.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) r5;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int r5) {
        return removeAt(r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
    L3:
        Object r5 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L32
        StateListStateRecord r12 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r11);     // Catch: Throwable -> L32
        int r13 = r12.getModification$runtime_release();     // Catch: Throwable -> L32
        PersistentList<T> r14 = r12.getList$runtime_release();     // Catch: Throwable -> L32
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r5);
        Intrinsics.checkNotNull(r14);
        PersistentList<T> r16 = r14.removeAll(r10);
        boolean r17 = false;
        if (Intrinsics.areEqual(r16, r14) == true) goto L44;
        StateRecord r18 = getFirstStateRecord();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r19 = (StateListStateRecord) r18;
        SnapshotKt.getSnapshotInitializer();
        Object r20 = SnapshotKt.getLock();
        monitor-enter(r20);
        Snapshot r21 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L26
        StateListStateRecord r22 = (StateListStateRecord) SnapshotKt.writableRecord(r19, this, r21);     // Catch: Throwable -> L26
        Object r23 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L26
        monitor-enter(r23);     // Catch: Throwable -> L26
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L15:
        if (r22.getModification$runtime_release() != r13) goto L20;
        r22.setList$runtime_release(r16);     // Catch: Throwable -> L18
        r22.setModification$runtime_release(r22.getModification$runtime_release() + 1);     // Catch: Throwable -> L18
        r17 = true;
        goto L20
    L20:
        monitor-exit(r23);     // Catch: Throwable -> L26
        monitor-exit(r20);
        SnapshotKt.notifyWrite(r21, this);
        if (r17 == false) goto L3;
        return true;
    L26:
        th = move-exception;
        throw th;
    L44:
        return false;
    L32:
        th = move-exception;
        throw th;
    }

    public T removeAt(int r10) {
        T r5 = get(r10);
    L3:
        Object r11 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r11);
        StateRecord r12 = getFirstStateRecord();     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L32
        StateListStateRecord r13 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r12);     // Catch: Throwable -> L32
        int r14 = r13.getModification$runtime_release();     // Catch: Throwable -> L32
        PersistentList<T> r15 = r13.getList$runtime_release();     // Catch: Throwable -> L32
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r11);
        Intrinsics.checkNotNull(r15);
        PersistentList<T> r17 = r15.removeAt(r10);
        if (Intrinsics.areEqual(r17, r15) == true) goto L25;
        StateRecord r18 = getFirstStateRecord();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r19 = (StateListStateRecord) r18;
        SnapshotKt.getSnapshotInitializer();
        Object r20 = SnapshotKt.getLock();
        monitor-enter(r20);
        Snapshot r21 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L26
        StateListStateRecord r22 = (StateListStateRecord) SnapshotKt.writableRecord(r19, this, r21);     // Catch: Throwable -> L26
        Object r23 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L26
        monitor-enter(r23);     // Catch: Throwable -> L26
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L15:
        if (r22.getModification$runtime_release() != r14) goto L20;
        r22.setList$runtime_release(r17);     // Catch: Throwable -> L18
        boolean r24 = true;
        r22.setModification$runtime_release(r22.getModification$runtime_release() + 1);     // Catch: Throwable -> L18
    L21:
        monitor-exit(r23);     // Catch: Throwable -> L26
        monitor-exit(r20);
        SnapshotKt.notifyWrite(r21, this);
        if (r24 == false) goto L3;
    L20:
        r24 = false;
    L26:
        th = move-exception;
        throw th;
    L25:
        return r5;
    L32:
        th = move-exception;
        throw th;
    }

    public final void removeRange(int r10, int r11) {
    L2:
        Object r5 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r12 = getFirstStateRecord();     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L31
        StateListStateRecord r13 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r12);     // Catch: Throwable -> L31
        int r14 = r13.getModification$runtime_release();     // Catch: Throwable -> L31
        PersistentList<T> r15 = r13.getList$runtime_release();     // Catch: Throwable -> L31
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r5);
        Intrinsics.checkNotNull(r15);
        PersistentList.Builder<T> r17 = r15.builder();
        r17.subList(r10, r11).clear();
        PersistentList<T> r18 = r17.build();
        if (Intrinsics.areEqual(r18, r15) == true) goto L30;
        StateRecord r19 = getFirstStateRecord();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r20 = (StateListStateRecord) r19;
        SnapshotKt.getSnapshotInitializer();
        Object r21 = SnapshotKt.getLock();
        monitor-enter(r21);
        Snapshot r22 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L24
        StateListStateRecord r23 = (StateListStateRecord) SnapshotKt.writableRecord(r20, this, r22);     // Catch: Throwable -> L24
        Object r24 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L24
        monitor-enter(r24);     // Catch: Throwable -> L24
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L13:
        if (r23.getModification$runtime_release() != r14) goto L18;
        r23.setList$runtime_release(r18);     // Catch: Throwable -> L16
        boolean r25 = true;
        r23.setModification$runtime_release(r23.getModification$runtime_release() + 1);     // Catch: Throwable -> L16
    L19:
        monitor-exit(r24);     // Catch: Throwable -> L24
        monitor-exit(r21);
        SnapshotKt.notifyWrite(r22, this);
        if (r25 == false) goto L2;
        return;
    L18:
        r25 = false;
    L24:
        th = move-exception;
        throw th;
    L30:
        return;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(final Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return mutateBoolean(new C00701(r5));
    }

    public final int retainAllInRange$runtime_release(Collection<? extends T> r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        int r5 = size();
    L3:
        Object r13 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r13);
        StateRecord r14 = getFirstStateRecord();     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L33
        StateListStateRecord r15 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r14);     // Catch: Throwable -> L33
        int r16 = r15.getModification$runtime_release();     // Catch: Throwable -> L33
        PersistentList<T> r17 = r15.getList$runtime_release();     // Catch: Throwable -> L33
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r13);
        Intrinsics.checkNotNull(r17);
        PersistentList.Builder<T> r19 = r17.builder();
        r19.subList(r11, r12).retainAll(r10);
        PersistentList<T> r20 = r19.build();
        if (Intrinsics.areEqual(r20, r17) == true) goto L32;
        StateRecord r21 = getFirstStateRecord();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r22 = (StateListStateRecord) r21;
        SnapshotKt.getSnapshotInitializer();
        Object r23 = SnapshotKt.getLock();
        monitor-enter(r23);
        Snapshot r24 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L25
        StateListStateRecord r25 = (StateListStateRecord) SnapshotKt.writableRecord(r22, this, r24);     // Catch: Throwable -> L25
        Object r26 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L25
        monitor-enter(r26);     // Catch: Throwable -> L25
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L14:
        if (r25.getModification$runtime_release() != r16) goto L19;
        r25.setList$runtime_release(r20);     // Catch: Throwable -> L17
        boolean r27 = true;
        r25.setModification$runtime_release(r25.getModification$runtime_release() + 1);     // Catch: Throwable -> L17
    L20:
        monitor-exit(r26);     // Catch: Throwable -> L25
        monitor-exit(r23);
        SnapshotKt.notifyWrite(r24, this);
        if (r27 == false) goto L3;
    L19:
        r27 = false;
    L25:
        th = move-exception;
        throw th;
    L32:
        return r5 - size();
    L33:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public T set(int r10, T r11) {
        T r5 = get(r10);
    L3:
        Object r12 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r12);
        StateRecord r13 = getFirstStateRecord();     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L32
        StateListStateRecord r14 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r13);     // Catch: Throwable -> L32
        int r15 = r14.getModification$runtime_release();     // Catch: Throwable -> L32
        PersistentList<T> r16 = r14.getList$runtime_release();     // Catch: Throwable -> L32
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r12);
        Intrinsics.checkNotNull(r16);
        PersistentList<T> r18 = r16.set(r10, r11);
        if (Intrinsics.areEqual(r18, r16) == true) goto L25;
        StateRecord r19 = getFirstStateRecord();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r20 = (StateListStateRecord) r19;
        SnapshotKt.getSnapshotInitializer();
        Object r21 = SnapshotKt.getLock();
        monitor-enter(r21);
        Snapshot r22 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L26
        StateListStateRecord r23 = (StateListStateRecord) SnapshotKt.writableRecord(r20, this, r22);     // Catch: Throwable -> L26
        Object r24 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L26
        monitor-enter(r24);     // Catch: Throwable -> L26
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L15:
        if (r23.getModification$runtime_release() != r15) goto L20;
        r23.setList$runtime_release(r18);     // Catch: Throwable -> L18
        boolean r25 = true;
        r23.setModification$runtime_release(r23.getModification$runtime_release() + 1);     // Catch: Throwable -> L18
    L21:
        monitor-exit(r24);     // Catch: Throwable -> L26
        monitor-exit(r21);
        SnapshotKt.notifyWrite(r22, this);
        if (r25 == false) goto L3;
    L20:
        r25 = false;
    L26:
        th = move-exception;
        throw th;
    L25:
        return r5;
    L32:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List<T> subList(int r5, int r10) {
        if (r5 < 0) goto L9;
        if (r5 > r10) goto L9;
        if (r10 > size()) goto L9;
        return new SubList(this, r5, r10);
    L9:
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public final List<T> toList() {
        return getReadable$runtime_release().getList$runtime_release();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
    L3:
        Object r5 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L32
        StateListStateRecord r12 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r11);     // Catch: Throwable -> L32
        int r13 = r12.getModification$runtime_release();     // Catch: Throwable -> L32
        PersistentList<T> r14 = r12.getList$runtime_release();     // Catch: Throwable -> L32
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r5);
        Intrinsics.checkNotNull(r14);
        PersistentList<T> r16 = r14.addAll(r10);
        boolean r17 = false;
        if (Intrinsics.areEqual(r16, r14) == true) goto L44;
        StateRecord r18 = getFirstStateRecord();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r19 = (StateListStateRecord) r18;
        SnapshotKt.getSnapshotInitializer();
        Object r20 = SnapshotKt.getLock();
        monitor-enter(r20);
        Snapshot r21 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L26
        StateListStateRecord r22 = (StateListStateRecord) SnapshotKt.writableRecord(r19, this, r21);     // Catch: Throwable -> L26
        Object r23 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L26
        monitor-enter(r23);     // Catch: Throwable -> L26
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L15:
        if (r22.getModification$runtime_release() != r13) goto L20;
        r22.setList$runtime_release(r16);     // Catch: Throwable -> L18
        r22.setModification$runtime_release(r22.getModification$runtime_release() + 1);     // Catch: Throwable -> L18
        r17 = true;
        goto L20
    L20:
        monitor-exit(r23);     // Catch: Throwable -> L26
        monitor-exit(r20);
        SnapshotKt.notifyWrite(r21, this);
        if (r17 == false) goto L3;
        return true;
    L26:
        th = move-exception;
        throw th;
    L44:
        return false;
    L32:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int r5) {
        return new StateListIterator(this, r5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r10) {
    L2:
        Object r5 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r11 = getFirstStateRecord();     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L31
        StateListStateRecord r12 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r11);     // Catch: Throwable -> L31
        int r13 = r12.getModification$runtime_release();     // Catch: Throwable -> L31
        PersistentList<T> r14 = r12.getList$runtime_release();     // Catch: Throwable -> L31
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r5);
        Intrinsics.checkNotNull(r14);
        PersistentList<T> r16 = r14.remove(r10);
        boolean r17 = false;
        if (Intrinsics.areEqual(r16, r14) == true) goto L43;
        StateRecord r18 = getFirstStateRecord();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r19 = (StateListStateRecord) r18;
        SnapshotKt.getSnapshotInitializer();
        Object r20 = SnapshotKt.getLock();
        monitor-enter(r20);
        Snapshot r21 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L25
        StateListStateRecord r22 = (StateListStateRecord) SnapshotKt.writableRecord(r19, this, r21);     // Catch: Throwable -> L25
        Object r23 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L25
        monitor-enter(r23);     // Catch: Throwable -> L25
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L14:
        if (r22.getModification$runtime_release() != r13) goto L19;
        r22.setList$runtime_release(r16);     // Catch: Throwable -> L17
        r22.setModification$runtime_release(r22.getModification$runtime_release() + 1);     // Catch: Throwable -> L17
        r17 = true;
        goto L19
    L19:
        monitor-exit(r23);     // Catch: Throwable -> L25
        monitor-exit(r20);
        SnapshotKt.notifyWrite(r21, this);
        if (r17 == false) goto L2;
        return true;
    L25:
        th = move-exception;
        throw th;
    L43:
        return false;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "array");
        return (T[]) CollectionToArray.toArray(this, r5);
    }

    @Override // java.util.List
    public void add(int r10, T r11) {
    L2:
        Object r5 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r5);
        StateRecord r12 = getFirstStateRecord();     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");     // Catch: Throwable -> L31
        StateListStateRecord r13 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r12);     // Catch: Throwable -> L31
        int r14 = r13.getModification$runtime_release();     // Catch: Throwable -> L31
        PersistentList<T> r15 = r13.getList$runtime_release();     // Catch: Throwable -> L31
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r5);
        Intrinsics.checkNotNull(r15);
        PersistentList<T> r17 = r15.add(r10, r11);
        if (Intrinsics.areEqual(r17, r15) == true) goto L24;
        StateRecord r18 = getFirstStateRecord();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord r19 = (StateListStateRecord) r18;
        SnapshotKt.getSnapshotInitializer();
        Object r20 = SnapshotKt.getLock();
        monitor-enter(r20);
        Snapshot r21 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L25
        StateListStateRecord r22 = (StateListStateRecord) SnapshotKt.writableRecord(r19, this, r21);     // Catch: Throwable -> L25
        Object r23 = SnapshotStateListKt.access$getSync$p();     // Catch: Throwable -> L25
        monitor-enter(r23);     // Catch: Throwable -> L25
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L14:
        if (r22.getModification$runtime_release() != r14) goto L19;
        r22.setList$runtime_release(r17);     // Catch: Throwable -> L17
        boolean r24 = true;
        r22.setModification$runtime_release(r22.getModification$runtime_release() + 1);     // Catch: Throwable -> L17
    L20:
        monitor-exit(r23);     // Catch: Throwable -> L25
        monitor-exit(r20);
        SnapshotKt.notifyWrite(r21, this);
        if (r24 == false) goto L2;
        return;
    L19:
        r24 = false;
    L25:
        th = move-exception;
        throw th;
    L24:
        return;
    L31:
        th = move-exception;
        throw th;
    }
}
