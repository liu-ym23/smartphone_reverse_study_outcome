package py;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\t\u0010\u0004\"\u0004\b\n\u0010\u0006R6\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lpy/t;", "Lvh7/c;", "", "isMuted", "()Z", "setMuted", "(Z)V", "isMuted$annotations", "()V", "isAdmin", "setAdmin", "isAdmin$annotations", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getAdminPrivileges", "()Ljava/util/List;", "setAdminPrivileges", "(Ljava/util/List;)V", "getAdminPrivileges$annotations", "adminPrivileges", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface t extends vh7.c<t> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "admin_privileges")
    List<Integer> getAdminPrivileges();

    @FieldName(name = "is_admin")
    boolean isAdmin();

    @FieldName(name = "is_muted")
    boolean isMuted();

    @FieldName(name = "is_admin#setter")
    void setAdmin(boolean r1);

    @FieldName(name = "admin_privileges#setter")
    void setAdminPrivileges(List<Integer> r1);

    @FieldName(name = "is_muted#setter")
    void setMuted(boolean r1);
}
