package o72;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006$"}, d2 = {"Lo72/f;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hotChatActionProportion", "Ljava/util/List;", "f", "()Ljava/util/List;", "setHotChatActionProportion", "(Ljava/util/List;)V", "normalChatActionProportion", "i", "setNormalChatActionProportion", "coldChatActionProportion", "c", "setColdChatActionProportion", "hotBusinessActionProportion", "e", "setHotBusinessActionProportion", "normalBusinessActionProportion", "h", "setNormalBusinessActionProportion", "coldBusinessActionProportion", "b", "setColdBusinessActionProportion", "hotBasicActionProportion", "d", "setHotBasicActionProportion", "normalBasicActionProportion", "g", "setNormalBasicActionProportion", "coldBasicActionProportion", "a", "setColdBasicActionProportion", "<init>", "()V", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("cold_basic_proportion")
    private List<Integer> coldBasicActionProportion;

    @SerializedName("cold_business_proportion")
    private List<Integer> coldBusinessActionProportion;

    @SerializedName("cold_chat_proportion")
    private List<Integer> coldChatActionProportion;

    @SerializedName("hot_basic_proportion")
    private List<Integer> hotBasicActionProportion;

    @SerializedName("hot_business_proportion")
    private List<Integer> hotBusinessActionProportion;

    @SerializedName("hot_chat_proportion")
    private List<Integer> hotChatActionProportion;

    @SerializedName("normal_basic_proportion")
    private List<Integer> normalBasicActionProportion;

    @SerializedName("normal_business_proportion")
    private List<Integer> normalBusinessActionProportion;

    @SerializedName("normal_chat_proportion")
    private List<Integer> normalChatActionProportion;

    public f() {
        this.hotChatActionProportion = CollectionsKt.listOf(new Integer[]{4, 2, 1});
        this.normalChatActionProportion = CollectionsKt.listOf(new Integer[]{4, 2, 1});
        this.coldChatActionProportion = CollectionsKt.listOf(new Integer[]{3, 2, 1});
        this.hotBusinessActionProportion = CollectionsKt.listOf(new Integer[]{3, 0, 0});
        this.normalBusinessActionProportion = CollectionsKt.listOf(new Integer[]{2, 1, 0});
        this.coldBusinessActionProportion = CollectionsKt.listOf(new Integer[]{1, 1, 0});
        this.hotBasicActionProportion = CollectionsKt.listOf(new Integer[]{0, 0, 0});
        this.normalBasicActionProportion = CollectionsKt.listOf(new Integer[]{0, 0, 0});
        this.coldBasicActionProportion = CollectionsKt.listOf(new Integer[]{2, 0, 0});
    }

    public final List<Integer> a() {
        return this.coldBasicActionProportion;
    }

    public final List<Integer> b() {
        return this.coldBusinessActionProportion;
    }

    public final List<Integer> c() {
        return this.coldChatActionProportion;
    }

    public final List<Integer> d() {
        return this.hotBasicActionProportion;
    }

    public final List<Integer> e() {
        return this.hotBusinessActionProportion;
    }

    public final List<Integer> f() {
        return this.hotChatActionProportion;
    }

    public final List<Integer> g() {
        return this.normalBasicActionProportion;
    }

    public final List<Integer> h() {
        return this.normalBusinessActionProportion;
    }

    public final List<Integer> i() {
        return this.normalChatActionProportion;
    }
}
