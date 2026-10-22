package kotlin.time;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\f\u0082\u0002\u0004\n\u0002\b!¨\u0006\u000f"}, d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface TimeMark {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean hasNotPassedNow(TimeMark r2) {
            return Duration.m2780isNegativeimpl(((TimeMark) ZeusTransformUtils.wrapperContextForParams(r2, TimeMark.class, "com.obric.memorydata.plugin")).mo2737elapsedNowUwyO8pc());
        }

        public static boolean hasPassedNow(TimeMark r2) {
            return !Duration.m2780isNegativeimpl(((TimeMark) ZeusTransformUtils.wrapperContextForParams(r2, TimeMark.class, "com.obric.memorydata.plugin")).mo2737elapsedNowUwyO8pc());
        }

        /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
        public static TimeMark m2884minusLRDsOJo(TimeMark r2, long r3) {
            return ((TimeMark) ZeusTransformUtils.wrapperContextForParams(r2, TimeMark.class, "com.obric.memorydata.plugin")).mo2740plusLRDsOJo(Duration.m2800unaryMinusUwyO8pc(r3));
        }

        /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
        public static TimeMark m2885plusLRDsOJo(TimeMark r3, long r4) {
            return (TimeMark) ZeusTransformUtils.preCheckCast(new AdjustedTimeMark((TimeMark) ZeusTransformUtils.wrapperContextForParams(r3, TimeMark.class, "com.obric.memorydata.plugin"), r4, null), TimeMark.class, "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
    long mo2737elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    /* JADX INFO: renamed from: minus-LRDsOJo */
    TimeMark mo2738minusLRDsOJo(long r1);

    /* JADX INFO: renamed from: plus-LRDsOJo */
    TimeMark mo2740plusLRDsOJo(long r1);
}
