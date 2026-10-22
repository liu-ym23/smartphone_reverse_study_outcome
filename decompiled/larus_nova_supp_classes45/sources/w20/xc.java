package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b<\u0010=R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR$\u0010&\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R$\u0010)\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010\u0012R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR$\u0010/\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000e\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lw20/xc;", "", "", "mode", "Ljava/lang/Integer;", "getMode", "()Ljava/lang/Integer;", "setMode", "(Ljava/lang/Integer;)V", "position", "getPosition", "setPosition", "", "after_follow", "Ljava/lang/Boolean;", "getAfter_follow", "()Ljava/lang/Boolean;", "setAfter_follow", "(Ljava/lang/Boolean;)V", "", "source_page", "Ljava/lang/String;", "getSource_page", "()Ljava/lang/String;", "setSource_page", "(Ljava/lang/String;)V", "apply_source", "getApply_source", "setApply_source", "click_source", "getClick_source", "setClick_source", "paid_count", "e", "setPaid_count", "limit_time", "c", "setLimit_time", "reason", "g", "setReason", "anonymous", "a", "setAnonymous", "current_mode", "b", "setCurrent_mode", "use_member_benefits", "h", "setUse_member_benefits", "member_discount_amount", "d", "setMember_discount_amount", "Lw20/xc$a;", "paid_linkmic_discount_info", "Lw20/xc$a;", "f", "()Lw20/xc$a;", "setPaid_linkmic_discount_info", "(Lw20/xc$a;)V", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class xc {

    @SerializedName("after_follow")
    private Boolean after_follow;

    @SerializedName("anonymous")
    private Boolean anonymous;

    @SerializedName("apply_source")
    private Integer apply_source;

    @SerializedName("click_source")
    private String click_source;

    @SerializedName("current_mode")
    private Integer current_mode;

    @SerializedName("limit_time")
    private Integer limit_time;

    @SerializedName("member_discount_amount")
    private Integer member_discount_amount;

    @SerializedName("mode")
    private Integer mode;

    @SerializedName("paid_count")
    private Integer paid_count;

    @SerializedName("paid_linkmic_discount_info")
    private a paid_linkmic_discount_info;

    @SerializedName("position")
    private Integer position;

    @SerializedName("reason")
    private String reason;

    @SerializedName("source_page")
    private String source_page;

    @SerializedName("use_member_benefits")
    private Boolean use_member_benefits;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lw20/xc$a;", "", "", "discount_mode", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setDiscount_mode", "(Ljava/lang/Integer;)V", "discount_amount", "a", "setDiscount_amount", "", "discount_text", "Ljava/lang/String;", "getDiscount_text", "()Ljava/lang/String;", "setDiscount_text", "(Ljava/lang/String;)V", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("discount_amount")
        private Integer discount_amount;

        @SerializedName("discount_mode")
        private Integer discount_mode;

        @SerializedName("discount_text")
        private String discount_text;

        public a() {
        }

        public final Integer a() {
            return this.discount_amount;
        }

        public final Integer b() {
            return this.discount_mode;
        }
    }

    public xc() {
    }

    public final Boolean a() {
        return this.anonymous;
    }

    public final Integer b() {
        return this.current_mode;
    }

    public final Integer c() {
        return this.limit_time;
    }

    public final Integer d() {
        return this.member_discount_amount;
    }

    public final Integer e() {
        return this.paid_count;
    }

    public final a f() {
        return this.paid_linkmic_discount_info;
    }

    public final String g() {
        return this.reason;
    }

    public final Boolean h() {
        return this.use_member_benefits;
    }
}
