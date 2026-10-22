package com.bytedance.lark.lark_bitable_android;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.BaseAppPreloadResource;
import lark_bitable.proto.BitableWorkspaceMoveResult;
import lark_bitable.proto.HomepageDocData;
import lark_bitable.proto.HomepageDocument;
import lark_bitable.proto.HomepageInnerDocExtraData;
import lark_bitable.proto.HomepageListData;
import lark_bitable.proto.HomepageTagConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n0 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[lark_bitable.proto.RecordPermission.values().length];
            r0[lark_bitable.proto.RecordPermission.VAR_RECORD_PERMISSION_READABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L53
        L109:
            r0[lark_bitable.proto.RecordPermission.VAR_RECORD_PERMISSION_EDITABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L54
        L6:
            int[] r1 = new int[lark_bitable.proto.ModelAction.values().length];
            r1[lark_bitable.proto.ModelAction.VAR_MODEL_ACTION_JUMP_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L55
        L135:
            r1[lark_bitable.proto.ModelAction.VAR_MODEL_ACTION_COMMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L56
        L153:
            r1[lark_bitable.proto.ModelAction.VAR_MODEL_ACTION_EDIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L57
        L159:
            r1[lark_bitable.proto.ModelAction.VAR_MODEL_ACTION_VIEW_ATTACHMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L58
        L95:
            r1[lark_bitable.proto.ModelAction.VAR_MODEL_ACTION_CLICK_BUTTON.ordinal()] = 5;     // Catch: NoSuchFieldError -> L59
        L15:
            int[] r10 = new int[lark_bitable.proto.FieldInputType.values().length];
            r10[lark_bitable.proto.FieldInputType.VAR_FIELD_INPUT_TYPE_NO_LIMIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L60
        L121:
            r10[lark_bitable.proto.FieldInputType.VAR_FIELD_INPUT_TYPE_MOBILE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L61
        L18:
            int[] r11 = new int[lark_bitable.proto.ErrorContent.values().length];
            r11[lark_bitable.proto.ErrorContent.VAR_ERROR_CONTENT_NO_PERMISSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L62
        L151:
            r11[lark_bitable.proto.ErrorContent.VAR_ERROR_CONTENT_NO_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L63
        L21:
            int[] r12 = new int[lark_bitable.proto.TabType.values().length];
            r12[lark_bitable.proto.TabType.VAR_TAB_TYPE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L64
        L101:
            r12[lark_bitable.proto.TabType.VAR_TAB_TYPE_STAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L65
        L24:
            int[] r13 = new int[lark_bitable.proto.HomepageListType.values().length];
            r13[lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L66
        L115:
            r13[lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_PIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L67
        L123:
            r13[lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_FAVORITE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L68
        L131:
            r13[lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_WORKSPACE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L69
        L143:
            r13[lark_bitable.proto.HomepageListType.VAR_HOMEPAGE_LIST_TYPE_UNKNOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L70
        L30:
            a = r13;
            int[] r14 = new int[lark_bitable.proto.HomepageAction.values().length];
            r14[lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L71
        L107:
            r14[lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_LOAD_MORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L72
        L119:
            r14[lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L73
        L125:
            r14[lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_CANCEL_FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L74
        L133:
            r14[lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_CANCEL_PIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L75
        L149:
            r14[lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_SHARE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L76
        L157:
            r14[lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_MORE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L77
        L89:
            r14[lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_BITABLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L78
        L97:
            r14[lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_SWITCH_LIST_TYPE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L79
        L117:
            r14[lark_bitable.proto.HomepageAction.VAR_HOMEPAGE_ACTION_OPEN_WORK_SPACE_PANEL.ordinal()] = 10;     // Catch: NoSuchFieldError -> L80
        L41:
            b = r14;
            int[] r15 = new int[lark_bitable.proto.WorkspaceBitableMoveStatus.values().length];
            r15[lark_bitable.proto.WorkspaceBitableMoveStatus.VAR_WORKSPACE_BITABLE_MOVE_STATUS_UNSUPPORTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L81
        L147:
            r15[lark_bitable.proto.WorkspaceBitableMoveStatus.VAR_WORKSPACE_BITABLE_MOVE_STATUS_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L82
        L155:
            r15[lark_bitable.proto.WorkspaceBitableMoveStatus.VAR_WORKSPACE_BITABLE_MOVE_STATUS_FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L83
        L93:
            r15[lark_bitable.proto.WorkspaceBitableMoveStatus.VAR_WORKSPACE_BITABLE_MOVE_STATUS_NOPERMISSION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L84
        L46:
            c = r15;
            int[] r16 = new int[lark_bitable.proto.BaseAppPreloadResourceType.values().length];
            r16[lark_bitable.proto.BaseAppPreloadResourceType.VAR_BASE_APP_PRELOAD_RESOURCE_TYPE_CLIENT_VARS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L85
        L48:
            int[] r17 = new int[lark_bitable.proto.BitableDocumentType.values().length];
            r17[lark_bitable.proto.BitableDocumentType.VAR_BITABLE_DOCUMENT_TYPE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L86
        L137:
            r17[lark_bitable.proto.BitableDocumentType.VAR_BITABLE_DOCUMENT_TYPE_RECORD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L87
        L145:
            r17[lark_bitable.proto.BitableDocumentType.VAR_BITABLE_DOCUMENT_TYPE_ADD_RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L88
            return;
        }
    }

    public static final b a(BaseAppPreloadResource r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        return new b(r12.payload, r12.source, r12.cache_elapsed_time.longValue(), r12.request_start.longValue(), r12.api_code.intValue(), r12.error_msg, r12.xtt_log_id, r12.schema_version.intValue());
    }

    public static final o b(BitableWorkspaceMoveResult r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.token;
        String r12 = r10.msg;
        lark_bitable.proto.WorkspaceBitableMoveStatus r13 = r10.move_result;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        int r14 = a.c[r13.ordinal()];
        if (r14 != 1) goto L5;
        WorkspaceBitableMoveStatus r15 = WorkspaceBitableMoveStatus.Unsupported;
    L17:
        return new o(r11, r12, r15);
    L5:
        if (r14 != 2) goto L7;
        r15 = WorkspaceBitableMoveStatus.Success;
        goto L17
    L7:
        if (r14 != 3) goto L9;
        r15 = WorkspaceBitableMoveStatus.Fail;
        goto L17
    L9:
        if (r14 != 4) goto L12;
        r15 = WorkspaceBitableMoveStatus.Nopermission;
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static final HomepageAction c(lark_bitable.proto.HomepageAction r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(a.b[r1.ordinal()]) {
            case 1: goto L16;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L17:
        return HomepageAction.OpenWorkSpacePanel;
    L18:
        return HomepageAction.SwitchListType;
    L19:
        return HomepageAction.OpenBitable;
    L20:
        return HomepageAction.OpenMore;
    L21:
        return HomepageAction.OpenShare;
    L22:
        return HomepageAction.CancelPin;
    L23:
        return HomepageAction.CancelFavorite;
    L24:
        return HomepageAction.Delete;
    L25:
        return HomepageAction.LoadMore;
    L16:
        return HomepageAction.Refresh;
    }

    public static final i0 d(HomepageListData r85) {
        Intrinsics.checkNotNullParameter(r85, "<this>");
        String r10 = r85.last_label;
        boolean r11 = r85.has_more.booleanValue();
        String r12 = r85.space_token;
        List r13 = r85.doc_data_list;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        HomepageDocData r16 = (HomepageDocData) r15.next();
        Intrinsics.checkNotNull(r16);
        Intrinsics.checkNotNullParameter(r16, "<this>");
        String r17 = r16.token;
        String r18 = r16.icon;
        String r19 = r16.title;
        int r110 = r16.biz_type.intValue();
        int r111 = r16.obj_biz_type.intValue();
        String r20 = r16.obj_token;
        long r112 = r16.open_time.longValue();
        long r113 = r16.star_time.longValue();
        long r21 = r16.create_time.longValue();
        long r22 = r16.edit_time.longValue();
        HomepageTagConfig r23 = r16.tag;
        Intrinsics.checkNotNullParameter(r23, "<this>");
        String r31 = r12;
        boolean r32 = r11;
        String r33 = r10;
        r14.add(new f0(r17, r18, r19, r110, r111, r20, r112, r113, r21, r22, new l0(r23.show_template.booleanValue(), r23.show_external.booleanValue(), r23.show_file_risk_tag.booleanValue()), r16.is_owner.booleanValue(), r16.is_stared.booleanValue(), r16.is_my_library.booleanValue(), r16.wiki_space_name, r16.url));
        r15 = r15;
        r12 = r31;
        r11 = r32;
        r10 = r33;
        goto L4
    L6:
        String r34 = r10;
        boolean r35 = r11;
        String r36 = r12;
        List r0 = r85.raw_data_list;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L11;
        HomepageDocument r25 = (HomepageDocument) r1.next();
        Intrinsics.checkNotNull(r25);
        Intrinsics.checkNotNullParameter(r25, "<this>");
        String r26 = r25.url;
        int r37 = r25.owner_type.intValue();
        String r27 = r25.security_name;
        long r38 = r25.path_count.longValue();
        int r40 = r25.obj_biz_type.intValue();
        String r28 = r25.delete_uid;
        String r29 = r25.token;
        String r30 = r25.obj_token;
        int r44 = r25.r_type.intValue();
        HomepageInnerDocExtraData r39 = r25.extra;
        Intrinsics.checkNotNullParameter(r39, "<this>");
        r24.add(new g0(r26, r37, r27, r38, r40, r28, r29, r30, r44, new h0(r39.icon_key, r39.space_id, r39.is_visited.booleanValue(), r39.has_perm.booleanValue(), r39.copiable.booleanValue(), r39.is_share_root.booleanValue(), r39.icon_encrypted_type.intValue(), r39.icon_nonce, r39.icon, r39.app_id, r39.not_wiki_obj.booleanValue(), r39.template_type.intValue(), r39.wiki_space_id, r39.wiki_space_name, r39.wiki_sub_token, r39.wiki_version, r39.biz_type.longValue(), r39.file_risk_tag.booleanValue(), r39.is_external.booleanValue(), r39.wiki_space_create_uid, r39.wiki_space_type.intValue(), r39.wiki_subtype.intValue(), r39.wiki_homepage, r39.complaint, r39.doc_description), r25.open_time.longValue(), r25.star_time.longValue(), r25.get_sec_label_code.longValue(), r25.can_set_sec_label.longValue(), r25.name, r25.secret_key_delete.booleanValue(), r25.edit_uid, r25.delete_flag.intValue(), r25.icon_info, r25.activity_time.longValue(), r25.edit_time.longValue(), r25.security_label_id, r25.is_stared.booleanValue(), r25.is_pined.booleanValue(), r25.thumbnail, r25.security_level.intValue(), r25.owner_id, r25.create_time.longValue(), r25.my_edit_time.longValue(), r25.sharer_id, r25.is_subscribed.booleanValue(), r25.share_time.longValue(), r25.icon_key, r25.icon_type.intValue(), r25.icon_fsunit, r25.create_tenant_id, r25.create_cn_name, r25.create_en_name, r25.share_cn_name, r25.share_en_name));
        goto L8
    L11:
        return new i0(r34, r35, r36, r14, r24);
    }

    public static final HomepageListType e(lark_bitable.proto.HomepageListType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r10 = a.a[r1.ordinal()];
        if (r10 == 1) goto L19;
        if (r10 == 2) goto L23;
        if (r10 == 3) goto L22;
        if (r10 == 4) goto L21;
        if (r10 != 5) goto L14;
        return HomepageListType.Unknown;
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return HomepageListType.Workspace;
    L22:
        return HomepageListType.Favorite;
    L23:
        return HomepageListType.Pin;
    L19:
        return HomepageListType.Recent;
    }
}
