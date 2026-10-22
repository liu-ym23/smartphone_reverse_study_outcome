package com.bytedance.android.live.lynx.components;

import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.functions.Consumer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ LiveLynxComponentForSaas a;

    public b(LiveLynxComponentForSaas r1) {
        this.a = r1;
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
    public final void accept(Object r6) {
        FollowPair r7 = (FollowPair) r6;
        LiveLynxComponentForSaas r0 = this.a;
        r0.getClass();
        if (r7 == null) goto L15;
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r1.put("type", "follow");     // Catch: JSONException -> L12
        r2.put("user_id", r7.getUserIdString());     // Catch: JSONException -> L12
        String r4 = r7.getSecUserId();     // Catch: JSONException -> L12
        if (r4 != null) goto L10;
        r4 = null;
    L10:
        r2.put("sec_user_id", r4);     // Catch: JSONException -> L12
        r2.put("follow_status", r7.getFollowStatus());     // Catch: JSONException -> L12
        r1.put("args", r2);     // Catch: JSONException -> L12
        r0.sendJsEvent("H5_userStatusChange", r1);     // Catch: JSONException -> L12
        return;
    L16:
        return;
    }
}
