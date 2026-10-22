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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import pea.e;
import pea.f;
import pea.g;
import pea.h;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0001,B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0017J\b\u0010\u001e\u001a\u00020\u001dH\u0017J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lcom/obric/assistant/live/gr/island/island/template/GRExpandedDialogueTemplate;", "Lcom/obric/assistant/live/gr/island/island/entity/ITemplateData;", "iconTextInfo", "Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;", "picInfo", "Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIdentifyPicInfo;", "textButton", "", "Lcom/obric/assistant/live/gr/island/island/entity/ExpandedButtonActionInfo;", "<init>", "(Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIdentifyPicInfo;Ljava/util/List;)V", "getIconTextInfo", "()Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;", "setIconTextInfo", "(Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIconTextInfo;)V", "getPicInfo", "()Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIdentifyPicInfo;", "setPicInfo", "(Lcom/obric/assistant/live/gr/island/island/entity/ExpandedIdentifyPicInfo;)V", "getTextButton", "()Ljava/util/List;", "setTextButton", "(Ljava/util/List;)V", "create", "Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "getActions", "Landroid/os/Bundle;", "getPics", "toJSONObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRExpandedDialogueTemplate implements l {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_assistant:gr_common_expand_template_18";
    private f iconTextInfo;
    private g picInfo;
    private List<e> textButton;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GRExpandedDialogueTemplate copy$default(GRExpandedDialogueTemplate r0, f r1, g r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.iconTextInfo;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.picInfo;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.textButton;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final f component1() {
        return this.iconTextInfo;
    }

    public final g component2() {
        return this.picInfo;
    }

    public final List<e> component3() {
        return this.textButton;
    }

    public final GRExpandedDialogueTemplate copy(f r2, g r3, List<e> r4) {
        Intrinsics.checkNotNullParameter(r2, "iconTextInfo");
        Intrinsics.checkNotNullParameter(r3, "picInfo");
        Intrinsics.checkNotNullParameter(r4, "textButton");
        return new GRExpandedDialogueTemplate(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GRExpandedDialogueTemplate) == true) goto L8;
        return false;
    L8:
        GRExpandedDialogueTemplate r6 = (GRExpandedDialogueTemplate) r5;
        if (Intrinsics.areEqual(this.iconTextInfo, r6.iconTextInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picInfo, r6.picInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textButton, r6.textButton) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.iconTextInfo.hashCode() * 31) + this.picInfo.hashCode()) * 31) + this.textButton.hashCode();
    }

    public String toString() {
        return "GRExpandedDialogueTemplate(iconTextInfo=" + this.iconTextInfo + ", picInfo=" + this.picInfo + ", textButton=" + this.textButton + ')';
    }

    @Override // pea.l
    public Bundle getActions() {
        Bundle r0 = new Bundle();
        Iterator<T> r1 = this.textButton.iterator();
    L4:
        if (r1.hasNext() == false) goto L19;
        e r2 = (e) r1.next();
        Intent r3 = r2.c;
        if (r2.a != 0) goto L4;
        if (o0.d(r2.b) == false) goto L4;
        if (r3 == null) goto L4;
        AppHost.Companion r4 = AppHost.a;
        Context r5 = r4.getApplication().getApplicationContext();
        String r6 = r2.b;
        if (r6 == null) goto L13;
        int r7 = r6.hashCode();
    L14:
        PendingIntent r8 = PendingIntent.getBroadcast(r5, r7, r3, 201326592);
        Integer r9 = r2.m;
        if (r9 == null) goto L17;
        int r10 = r9.intValue();
        Icon r11 = Icon.createWithResource(r4.getApplication().getApplicationContext(), r10);
    L18:
        Notification.Action r12 = new Notification.Action.Builder(r11, r2.e, r8).build();
        r0.putParcelable(r2.b, r12);
        goto L4
    L17:
        r11 = null;
        goto L18
    L13:
        r7 = 0;
        goto L14
    L19:
        return r0;
    }

    @Override // pea.l
    public Bundle getPics() {
        Bundle r0 = new Bundle();
        r0.putParcelable(this.iconTextInfo.g.b, Icon.createWithResource(AppHost.a.getApplication().getApplicationContext(), this.iconTextInfo.g.c));
        return r0;
    }

    @Override // pea.l
    public JSONObject toJSONObject() {
        JSONObject r0 = new JSONObject();
        r0.put("iconTextInfo", this.iconTextInfo.a());
        g r1 = this.picInfo;
        r1.getClass();
        JSONObject r2 = new JSONObject();
        r2.put("type", r1.a);
        String r3 = r1.b;
        if (r3 == null) goto L5;
        r2.put("pic", r3);
    L5:
        Integer r4 = r1.c;
        if (r4 == null) goto L8;
        r2.put("picResId", r4.intValue());
    L8:
        String r5 = r1.d;
        if (r5 == null) goto L11;
        r2.put("picDark", r5);
    L11:
        Integer r6 = r1.e;
        if (r6 == null) goto L14;
        r2.put("picDarkResId", r6.intValue());
    L14:
        h r7 = r1.f;
        if (r7 == null) goto L17;
        r2.put("actionInfo", r7.a());
    L17:
        r0.put("picInfo", r2);
        JSONArray r8 = new JSONArray();
        Iterator<T> r9 = this.textButton.iterator();
    L19:
        if (r9.hasNext() == false) goto L57;
        e r10 = (e) r9.next();
        r10.getClass();
        JSONObject r11 = new JSONObject();
        r11.put("clickWithCollapse", r10.d);
        if (r10.a != 0) goto L23;
        r11.put("action", r10.b);
    L56:
        r8.put(r11);
        goto L19
    L23:
        String r12 = r10.e;
        if (r12 == null) goto L26;
        r11.put("actionTitle", r12);
    L26:
        String r13 = r10.f;
        if (r13 == null) goto L29;
        r11.put("actionTitleColor", r13);
    L29:
        String r14 = r10.g;
        if (r14 == null) goto L32;
        r11.put("actionTitleColorDark", r14);
    L32:
        String r15 = r10.h;
        if (r15 == null) goto L35;
        r11.put("actionBgColor", r15);
    L35:
        String r16 = r10.i;
        if (r16 == null) goto L38;
        r11.put("actionBgColorDark", r16);
    L38:
        String r17 = r10.j;
        if (r17 == null) goto L41;
        r11.put("actionBgPressColor", r17);
    L41:
        String r18 = r10.k;
        if (r18 == null) goto L44;
        r11.put("actionBgPressColorDark", r18);
    L44:
        Intent r19 = r10.c;
        if (r19 == null) goto L49;
        String r20 = r19.toUri(1);
        if (r20 == null) goto L49;
    L50:
        r10.o = r20;
        if (r20 == null) goto L53;
        r11.put("actionIntent", r20);
    L53:
        Integer r21 = r10.n;
        if (r21 == null) goto L56;
        r21.intValue();
        r11.put("actionIntentType", r10.n);
    L49:
        r20 = null;
        goto L50
    L57:
        Unit r22 = Unit.INSTANCE;
        r0.put("textButton", r8);
        return r0;
    }

    public final f getIconTextInfo() {
        return this.iconTextInfo;
    }

    public final g getPicInfo() {
        return this.picInfo;
    }

    public final List<e> getTextButton() {
        return this.textButton;
    }

    @Override // pea.l
    public k create(Boolean r3) {
        return new k(TEMPLATE_ID, this, r3);
    }

    public final void setIconTextInfo(f r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconTextInfo = r2;
    }

    public final void setPicInfo(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.picInfo = r2;
    }

    public final void setTextButton(List<e> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textButton = r2;
    }

    public GRExpandedDialogueTemplate(f r2, g r3, List<e> r4) {
        Intrinsics.checkNotNullParameter(r2, "iconTextInfo");
        Intrinsics.checkNotNullParameter(r3, "picInfo");
        Intrinsics.checkNotNullParameter(r4, "textButton");
        this.iconTextInfo = r2;
        this.picInfo = r3;
        this.textButton = r4;
    }

    public /* synthetic */ GRExpandedDialogueTemplate(f r1, g r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = new g(0);
    L5:
        this(r1, r2, r3);
    }
}
