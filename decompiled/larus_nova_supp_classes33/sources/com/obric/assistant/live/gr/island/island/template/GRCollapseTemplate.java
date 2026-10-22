package com.obric.assistant.live.gr.island.island.template;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pea.b;
import pea.c;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0017J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lcom/obric/assistant/live/gr/island/island/template/GRCollapseTemplate;", "Lcom/obric/assistant/live/gr/island/island/entity/ITemplateData;", "imageTextInfoLeft", "Lcom/obric/assistant/live/gr/island/island/entity/BigIslandImageTextInfo;", "picInfo", "Lcom/obric/assistant/live/gr/island/island/entity/CollapseIslandPicInfo;", "textInfo", "Lcom/obric/assistant/live/gr/island/island/entity/BigIsLandTextInfo;", "<init>", "(Lcom/obric/assistant/live/gr/island/island/entity/BigIslandImageTextInfo;Lcom/obric/assistant/live/gr/island/island/entity/CollapseIslandPicInfo;Lcom/obric/assistant/live/gr/island/island/entity/BigIsLandTextInfo;)V", "getImageTextInfoLeft", "()Lcom/obric/assistant/live/gr/island/island/entity/BigIslandImageTextInfo;", "setImageTextInfoLeft", "(Lcom/obric/assistant/live/gr/island/island/entity/BigIslandImageTextInfo;)V", "getPicInfo", "()Lcom/obric/assistant/live/gr/island/island/entity/CollapseIslandPicInfo;", "setPicInfo", "(Lcom/obric/assistant/live/gr/island/island/entity/CollapseIslandPicInfo;)V", "getTextInfo", "()Lcom/obric/assistant/live/gr/island/island/entity/BigIsLandTextInfo;", "setTextInfo", "(Lcom/obric/assistant/live/gr/island/island/entity/BigIsLandTextInfo;)V", "create", "Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/assistant/live/gr/island/island/entity/GRIslandWidget;", "toJSONObject", "Lorg/json/JSONObject;", "getActions", "Landroid/os/Bundle;", "getPics", "getIconFromPicInfo", "Landroid/graphics/drawable/Icon;", "component1", "component2", "component3", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRCollapseTemplate implements l {
    public static final a Companion = null;
    private static final String TAG = "GRCollapseTemplate";
    private static final String TEMPLATE_ID_2 = "com.obric.island_assistant:gr_common_collapse_template2";
    private static final String TEMPLATE_ID_8 = "com.obric.island_assistant:gr_common_collapse_template8";
    private b imageTextInfoLeft;
    private c picInfo;
    private pea.a textInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ GRCollapseTemplate copy$default(GRCollapseTemplate r0, b r1, c r2, pea.a r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.imageTextInfoLeft;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.picInfo;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.textInfo;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final b component1() {
        return this.imageTextInfoLeft;
    }

    public final c component2() {
        return this.picInfo;
    }

    public final pea.a component3() {
        return this.textInfo;
    }

    public final GRCollapseTemplate copy(b r2, c r3, pea.a r4) {
        Intrinsics.checkNotNullParameter(r2, "imageTextInfoLeft");
        return new GRCollapseTemplate(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GRCollapseTemplate) == true) goto L8;
        return false;
    L8:
        GRCollapseTemplate r6 = (GRCollapseTemplate) r5;
        if (Intrinsics.areEqual(this.imageTextInfoLeft, r6.imageTextInfoLeft) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picInfo, r6.picInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textInfo, r6.textInfo) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.imageTextInfoLeft.hashCode() * 31;
        c r1 = this.picInfo;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        pea.a r5 = this.textInfo;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "GRCollapseTemplate(imageTextInfoLeft=" + this.imageTextInfoLeft + ", picInfo=" + this.picInfo + ", textInfo=" + this.textInfo + ')';
    }

    @Override // pea.l
    public Bundle getActions() {
        return new Bundle();
    }

    @Override // pea.l
    public Bundle getPics() {
        Bundle r0 = new Bundle();
        c r1 = this.imageTextInfoLeft.b;
        if (r1 == null) goto L5;
        r0.putParcelable(r1.b, Icon.createWithResource(AppHost.a.getApplication().getApplicationContext(), r1.c));
        FLogger.a.d(TAG, "getPics: left picInfo " + r1);
    L5:
        c r2 = this.picInfo;
        if (r2 == null) goto L11;
        Icon r3 = getIconFromPicInfo(r2);
        if (r3 == null) goto L10;
        r0.putParcelable(r2.b, r3);
    L10:
        FLogger.a.d(TAG, "getPics: right picInfo " + r2);
    L11:
        return r0;
    }

    @Override // pea.l
    public JSONObject toJSONObject() {
        JSONObject r0 = new JSONObject();
        b r1 = this.imageTextInfoLeft;
        r1.getClass();
        JSONObject r2 = new JSONObject();
        r2.put("type", r1.a);
        c r3 = r1.b;
        if (r3 == null) goto L5;
        r2.put("picInfo", r3.a());
    L5:
        pea.a r4 = r1.c;
        if (r4 == null) goto L8;
        r2.put("textInfo", r4.a());
    L8:
        r0.put("imageTextInfoLeft", r2);
        c r5 = this.picInfo;
        if (r5 == null) goto L11;
        r0.put("picInfo", r5.a());
    L11:
        pea.a r6 = this.textInfo;
        if (r6 == null) goto L14;
        r0.put("textInfo", r6.a());
    L14:
        return r0;
    }

    public final b getImageTextInfoLeft() {
        return this.imageTextInfoLeft;
    }

    public final c getPicInfo() {
        return this.picInfo;
    }

    public final pea.a getTextInfo() {
        return this.textInfo;
    }

    private final Icon getIconFromPicInfo(c r6) {
        String r0 = r6.d;
        if (r0 == null) goto L17;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        Object r2 = Result.constructor-impl(Icon.createWithResource(r0, r6.c));     // Catch: Throwable -> L6
    L9:
        if (Result.exceptionOrNull-impl(r2) == null) goto L12;
        FLogger.a.e(TAG, "getIconFromPicInfo: createWithResource failed, packageName:" + r0 + ", picResId:" + r6.c);
    L12:
        if (Result.isFailure-impl(r2) == false) goto L15;
        r2 = null;
    L15:
        return (Icon) r2;
    L6:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L17:
        return Icon.createWithResource(AppHost.a.getApplication().getApplicationContext(), r6.c);
    }

    @Override // pea.l
    public k create(Boolean r3) {
        if (this.picInfo == null) goto L5;
        String r1 = TEMPLATE_ID_8;
    L7:
        return new k(r1, this, r3);
    L5:
        r1 = TEMPLATE_ID_2;
        goto L7
    }

    public final void setImageTextInfoLeft(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.imageTextInfoLeft = r2;
    }

    public final void setPicInfo(c r1) {
        this.picInfo = r1;
    }

    public final void setTextInfo(pea.a r1) {
        this.textInfo = r1;
    }

    public GRCollapseTemplate(b r2, c r3, pea.a r4) {
        Intrinsics.checkNotNullParameter(r2, "imageTextInfoLeft");
        this.imageTextInfoLeft = r2;
        this.picInfo = r3;
        this.textInfo = r4;
    }

    public /* synthetic */ GRCollapseTemplate(b r2, c r3, pea.a r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this(r2, r3, r4);
    }
}
