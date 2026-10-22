package tp0;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdk.message.model.ah;
import com.bytedance.android.livesdk.message.model.eh;
import com.bytedance.android.livesdk.message.model.uh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.live.datacontext.n;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends ro0.b<eh> {
    public yo0.b d;
    public final MessageType e;
    public final String f;

    @Override // ro0.b
    public final MessageType a() {
        return this.e;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // ro0.b
    public final void b(d r7) {
        eh r8 = (eh) r7;
        Intrinsics.checkNotNullParameter(r8, MultiLinkOpenSource.MESSAGE);
        JSONArray r0 = new JSONArray();
        Iterator r9 = r8.items.iterator();
    L4:
        if (r9.hasNext() == false) goto L22;
        ah r1 = (ah) r9.next();
        Iterator r2 = r1.userInfo.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        uh r3 = (uh) r2.next();
        String r4 = r3.appId;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r5 = AnchorMiniAppDataContext.a.a();
        if (r5 == null) goto L17;
        n<ShelfInfo> r6 = r5.m618getShelfInfo();
        if (r6 == null) goto L17;
        ShelfInfo r10 = (ShelfInfo) r6.getValue();
        if (r10 == null) goto L17;
        ShelfMicroAppInfo r11 = r10.appInfo;
        if (r11 == null) goto L17;
        String r12 = r11.appId;
    L19:
        if (Intrinsics.areEqual(r4, r12) == false) goto L7;
        JSONObject r13 = new JSONObject();
        r13.put("openUID", r3.openUid);
        r13.put("secNickname", r1.secNickName);
        r13.put("secAvatarURL", r1.secAvatarUrl);
        r13.put("content", r1.content);
        r13.put("timestamp", r1.timestamp);
        Unit r14 = Unit.INSTANCE;
        r0.put(r13);
    L17:
        r12 = null;
        goto L19
    L22:
        if (r0.length() == 0) goto L33;
        yo0.b r15 = this.d;
        if (r15 == null) goto L34;
        String r16 = this.f;
        JSONObject r17 = new JSONObject();
        r17.put("commentList", r0);
        Unit r18 = Unit.INSTANCE;
        r15.a(r16, "onReceiveSpecifiedComment", r17);
        return;
    L34:
        return;
    }

    public a(OpenPlatformContext r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r3, "appId");
        super(r2);
        this.f = r3;
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        this.d = (yo0.b) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.c.get();
        this.e = MessageType.OPEN_GAME_COMMENT_MESSAGE;
    }
}
