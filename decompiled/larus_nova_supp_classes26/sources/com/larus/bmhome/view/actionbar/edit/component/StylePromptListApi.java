package com.larus.bmhome.view.actionbar.edit.component;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.annotations.SerializedName;
import com.larus.network.bean.BizResponse;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u000b2\u00020\u0001:\u0004\b\t\n\u000bJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/StylePromptListApi;", "", "getStylePromptList", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/view/actionbar/edit/component/StylePromptListApi$GetStylePromptListData;", "request", "Lcom/larus/bmhome/view/actionbar/edit/component/StylePromptListApi$GetStylePromptListRequest;", "(Lcom/larus/bmhome/view/actionbar/edit/component/StylePromptListApi$GetStylePromptListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GetStylePromptListRequest", "GetStylePromptListData", "StylePromptInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface StylePromptListApi {
    public static final a a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/StylePromptListApi$GetStylePromptListData;", "Ljava/io/Serializable;", "promptList", "", "Lcom/larus/bmhome/view/actionbar/edit/component/StylePromptListApi$StylePromptInfo;", "<init>", "(Ljava/util/List;)V", "getPromptList", "()Ljava/util/List;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetStylePromptListData implements Serializable {

        @SerializedName("prompt_list")
        private final List<StylePromptInfo> promptList;

        public GetStylePromptListData() {
            List r0 = null;
            this(r0, 1, r0);
        }

        public final List<StylePromptInfo> getPromptList() {
            return this.promptList;
        }

        public GetStylePromptListData(List<StylePromptInfo> r1) {
            this.promptList = r1;
        }

        public /* synthetic */ GetStylePromptListData(List r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/StylePromptListApi$StylePromptInfo;", "Ljava/io/Serializable;", "id", "", "displayText", "", "messageText", "replyMessageFormat", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDisplayText", "()Ljava/lang/String;", "getMessageText", "getReplyMessageFormat", "screenMessageText", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StylePromptInfo implements Serializable {

        @SerializedName("display_text")
        private final String displayText;

        @SerializedName("id")
        private final Long id;

        @SerializedName("message_text")
        private final String messageText;

        @SerializedName("reply_message_format")
        private final String replyMessageFormat;

        public StylePromptInfo() {
            this(null, null, null, null, 15, null);
        }

        public final String screenMessageText() {
            String r0 = this.replyMessageFormat;
            String r1 = null;
            if (r0 != null) goto L5;
        L9:
            String r2 = this.messageText;
            if (r2 != null) goto L12;
        L14:
            if (r1 != null) goto L19;
            String r3 = this.displayText;
            if (r3 != null) goto L21;
            return "";
        L21:
            return r3;
        L19:
            return r1;
        L12:
            if ((!StringsKt.isBlank(r2)) == false) goto L14;
            r1 = r2;
            goto L14
        L5:
            if ((!StringsKt.isBlank(r0)) == true) goto L8;
            r0 = null;
        L8:
            if (r0 == null) goto L9;
            return r0;
        }

        public final String getDisplayText() {
            return this.displayText;
        }

        public final Long getId() {
            return this.id;
        }

        public final String getMessageText() {
            return this.messageText;
        }

        public final String getReplyMessageFormat() {
            return this.replyMessageFormat;
        }

        public StylePromptInfo(Long r1, String r2, String r3, String r4) {
            this.id = r1;
            this.displayText = r2;
            this.messageText = r3;
            this.replyMessageFormat = r4;
        }

        public /* synthetic */ StylePromptInfo(Long r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = "";
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = "";
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = "";
        L14:
            this(r2, r3, r4, r5);
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/StylePromptListApi$GetStylePromptListRequest;", "", "languageCode", "", "<init>", "(Ljava/lang/String;)V", "getLanguageCode", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("language_code")
        private final String languageCode;

        public b() {
            this(null);
        }

        public b(String r1) {
            this.languageCode = r1;
        }
    }

    static {
        a = a.a;
    }

    @POST("/creativity/image_style/get_prompt_list")
    Object getStylePromptList(@Body b r1, Continuation<? super BizResponse<GetStylePromptListData>> r2);
}
