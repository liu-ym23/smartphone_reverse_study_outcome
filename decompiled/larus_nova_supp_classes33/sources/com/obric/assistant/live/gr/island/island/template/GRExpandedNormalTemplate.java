package com.obric.assistant.live.gr.island.island.template;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.o0;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import pea.f;
import pea.h;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\r\u001a\u00020\u0016H\u0017J\b\u0010\u0017\u001a\u00020\u0016H\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/assistant/live/gr/island/island/template/GRExpandedNormalTemplate;", "Lcom/obric/assistant/live/gr/island/island/entity/ITemplateData;", "iconTextInfo", "Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;", "actions", "", "Lcom/obric/assistant/live/gr/island/island/entity/ExpandedImageTextActionInfo;", "<init>", "(Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;Ljava/util/List;)V", "getIconTextInfo", "()Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;", "setIconTextInfo", "(Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;)V", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "create", "Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "Landroid/os/Bundle;", "getPics", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRExpandedNormalTemplate implements l {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_assistant:gr_common_expand_template_16";
    private List<h> actions;
    private f iconTextInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GRExpandedNormalTemplate copy$default(GRExpandedNormalTemplate r0, f r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.iconTextInfo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.actions;
    L9:
        return r0.copy(r1, r2);
    }

    public final f component1() {
        return this.iconTextInfo;
    }

    public final List<h> component2() {
        return this.actions;
    }

    public final GRExpandedNormalTemplate copy(f r2, List<h> r3) {
        Intrinsics.checkNotNullParameter(r2, "iconTextInfo");
        Intrinsics.checkNotNullParameter(r3, "actions");
        return new GRExpandedNormalTemplate(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GRExpandedNormalTemplate) == true) goto L8;
        return false;
    L8:
        GRExpandedNormalTemplate r6 = (GRExpandedNormalTemplate) r5;
        if (Intrinsics.areEqual(this.iconTextInfo, r6.iconTextInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.iconTextInfo.hashCode() * 31) + this.actions.hashCode();
    }

    public String toString() {
        return "GRExpandedNormalTemplate(iconTextInfo=" + this.iconTextInfo + ", actions=" + this.actions + ')';
    }

    @Override // pea.l
    public Bundle getActions() {
        Bundle r0 = new Bundle();
        Iterator<T> r1 = this.actions.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        h r2 = (h) r1.next();
        Intent r3 = r2.d;
        if (r2.b != 0) goto L4;
        if (o0.d(r2.c) == false) goto L4;
        if (r3 == null) goto L4;
        AppHost.Companion r4 = AppHost.a;
        Context r5 = r4.getApplication().getApplicationContext();
        String r6 = r2.c;
        if (r6 == null) goto L13;
        int r7 = r6.hashCode();
    L14:
        PendingIntent r8 = PendingIntent.getBroadcast(r5, r7, r3, 201326592);
        Notification.Action r9 = new Notification.Action.Builder(Icon.createWithResource(r4.getApplication().getApplicationContext(), r2.g), r2.k, r8).build();
        r0.putParcelable(r2.c, r9);
        goto L4
    L13:
        r7 = 0;
        goto L14
    L15:
        return r0;
    }

    @Override // pea.l
    public Bundle getPics() {
        Bundle r0 = new Bundle();
        r0.putParcelable(this.iconTextInfo.g.b, Icon.createWithResource(AppHost.a.getApplication().getApplicationContext(), this.iconTextInfo.g.c));
        Iterator<T> r1 = this.actions.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        h r2 = (h) r1.next();
        if (r2.b != 1) goto L4;
        String r3 = r2.f;
        AppHost.Companion r4 = AppHost.a;
        r0.putParcelable(r3, Icon.createWithResource(r4.getApplication().getApplicationContext(), r2.g));
        Integer r5 = r2.i;
        if (r5 == null) goto L4;
        int r6 = r5.intValue();
        r0.putParcelable(r2.h, Icon.createWithResource(r4.getApplication().getApplicationContext(), r6));
        goto L4
    L10:
        return r0;
    }

    @Override // pea.l
    public JSONObject toJSONObject() {
        JSONObject r0 = new JSONObject();
        r0.put("iconTextInfo", this.iconTextInfo.a());
        JSONArray r1 = new JSONArray();
        Iterator<T> r2 = this.actions.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.put(((h) r2.next()).a());
        goto L4
    L6:
        Unit r3 = Unit.INSTANCE;
        r0.put("actions", r1);
        return r0;
    }

    public final f getIconTextInfo() {
        return this.iconTextInfo;
    }

    /* JADX INFO: renamed from: getActions, reason: collision with other method in class */
    public final List<h> m6getActions() {
        return this.actions;
    }

    @Override // pea.l
    public k create(Boolean r3) {
        return new k(TEMPLATE_ID, this, r3);
    }

    public final void setActions(List<h> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.actions = r2;
    }

    public final void setIconTextInfo(f r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconTextInfo = r2;
    }

    public GRExpandedNormalTemplate(f r2, List<h> r3) {
        Intrinsics.checkNotNullParameter(r2, "iconTextInfo");
        Intrinsics.checkNotNullParameter(r3, "actions");
        this.iconTextInfo = r2;
        this.actions = r3;
    }
}
