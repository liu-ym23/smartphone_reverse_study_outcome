package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JY\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u00102\u0006\u0010\u0011\u001a\u0002H\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0087\u0002¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "receiver", "completion", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum CoroutineStart extends Enum<CoroutineStart> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CoroutineStart[] $VALUES = null;
    public static final CoroutineStart ATOMIC = null;
    public static final CoroutineStart DEFAULT = null;
    public static final CoroutineStart LAZY = null;
    public static final CoroutineStart UNDISPATCHED = null;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17200a = null;

        static {
            int[] r0 = new int[CoroutineStart.values().length];
            r0[CoroutineStart.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CoroutineStart.ATOMIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CoroutineStart.UNDISPATCHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CoroutineStart.LAZY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f17200a = r0;
        }
    }

    private static final /* synthetic */ CoroutineStart[] $values() {
        return new CoroutineStart[]{DEFAULT, LAZY, ATOMIC, UNDISPATCHED};
    }

    static {
        DEFAULT = new CoroutineStart("DEFAULT", 0);
        LAZY = new CoroutineStart("LAZY", 1);
        ATOMIC = new CoroutineStart("ATOMIC", 2);
        UNDISPATCHED = new CoroutineStart("UNDISPATCHED", 3);
        CoroutineStart[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private CoroutineStart(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<CoroutineStart> getEntries() {
        return $ENTRIES;
    }

    public static /* synthetic */ void isLazy$annotations() {
    }

    public static CoroutineStart valueOf(String r2) {
        return (CoroutineStart) ZeusTransformUtils.preCheckCast(Enum.valueOf(CoroutineStart.class, r2), CoroutineStart.class, "com.obric.memorydata.plugin");
    }

    public static CoroutineStart[] values() {
        return (CoroutineStart[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CoroutineStart[].class, "com.obric.memorydata.plugin");
    }

    public final <R, T> void invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r9, R r10, Continuation<? super T> r11) {
        Function2 r2 = (Function2) ZeusTransformUtils.wrapperContextForParams(r9, Function2.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        int r8 = a.f17200a[ordinal()];
        if (r8 != 1) goto L5;
        kotlinx.coroutines.a.a.a(r2, r10, r4, null, 4, null);
        return;
    L5:
        if (r8 != 2) goto L7;
        ContinuationKt.startCoroutine(r2, r10, r4);
        return;
    L7:
        if (r8 != 3) goto L9;
        kotlinx.coroutines.a.b.a(r2, r10, r4);
        return;
    L9:
        if (r8 != 4) goto L12;
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isLazy() {
        if (this != LAZY) goto L5;
        return true;
    L5:
        return false;
    }
}
