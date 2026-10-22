package n71;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0002\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00067"}, d2 = {"Ln71/a;", "", "", "enable", "Z", "h", "()Z", "setEnable", "(Z)V", "bottomRightCardEnable", "getBottomRightCardEnable", "setBottomRightCardEnable", "isConditionEnable", "j", "setConditionEnable", "isEnterConditionEnable", "k", "setEnterConditionEnable", "isForceCloseEnable", "setForceCloseEnable", "dslOptEnable", "f", "setDslOptEnable", "cardConstraintOpt", "a", "setCardConstraintOpt", "cardMapOptEnable", "d", "setCardMapOptEnable", "cardLifecycleCallbackOpt", "c", "setCardLifecycleCallbackOpt", "dslViewRecycleEnable", "g", "setDslViewRecycleEnable", "", "", "experimentalCards", "Ljava/util/Map;", "i", "()Ljava/util/Map;", "l", "(Ljava/util/Map;)V", "cardContainerOpt", "b", "setCardContainerOpt", "", "defaultTopRightCardRightMargin", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "setDefaultTopRightCardRightMargin", "(Ljava/lang/Integer;)V", "<init>", "()V", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("bottom_right_card_enable")
    private boolean bottomRightCardEnable;

    @SerializedName("card_constraint_opt")
    private boolean cardConstraintOpt;

    @SerializedName("card_container_opt")
    private boolean cardContainerOpt;

    @SerializedName("card_lifecycle_callback_opt")
    private boolean cardLifecycleCallbackOpt;

    @SerializedName("card_map_opt_enable")
    private boolean cardMapOptEnable;

    @SerializedName("default_top_right_card_right_margin")
    private Integer defaultTopRightCardRightMargin;

    @SerializedName("dsl_opt_enable")
    private boolean dslOptEnable;

    @SerializedName("dsl_view_recycle_enable")
    private boolean dslViewRecycleEnable;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("experimental_cards")
    private Map<String, Boolean> experimentalCards;

    @SerializedName("is_condition_enable")
    private boolean isConditionEnable;

    @SerializedName("is_enter_condition_enable")
    private boolean isEnterConditionEnable;

    @SerializedName("is_force_close_enable")
    private boolean isForceCloseEnable;

    public a() {
        this.isConditionEnable = true;
        this.isEnterConditionEnable = true;
        this.isForceCloseEnable = true;
        this.dslOptEnable = true;
        this.cardConstraintOpt = true;
        this.cardMapOptEnable = true;
        this.cardLifecycleCallbackOpt = true;
        this.dslViewRecycleEnable = true;
        this.experimentalCards = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("10", Boolean.FALSE)});
        this.cardContainerOpt = true;
        this.defaultTopRightCardRightMargin = 12;
    }

    public final boolean a() {
        return this.cardConstraintOpt;
    }

    public final boolean b() {
        return this.cardContainerOpt;
    }

    public final boolean c() {
        return this.cardLifecycleCallbackOpt;
    }

    public final boolean d() {
        return this.cardMapOptEnable;
    }

    public final Integer e() {
        return this.defaultTopRightCardRightMargin;
    }

    public final boolean f() {
        return this.dslOptEnable;
    }

    public final boolean g() {
        return this.dslViewRecycleEnable;
    }

    public final boolean h() {
        return this.enable;
    }

    public final Map<String, Boolean> i() {
        return this.experimentalCards;
    }

    public final boolean j() {
        return this.isConditionEnable;
    }

    public final boolean k() {
        return this.isEnterConditionEnable;
    }

    public final void l(Map<String, Boolean> r1) {
        this.experimentalCards = r1;
    }
}
