package y38;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.account.saas.jsb.core.FlowAccountCommonAlertCore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@XBridgeMethod(name = "doubaoAccount.commonAlert", owner = "fengjingzhe")
public final class a extends XCoreIDLBridgeMethod<InterfaceC0136a, b> {

    @XBridgeMethodName(name = "doubaoAccount.commonAlert")
    public final String a;
    public final IDLXBridgeMethod.Access b;

    /* JADX INFO: renamed from: y38.a$a, reason: collision with other inner class name */
    @XBridgeParamModel
    public interface InterfaceC0136a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "actions", required = false)
        List<Map<String, Object>> getActions();

        @XBridgeParamField(isGetter = true, keyPath = "desc", required = false)
        String getDescription();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "id", required = false)
        String getId();

        @XBridgeParamField(isGetter = true, keyPath = "style", required = false)
        Number getStyle();

        @XBridgeParamField(isGetter = true, keyPath = "title", required = false)
        String getTitle();

        @XBridgeParamField(isGetter = false, keyPath = "id", required = false)
        void setId(String r1);

        @XBridgeParamField(isGetter = false, keyPath = "style", required = false)
        void setStyle(Number r1);

        @XBridgeParamField(isGetter = false, keyPath = "title", required = false)
        void setTitle(String r1);
    }

    public a() {
        this.a = "doubaoAccount.commonAlert";
        this.b = IDLXBridgeMethod.Access.PRIVATE;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r9, XBaseParamModel r10, CompletionBlock r11) {
        InterfaceC0136a r12 = (InterfaceC0136a) r10;
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        List<Map<String, Object>> r0 = r12.getActions();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L28;
        Map r3 = (Map) r2.next();
        FlowAccountCommonAlertCore.a r4 = null;
        Integer r5 = null;
        if (r3 == null) goto L26;
        Object r6 = r3.get("id");
        if ((r6 instanceof String) == false) goto L14;
        String r7 = (String) r6;
    L15:
        Object r8 = r3.get("title");
        if ((r8 instanceof String) == false) goto L18;
        String r13 = (String) r8;
    L19:
        Object r14 = r3.get("style");
        if ((r14 instanceof Number) == false) goto L22;
        Number r15 = (Number) r14;
    L23:
        if (r15 == null) goto L25;
        r5 = Integer.valueOf(r15.intValue());
    L25:
        r4 = new FlowAccountCommonAlertCore.a(r7, r13, r5);
        goto L26
    L22:
        r15 = null;
        goto L23
    L18:
        r13 = null;
        goto L19
    L14:
        r7 = null;
    L26:
        if (r4 == null) goto L7;
        r1.add(r4);
        goto L7
    L28:
        int r16 = FlowAccountCommonAlertCore.a;
        FlowAccountCommonAlertCore.a(r9.getOwnerActivity(), r12.getTitle(), r12.getDescription(), r1, new y38.b(r11));
    }
}
