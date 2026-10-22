package com.bytedance.android.live.base.model.data;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/base/model/data/n;", "", "", "Lcom/bytedance/android/live/base/model/data/n$a;", "templateList", "Ljava/util/List;", "", "templatePanelTitle", "Ljava/lang/String;", "photoPanelTitle", "Lpy/k;", "bgPhoto", "Lpy/k;", "<init>", "()V", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n implements vh7.h {

    @SerializedName("bg_photo")
    public py.k bgPhoto;

    @SerializedName("photo_panel_title")
    public String photoPanelTitle;

    @SerializedName("template_list")
    public List<a> templateList;

    @SerializedName("template_panel_title")
    public String templatePanelTitle;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/base/model/data/n$a;", "", "", "templateId", "Ljava/lang/String;", "Lpy/k;", "templatePhoto", "Lpy/k;", "authorName", "templateTitle", "", "supportReplace", "Ljava/lang/Boolean;", "replaceContent", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a implements vh7.h {

        @SerializedName("author_name")
        public String authorName;

        @SerializedName("replace_content")
        public String replaceContent;

        @SerializedName("support_replace")
        public Boolean supportReplace;

        @SerializedName("template_id")
        public String templateId;

        @SerializedName("template_photo")
        public py.k templatePhoto;

        @SerializedName("template_title")
        public String templateTitle;

        public a() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
        public a(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L13;
            switch(r2) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            this.replaceContent = am3.h.c(r5);
            goto L3
        L8:
            this.supportReplace = Boolean.valueOf(am3.h.a(r5));
            goto L3
        L9:
            this.templateTitle = am3.h.c(r5);
            goto L3
        L10:
            this.authorName = am3.h.c(r5);
            goto L3
        L11:
            this.templatePhoto = vh7.f.a(r5, py.k.class);
            goto L3
        L12:
            this.templateId = am3.h.c(r5);
            goto L3
        L6:
            am3.h.e(r5);
            goto L3
        L13:
            r5.d(r0);
        }

        public final String toString() {
            return "TemplateInfo(templateId=" + this.templateId + ", templatePhoto=" + this.templatePhoto + ", authorName=" + this.authorName + ", templateTitle=" + this.templateTitle + ", supportReplace=" + this.supportReplace + ", replaceContent=" + this.replaceContent + ')';
        }
    }

    public n() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public n(am3.g r5) {
        this.templateList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.templateList.add(new a(r5));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.templatePanelTitle = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.photoPanelTitle = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.bgPhoto = vh7.f.a(r5, py.k.class);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }

    public final List<a> a() {
        List<a> r0 = this.templateList;
        if (r0 == null) goto L22;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L29;
        Object r3 = r2.next();
        a r4 = (a) r3;
        py.k r5 = r4.templatePhoto;
        boolean r6 = false;
        if (r5 != null) goto L10;
    L20:
        if (r6 == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        if (r5.isValid() != true) goto L20;
        String r7 = r4.templateId;
        if (r7 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == true) goto L20;
        r6 = true;
        goto L20
    L14:
        if (r7.length() == 0) goto L17;
        r8 = false;
        goto L18
    L29:
        return r1;
    L22:
        return null;
    }

    public final String toString() {
        return "TemplatePhotoJumpDetail(templateList=" + this.templateList + ", templatePanelTitle=" + this.templatePanelTitle + ", photoPanelTitle=" + this.photoPanelTitle + ", bgPhoto=" + this.bgPhoto + ')';
    }
}
