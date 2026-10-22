package com.ss.android.lark.feed.molten.serializer;

import com.bytedance.lark.pb.basic.v1.AppFeedCardButton;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.feed.app.entity.FeedCardButton;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/FeedCardButtonTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/app/entity/FeedCardButton;", "actionTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/bytedance/lark/pb/basic/v1/AppFeedCardButton$ActionType;", "buttonTypeAdapter", "Lcom/bytedance/lark/pb/basic/v1/AppFeedCardButton$ButtonType;", "<init>", "(Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedCardButtonTypeAdapter extends JsonTreeTypeAdapter<FeedCardButton> {
    public final TypeAdapter<AppFeedCardButton.ActionType> a;
    public final TypeAdapter<AppFeedCardButton.ButtonType> b;

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final FeedCardButton a(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "json");
        AppFeedCardButton.ActionType r0 = (AppFeedCardButton.ActionType) a.k(r10, "actionType", this.a);
        if (r0 != null) goto L7;
        int r1 = g.a;
        Intrinsics.checkNotNullParameter(AppFeedCardButton.ActionType.class, "enumClass");
        r0 = (AppFeedCardButton.ActionType) g.a(AppFeedCardButton.ActionType.class, 0);
        if (r0 != null) goto L7;
        r0 = (AppFeedCardButton.ActionType) a.d(AppFeedCardButton.ActionType.class);
    L7:
        AppFeedCardButton.ActionType r6 = r0;
        AppFeedCardButton.ButtonType r2 = (AppFeedCardButton.ButtonType) a.k(r10, "buttonType", this.b);
        if (r2 != null) goto L12;
        int r3 = g.a;
        Intrinsics.checkNotNullParameter(AppFeedCardButton.ButtonType.class, "enumClass");
        r2 = (AppFeedCardButton.ButtonType) g.a(AppFeedCardButton.ButtonType.class, 0);
        if (r2 != null) goto L12;
        r2 = (AppFeedCardButton.ButtonType) a.d(AppFeedCardButton.ButtonType.class);
    L12:
        AppFeedCardButton.ButtonType r8 = r2;
        String r4 = a.l(r10, "id");
        if (r4 != null) goto L15;
        String r5 = BuildConfig.FLAVOR;
    L16:
        String r7 = a.l(r10, "url");
        if (r7 != null) goto L19;
        String r9 = BuildConfig.FLAVOR;
    L20:
        String r11 = a.l(r10, "text");
        if (r11 != null) goto L23;
        String r12 = BuildConfig.FLAVOR;
    L25:
        return new FeedCardButton(r5, r9, r6, r12, r8);
    L23:
        r12 = r11;
        goto L25
    L19:
        r9 = r7;
        goto L20
    L15:
        r5 = r4;
        goto L16
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(FeedCardButton r5) {
        FeedCardButton r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        JsonObject r0 = new JsonObject();
        a.j(r0, "id", r6.getId());
        a.j(r0, "url", r6.getUrl());
        a.i(r0, "actionType", r6.getActionType(), this.a);
        a.j(r0, "text", r6.getText());
        a.i(r0, "buttonType", r6.getButtonType(), this.b);
        return r0;
    }

    public FeedCardButtonTypeAdapter(WireEnumTypeAdapter r2, WireEnumTypeAdapter r3) {
        Intrinsics.checkNotNullParameter(r2, "actionTypeAdapter");
        Intrinsics.checkNotNullParameter(r3, "buttonTypeAdapter");
        this.a = r2;
        this.b = r3;
    }
}
