package com.ss.android.lark.pb.errors;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.lark.profile.v2.entity.BaseField;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ErrorCode extends Enum<ErrorCode> implements WireEnum {
    private static final /* synthetic */ ErrorCode[] $VALUES = null;
    public static final ErrorCode ACCESS_FILE_AUTH_NO_PASS = null;
    public static final ErrorCode ACCOUNT_FORBIDDEN = null;
    public static final ErrorCode ACCOUNT_LOGOUT_ERROR = null;
    public static final ProtoAdapter<ErrorCode> ADAPTER = null;
    public static final ErrorCode ADD_CHAT_CHATTER_APPLY_ALREADY_PROCESSED = null;
    public static final ErrorCode ADD_CHAT_CHATTER_APPLY_NOT_OPEN = null;
    public static final ErrorCode ADD_FRIENDS_TIMEOUT_VIA_CONTACT = null;
    public static final ErrorCode ADD_FRIEND_ERR_FOR_CHAT_MANNER_CLOSED = null;
    public static final ErrorCode ADD_FRIEND_ERR_FOR_FRIEND_NOT_IN_CHAT = null;
    public static final ErrorCode ADD_FRIEND_ERR_FOR_SEARCH_MANNER_CLOSED = null;
    public static final ErrorCode AI_KNOWLEDGE_AI_PRODUCTIVITY_REPORT_NO_PERMISSION = null;
    public static final ErrorCode AI_KNOWLEDGE_AI_PRODUCTIVITY_REPORT_RECORD_NOT_FOUND = null;
    public static final ErrorCode AI_KNOWLEDGE_AI_TOPIC_IS_DELETED = null;
    public static final ErrorCode AI_KNOWLEDGE_ANSWER_INTERNAL = null;
    public static final ErrorCode AI_KNOWLEDGE_ANSWER_TNS_INPUT = null;
    public static final ErrorCode AI_KNOWLEDGE_ANSWER_TNS_OUTPUT = null;
    public static final ErrorCode AI_KNOWLEDGE_ANSWER_UNAVAILABLE = null;
    public static final ErrorCode AI_KNOWLEDGE_CANT_VIEW_WIKI_QA_REDIRECT = null;
    public static final ErrorCode AI_KNOWLEDGE_CHECK_DISCOUNT_CODE_OVER_LIMIT = null;
    public static final ErrorCode AI_KNOWLEDGE_CONVERT_TO_QUERY_ERROR = null;
    public static final ErrorCode AI_KNOWLEDGE_DISCOUNT_CODE_INVALID = null;
    public static final ErrorCode AI_KNOWLEDGE_DISCOUNT_CODE_IS_USED = null;
    public static final ErrorCode AI_KNOWLEDGE_FEATURE_DISCONTINUED = null;
    public static final ErrorCode AI_KNOWLEDGE_GEN_DISCOUNT_CODE_OVER_LIMIT = null;
    public static final ErrorCode AI_KNOWLEDGE_IMAGE_TNS_INPUT = null;
    public static final ErrorCode AI_KNOWLEDGE_JOIN_WIKI_SPACE_NEED_PAID = null;
    public static final ErrorCode AI_KNOWLEDGE_MANAGER_CANNOT_QUIT_WIKI = null;
    public static final ErrorCode AI_KNOWLEDGE_MISSING_DISCOUNT_CODE = null;
    public static final ErrorCode AI_KNOWLEDGE_NEED_JOIN_WIKI = null;
    public static final ErrorCode AI_KNOWLEDGE_NEED_LOGIN = null;
    public static final ErrorCode AI_KNOWLEDGE_NEED_UPGRADE_VERSION = null;
    public static final ErrorCode AI_KNOWLEDGE_NOT_SUPER_ADMIN = null;
    public static final ErrorCode AI_KNOWLEDGE_NO_SEND_HONG_BAO_PERMISSION = null;
    public static final ErrorCode AI_KNOWLEDGE_NO_WIKI_OPERATOR_PERMISSION = null;
    public static final ErrorCode AI_KNOWLEDGE_NO_WIKI_ORDER_OPERATOR_PERMISSION = null;
    public static final ErrorCode AI_KNOWLEDGE_NO_WIKI_VIEW_PERMISSION = null;
    public static final ErrorCode AI_KNOWLEDGE_PULL_ANSWER_CACHE_EMPTY = null;
    public static final ErrorCode AI_KNOWLEDGE_REFUND_IS_REQUIRED_BEFORE_DELETION = null;
    public static final ErrorCode AI_KNOWLEDGE_REMAINING_TRIAL_COUNT_IS_ZERO = null;
    public static final ErrorCode AI_KNOWLEDGE_SCHEDULE_TASK_DUPLICATED = null;
    public static final ErrorCode AI_KNOWLEDGE_SCHEDULE_TASK_NOT_EXIST = null;
    public static final ErrorCode AI_KNOWLEDGE_SCHEDULE_TASK_OVER_LIMITED = null;
    public static final ErrorCode AI_KNOWLEDGE_SEARCH_DEPARTMENT_LIMIT_EXCEED = null;
    public static final ErrorCode AI_KNOWLEDGE_SHARE_IMAGE_EXCEED_LENGTH_LIMIT = null;
    public static final ErrorCode AI_KNOWLEDGE_SHARE_IMAGE_INVALID_URL = null;
    public static final ErrorCode AI_KNOWLEDGE_SHARE_IMAGE_TIME_OUT = null;
    public static final ErrorCode AI_KNOWLEDGE_SHARE_LINK_DISABLE = null;
    public static final ErrorCode AI_KNOWLEDGE_USER_CREATE_WIKI_OVER_LIMIT = null;
    public static final ErrorCode AI_KNOWLEDGE_USER_JOINED_WIKI_OVER_LIMIT = null;
    public static final ErrorCode AI_KNOWLEDGE_USER_MANAGED_WIKI_OVER_LIMIT = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_ACCOUNT_NOT_ENOUGH = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_ASK_TOO_OFTEN = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_DISCOUNT_CODE_NOT_MATCH = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_DISCOUNT_OVER_LIMIT = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_INFO_CONTAINS_SENSITIVE_WORDS = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_IS_PRIVATE = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_NOT_EXISTS = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_NOT_RELEASE = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_ORDER_CREATING = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_ORDER_SALE_INFO_ERROR = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_ORDER_STATE_REFRESH = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_ORG_ADMIN_RESTRICT_PERM_TOAST = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_SUB_MERCHANT_OUT_OF_LIMIT = null;
    public static final ErrorCode AI_KNOWLEDGE_WIKI_USER_NO_NEED_CREATE_ORDER = null;
    public static final ErrorCode AI_KNOWLEDGE_WORK_SPACE_NODE_HAS_BEEN_DELETED = null;
    public static final ErrorCode AI_KNOWLEDGE_WORK_SPACE_NODE_NOT_EXISTS = null;
    public static final ErrorCode AI_KNOWLEDGE_WORK_SPACE_NODE_NUM_OVER_LIMIT = null;
    public static final ErrorCode ALL_URGENT_USERS_ARE_MANAGERS = null;
    public static final ErrorCode ALREADY_IN_CHAT = null;
    public static final ErrorCode ANALYZE_SHEET_EMPTY_FILE = null;
    public static final ErrorCode ANALYZE_SHEET_FAIL = null;
    public static final ErrorCode ANALYZE_SHEET_NO_EDIT_PERM = null;
    public static final ErrorCode ANALYZE_SHEET_REACH_CHAT_CHATTER_COUNT_LIMIT = null;
    public static final ErrorCode APPLICATION_REASON_EXCEED_LIMIT = null;
    public static final ErrorCode AUTH_MESSAGE_FAILED_RETRY = null;
    public static final ErrorCode AUTH_OWNER_OR_ADMIN_BLOCKED = null;
    public static final ErrorCode AUTH_SYSTEM_BANNER_BLOCKED = null;
    public static final ErrorCode AUTH_USER_NOT_IN_CHAT = null;
    public static final ErrorCode BLOCK_BY_SHARK = null;
    public static final ErrorCode BLOCK_BY_STRANGER_RELATION = null;
    public static final ErrorCode CAIJING_ACCOUNT_NEED_UPGRADE = null;
    public static final ErrorCode CANNOT_ADD_OR_LEAVE_IN_TEAM_CHAT = null;
    public static final ErrorCode CANNOT_RESOLVE_TEAM_DEFAULT_CHAT = null;
    public static final ErrorCode CANNOT_SHARE_TEAM_CHAT = null;
    public static final ErrorCode CANNOT_TRANSFER_TEAM_DEFAULT_CHAT_OWNER = null;
    public static final ErrorCode CANT_ADD_CONTACT_BE_BLOCKED = null;
    public static final ErrorCode CANT_ADD_CONTACT_BLOCK_OTHER = null;
    public static final ErrorCode CERT_TENANT_ADD_CHAT_CHATTER_REACH_LIMIT = null;
    public static final ErrorCode CHAT_ADMIN_USER_REACH_LIMIT = null;
    public static final ErrorCode CHAT_BANNED_BY_TNS = null;
    public static final ErrorCode CHAT_BOT_COUNT_GT_LIMIT = null;
    public static final ErrorCode CHAT_CROSS_WITH_KA_UNSUPPORTED_MESSAGE_TYPE = null;
    public static final ErrorCode CHAT_DESC_TOO_LONG = null;
    public static final ErrorCode CHAT_IS_BIND_ANOTHER_TEAM = null;
    public static final ErrorCode CHAT_IS_FROZEN = null;
    public static final ErrorCode CHAT_LINK_INVITER_NOT_IN_CHAT = null;
    public static final ErrorCode CHAT_NAME_TRANSLATE_FAILED = null;
    public static final ErrorCode CHAT_NOT_FOUND = null;
    public static final ErrorCode CHAT_NOT_FOUND_V2 = null;
    public static final ErrorCode CHAT_PIN_NUM_REACH_LIMIT = null;
    public static final ErrorCode CHAT_SECURITY_CHECK_BLOCK = null;
    public static final ErrorCode CHAT_USER_COUNT_GT_LIMIT = null;
    public static final ErrorCode CHAT_USER_OVER_LIMIT_NEED_APPLY = null;
    public static final ErrorCode CHAT_WITH_NO_CONTACTS_REACH_DAILY_LIMIT = null;
    public static final ErrorCode COLLABORATION_AUTH_FAILED_BE_BLOCKED = null;
    public static final ErrorCode COLLABORATION_AUTH_FAILED_BLOCKED = null;
    public static final ErrorCode COLLABORATION_AUTH_FAILED_CAN_APPLY = null;
    public static final ErrorCode COLLABORATION_AUTH_FAILED_NO_RIGHTS = null;
    public static final ErrorCode COLLABORATION_AUTH_FAILED_PRIVACY_SETTING = null;
    public static final ErrorCode COLLABORATION_AUTH_FAILED_TARGET_PRIVACY_SETTING = null;
    public static final ErrorCode COLLABORATION_AUTH_NO_PERMISSION = null;
    public static final ErrorCode COLLABORATION_AUTH_P2P_BOT_SEND_MESSAGE_FAILED = null;
    public static final ErrorCode COLLABORATION_AUTH_P2P_SEND_MESSAGE_FAILED = null;
    public static final ErrorCode COLLABORATION_NO_SEND_MESSAGE_TO_MY_AI = null;
    public static final ErrorCode COLLABORATION_SEND_MSG_REACH_LIMIT = null;
    public static final ErrorCode CONTACT_IN_SAME_TENANT = null;
    public static final ErrorCode CONTACT_NUM_EXCEED_LIMIT = null;
    public static final ErrorCode CONTACT_REQUEST_SENT_PLEASE_WAIT = null;
    public static final ErrorCode COPY_MESSAGE_AUTHED_ID_NIL = null;
    public static final ErrorCode COPY_MESSAGE_EXCEED_RESOURCE = null;
    public static final ErrorCode CREATE_ANONYMOUS_MESSAGE_NO_MORE_QUOTA = null;
    public static final ErrorCode CREATE_ANONYMOUS_MESSAGE_SETTING_CLOSE = null;
    public static final ErrorCode CREATE_GROUP_CHAT_TRIGGER_LIMITER = null;
    public static final ErrorCode CREATE_MESSAGE_AT_ALL_DENIED = null;
    public static final ErrorCode CREATE_MESSAGE_AT_USER_GROUP_DENIED = null;
    public static final ErrorCode CREATE_MESSAGE_BLOCK_IN_THREAD_DISPLAY_MODE = null;
    public static final ErrorCode CREATE_MESSAGE_GENERATION_SHARE_CARD_FAILURE = null;
    public static final ErrorCode CREATE_MESSAGE_INVALID_CARD_CONTENT = null;
    public static final ErrorCode CREATE_MESSAGE_INVALID_SHARED_GROUP_CHAT = null;
    public static final ErrorCode CREATE_MESSAGE_INVALID_USER_CARD = null;
    public static final ErrorCode CREATE_MESSAGE_MYAI_UNSUPPORTED_LOW_VERSION = null;
    public static final ErrorCode CREATE_MESSAGE_REQUEST_IS_PROCESSING = null;
    public static final ErrorCode CREATE_MESSAGE_SHARE_USER_CARD_NO_FRIENDSHIP = null;
    public static final ErrorCode CREATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT = null;
    public static final ErrorCode CREATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT_ENQUEUE = null;
    public static final ErrorCode CREATE_MESSAGE_TRIGGER_CONTAINER_LIMIT = null;
    public static final ErrorCode CREATE_MESSAGE_TRIGGER_PSM_RATE_LIMIT = null;
    public static final ErrorCode CREATE_MESSAGE_TRIGGER_USER_RATE_LIMIT = null;
    public static final ErrorCode CREATE_MESSAGE_WITH_SOURCE_BOT_NO_PERMISSION = null;
    public static final ErrorCode CREATE_MESSAGE_WITH_SOURCE_CONTENT_INVALID = null;
    public static final ErrorCode CREATE_MESSAGE_WITH_SOURCE_NO_SCOPE = null;
    public static final ErrorCode CREATE_MESSAGE_WITH_SOURCE_OWNERID_INVALID = null;
    public static final ErrorCode CREATE_MESSAGE_WITH_SOURCE_PARAM_INCOMPLETE = null;
    public static final ErrorCode CREATE_MESSAGE_WITH_SOURCE_TICKET_INVALID = null;
    public static final ErrorCode CREATE_MESSAGE_WITH_SOURCE_UNSUPPORTED_CRYPTO_MESSAGE = null;
    public static final ErrorCode CREATE_REPLY_IN_THREAD_CHAT_UNSUPPORTED = null;
    public static final ErrorCode CREATE_REPLY_IN_THREAD_FOLD_MESSAGE_UNSUPPORTED = null;
    public static final ErrorCode CREATE_REPLY_IN_THREAD_ROOT_MESSAGE_RECALLED = null;
    public static final ErrorCode CREATE_REPLY_IN_THREAD_SYSTEM_MESSAGE_UNSUPPORTED = null;
    public static final ErrorCode CREATE_TEAM_REACH_LIMIT = null;
    public static final ErrorCode CROSS_TENANT_CHAT_USER_OVER_LIMIT_NEED_APPLY = null;
    public static final ErrorCode CROSS_WITH_KA_CANT_SEE_PROFILE = null;
    public static final ErrorCode CROSS_WITH_KA_CHAT_SETTINGS_UNAVAILABLE = null;
    public static final ErrorCode CROSS_WITH_KA_FEATURE_UNAVAILABLE = null;
    public static final ErrorCode CROSS_WITH_KA_MESSAGE_ACTIONS_UNAVAILABLE = null;
    public static final ErrorCode CROSS_WITH_KA_UNABLE_TO_CREATE_GROUP_CHAT = null;
    public static final ErrorCode CROSS_WITH_KA_UNABLE_TO_FORWARD_MESSAGE = null;
    public static final ErrorCode CROSS_WITH_KA_UNABLE_TO_INVITE_GROUP_MEMBER = null;
    public static final ErrorCode CROSS_WITH_KA_UNABLE_TO_REMOVE_MEMBER = null;
    public static final ErrorCode CROSS_WITH_KA_UNABLE_TO_SEND_MESSAGE = null;
    public static final ErrorCode CRYPTO_CHAT_UNSUPPORTED_ADD_BOTS = null;
    public static final ErrorCode CURRENT_CHAT_NOT_CAN_SET_SEARCH = null;
    public static final ErrorCode DATA_EXPORT_ATTACHMENG_ID_ERROR = null;
    public static final ErrorCode DATA_EXPORT_CHAT_TTP_GEO_BLOCKED = null;
    public static final ErrorCode DATA_EXPORT_CREATE_TASK_CONFLICT = null;
    public static final ErrorCode DATA_EXPORT_EXECUTE_TASK_TIMEOUT = null;
    public static final ErrorCode DATA_EXPORT_INVALID_ATTACHMENT_INFO = null;
    public static final ErrorCode DATA_EXPORT_NO_MESSAGE_MATCH_KEYWORDS = null;
    public static final ErrorCode DATA_EXPORT_REACH_GLOBAL_TASK_LIMIT = null;
    public static final ErrorCode DATA_EXPORT_REACH_TENANT_TASK_LIMIT = null;
    public static final ErrorCode DATA_EXPORT_REQUEST_PARAM_ERROR = null;
    public static final ErrorCode DATA_EXPORT_TASK_ALREADY_EXIST = null;
    public static final ErrorCode DATA_EXPORT_TASK_NOT_FOUND = null;
    public static final ErrorCode DATA_EXPORT_TASK_TERMINATED = null;
    public static final ErrorCode DATA_EXPORT_USER_TTP_GEO_BLOCKED = null;
    public static final ErrorCode DEEP_COPY_EXCEED_LIMIT = null;
    public static final ErrorCode DEEP_COPY_NO_VALID_MESSAGE = null;
    public static final ErrorCode DEFAULT_NAMECARD_ERROR = null;
    public static final ErrorCode DELETED_NAMECARD = null;
    public static final ErrorCode DELETE_THREAD_PERMISSION_EXPIRED = null;
    public static final ErrorCode DEVICE_IN_LEAN_MODE_CANNOT_USE_CRYPTO_CHAT = null;
    public static final ErrorCode DEVICE_NOT_HAVE_LEAN_MODE_AUTHORITY = null;
    public static final ErrorCode DLP_SENSITIVE_MESSAGE_BLOCKED = null;
    public static final ErrorCode DOUBAO_CHAT_NOT_SUPPORTED = null;
    public static final ErrorCode EDIT_MESSAGE_DELETED = null;
    public static final ErrorCode EDIT_MESSAGE_DLP_REVIEW_FAIL = null;
    public static final ErrorCode EDIT_MESSAGE_IS_CRYPTO = null;
    public static final ErrorCode EDIT_MESSAGE_IS_ENCRYPT = null;
    public static final ErrorCode EDIT_MESSAGE_IS_ILLEGAL = null;
    public static final ErrorCode EDIT_MESSAGE_NOT_IN_VALID_TIME = null;
    public static final ErrorCode EDIT_MESSAGE_NOT_VISIBLE = null;
    public static final ErrorCode EDIT_MESSAGE_OVER_TIMES = null;
    public static final ErrorCode EDIT_MESSAGE_RECALLED = null;
    public static final ErrorCode EDIT_MESSAGE_SENSITIVE_WORDS_REVIEW_FAIL = null;
    public static final ErrorCode EDIT_MESSAGE_SUBMIT_FOR_REVIEW_FAIL = null;
    public static final ErrorCode EDIT_MESSAGE_USERID_NOT_SAME_FROM_REQUEST = null;
    public static final ErrorCode EDIT_MESSAGE_USER_CAN_NOT_SEND_MESSAGE = null;
    public static final ErrorCode EDIT_MESSAGE_USER_NOT_IN_MESSAGE_CHAT = null;
    public static final ErrorCode EDU_CLASS_INVALID = null;
    public static final ErrorCode EDU_HOME_SCHOOL_CHAT_CREATED = null;
    public static final ErrorCode EDU_INVITATION_SEND_MESSAGE_FREQUENCY = null;
    public static final ErrorCode EDU_NOT_AUTHORIZED = null;
    public static final ErrorCode EDU_UNKNOWN_SYSTEM_ERROR = null;
    public static final ErrorCode EMAIL_DUPLICATE = null;
    public static final ErrorCode EMAIL_INVALID = null;
    public static final ErrorCode EM_AUTH_FAILED = null;
    public static final ErrorCode EM_GET_DATA_FAILED = null;
    public static final ErrorCode EM_REDUNDANT_TASK = null;
    public static final ErrorCode EM_TASK_ALREADY_DONE = null;
    public static final ErrorCode EXPIRE_CLEANED_MESSAGE_NOT_SUPPORT_UPDATE = null;
    public static final ErrorCode EXTERNAL_COORDINATE_CTL = null;
    public static final ErrorCode FEED_GROUP_NAME_DUPLICATE_ERROR = null;
    public static final ErrorCode FG_KA_CROSS_SEND_MESSAGE_FORBID = null;
    public static final ErrorCode FILEINFO_IS_DELETED = null;
    public static final ErrorCode FORBIDDEN_EXIT_DEPARTMENT_CHAT = null;
    public static final ErrorCode FORBID_ADD_FRIEND_FOR_USER_PRIVATE_SETTING = null;
    public static final ErrorCode FORBID_ADD_LINK_DISABLE = null;
    public static final ErrorCode FORBID_ADD_MEMBER_FOR_NOT_IN_CHAT = null;
    public static final ErrorCode FORBID_ADD_MEMBER_TO_P2P_CHAT = null;
    public static final ErrorCode FORBID_ADD_NAME_CARD_DISABLE = null;
    public static final ErrorCode FORBID_ADD_OUT_TENANT_USER = null;
    public static final ErrorCode FORBID_ADD_OUT_TENANT_USER_V2 = null;
    public static final ErrorCode FORBID_ADD_SEARCH_DISABLE = null;
    public static final ErrorCode FORBID_ADD_TEAM_MEMBERS = null;
    public static final ErrorCode FORBID_BIND_TEAM_CHAT = null;
    public static final ErrorCode FORBID_CHAT_SETTING_IN_TEAM = null;
    public static final ErrorCode FORBID_CREATE_CHAT_FOR_NOT_FRIEND = null;
    public static final ErrorCode FORBID_CREATE_CHAT_FOR_USER_RESIGNED = null;
    public static final ErrorCode FORBID_CREATE_CRYPTO_CHAT_OR_ADD_CHATTER = null;
    public static final ErrorCode FORBID_CREATE_TEAM_CHAT = null;
    public static final ErrorCode FORBID_DELETE_USER_IN_MEETING = null;
    public static final ErrorCode FORBID_DEL_MEMBER_FOR_NOT_IN_CHAT = null;
    public static final ErrorCode FORBID_DISABLE_SHARED_CHAT = null;
    public static final ErrorCode FORBID_DISSOLVED_CHAT_DURING_MEETING = null;
    public static final ErrorCode FORBID_FORWARD_MESSAGE_IN_RESTRICTED_MODE = null;
    public static final ErrorCode FORBID_LARK_ASSISTANT_QUIT_CUSTOM_CHAT = null;
    public static final ErrorCode FORBID_MODIFY_ARCHIVED_CHAT_NAME = null;
    public static final ErrorCode FORBID_MODIFY_CHAT_NAME_FOR_NOT_IN_CHAT = null;
    public static final ErrorCode FORBID_OPERATE_CHAT_IN_TEAM = null;
    public static final ErrorCode FORBID_PULL_CHAT_MEMBERS_FOR_NOT_IN_CHAT = null;
    public static final ErrorCode FORBID_PULL_CHAT_THREAD_FOR_NOT_IN_CHAT = null;
    public static final ErrorCode FORBID_PULL_MESSAGES_FOR_NOT_IN_CHAT = null;
    public static final ErrorCode FORBID_PULL_THREAD_MESSAGE_FOR_NOT_IN_CHAT = null;
    public static final ErrorCode FORBID_PUT_P2P_CHAT = null;
    public static final ErrorCode FORBID_PUT_P2P_CHATS = null;
    public static final ErrorCode FORBID_PUT_URGENT = null;
    public static final ErrorCode FORBID_QUIT_YOUR_CUSTOM_CHAT = null;
    public static final ErrorCode FORBID_SELECT_EXTERNAL_CONTACTS = null;
    public static final ErrorCode FORBID_SELECT_NOT_OWN_CHAT = null;
    public static final ErrorCode FORBID_SEND_MESSAGE_FOR_CHAT_DELETED_OR_ARCHIVED = null;
    public static final ErrorCode FORBID_SEND_MESSAGE_FOR_NOT_FRIEND = null;
    public static final ErrorCode FORBID_SEND_MESSAGE_IN_CHAT = null;
    public static final ErrorCode FORBID_SET_AVATAR = null;
    public static final ErrorCode FORBID_SET_NAME = null;
    public static final ErrorCode FORBID_TRANSMIT_ONE_AUDIO_MESSAGE = null;
    public static final ErrorCode FORBID_WITHDRAW_GROUP_OWNER = null;
    public static final ErrorCode FORWARD_NO_PERMISSION_TRANSMIT_HISTORY_MESSAGE = null;
    public static final ErrorCode FORWARD_NO_VALID_TARGET = null;
    public static final ErrorCode FORWARD_TO_THREAD_CHAT_THREAD_MISMATCH = null;
    public static final ErrorCode GATEWAY_AUTH_APP_TOKEN_NOT_FOUND = null;
    public static final ErrorCode GATEWAY_AUTH_BAD_REQUEST = null;
    public static final ErrorCode GATEWAY_AUTH_INVALID_TICKET = null;
    public static final ErrorCode GATEWAY_AUTH_SESSION_DEVICE_MISMATCH = null;
    public static final ErrorCode GATEWAY_AUTH_SESSION_INCONSISTENT_WITH_PACKET_USER = null;
    public static final ErrorCode GATEWAY_AUTH_SESSION_NOT_FOUND = null;
    public static final ErrorCode GET_CHAT_CHATTERS_FAIL = null;
    public static final ErrorCode GET_MESSAGE_POSITION_BY_TIMESTAMP_NUMBER_OF_CHAT_EXCEED_LIMIT = null;
    public static final ErrorCode GET_MESSAGE_POSITION_BY_TIMESTAMP_PARAMS_ERROR = null;
    public static final ErrorCode GROUP_CHAT_DISSOLVED = null;
    public static final ErrorCode GROUP_CHAT_SHARED_CARD_EXPIRED = null;
    public static final ErrorCode HONGBAO_ALREADY_GRAB = null;
    public static final ErrorCode HONGBAO_CANNOT_GRAB = null;
    public static final ErrorCode HONGBAO_EXPIRED = null;
    public static final ErrorCode HONGBAO_GRAB_TOO_FAST = null;
    public static final ErrorCode HONGBAO_INVALID_CHAT = null;
    public static final ErrorCode HONGBAO_INVALID_QUERY = null;
    public static final ErrorCode HONGBAO_INVALID_USER = null;
    public static final ErrorCode HONGBAO_LICENSE_AUTH_FAILED = null;
    public static final ErrorCode HONGBAO_PARAM_ERROR = null;
    public static final ErrorCode HONGBAO_USER_NEED_AUTONYM = null;
    public static final ErrorCode HONGBAO_ZERO_LEFT = null;
    public static final ErrorCode HOTSPOT_CHAT_LIMITED = null;
    public static final ErrorCode HOTSPOT_CHAT_LIMITED_FOR_REPORT = null;
    public static final ErrorCode ILLEGAL_REQUEST_ERROR = null;
    public static final ErrorCode IM_DEPARTMENT_STORAGE_QUOTA_LIMIT = null;
    public static final ErrorCode IM_FILE_API_NOT_AVAILABLE = null;
    public static final ErrorCode IM_FILE_API_QPS_LIMIT = null;
    public static final ErrorCode IM_FILE_DATA_RETENTION = null;
    public static final ErrorCode IM_FILE_DELETE_BY_CSAM = null;
    public static final ErrorCode IM_FILE_PARAM_NOT_SUPPORT = null;
    public static final ErrorCode IM_STORAGE_CAPACITY_LIMIT = null;
    public static final ErrorCode IM_STORAGE_DELETED_BY_ADMIN = null;
    public static final ErrorCode IM_STORAGE_DESTROY_BY_ADMIN = null;
    public static final ErrorCode IM_STORAGE_DESTROY_BY_OWN = null;
    public static final ErrorCode IM_TENANT_STORAGE_QUOTA_LIMIT = null;
    public static final ErrorCode IM_USER_STORAGE_QUOTA_LIMIT = null;
    public static final ErrorCode INVALID_CHAT_LINK_TOKEN = null;
    public static final ErrorCode INVALID_CHAT_TYPE = null;
    public static final ErrorCode INVALID_CIPHER_FAILED_TO_ACCESS_FILE = null;
    public static final ErrorCode INVALID_CIPHER_FAILED_TO_OPERATE_MESSAGE = null;
    public static final ErrorCode INVALID_CIPHER_FAILED_TO_SEND_MESSAGE = null;
    public static final ErrorCode INVALID_CIPHER_FAILED_TO_UPLOAD_FILE = null;
    public static final ErrorCode INVALID_CONTACT_TOKEN = null;
    public static final ErrorCode INVALID_FACE_TO_FACE_TOKEN = null;
    public static final ErrorCode INVALID_MAIL = null;
    public static final ErrorCode INVALID_PHONE_FORMAT = null;
    public static final ErrorCode INVALID_QR_CODE = null;
    public static final ErrorCode INVALID_THREAD_ID = null;
    public static final ErrorCode INVALID_USER_NAME_LENGTH = null;
    public static final ErrorCode INVITEE_MOBILE_MARKED_MALICIOUS = null;
    public static final ErrorCode JOIN_TOKEN_NOT_SET = null;
    public static final ErrorCode LAN_TRANS_AUTH_AUTH_CHAT_FAILED = null;
    public static final ErrorCode LAN_TRANS_AUTH_FAILED = null;
    public static final ErrorCode LAN_TRANS_AUTH_FEATURE_NOT_ALLOWED = null;
    public static final ErrorCode LAN_TRANS_AUTH_ONLINE_DEVICES_NOT_FOUND = null;
    public static final ErrorCode LAN_TRANS_AUTH_PASS = null;
    public static final ErrorCode LARKTODO_REACH_LIMIT_ERROR = null;
    public static final ErrorCode LARKTODO_TASK_LIST_NOT_BLAND = null;
    public static final ErrorCode LARKTODO_TASK_LIST_PROCESSING = null;
    public static final ErrorCode LARKTODO_TODO_EDITTED = null;
    public static final ErrorCode LARKTODO_TODO_NOT_FOUND_ERROR = null;
    public static final ErrorCode LARK_ACCOUNT_ID_NOT_MATCH_DOC = null;
    public static final ErrorCode LARK_APP_NEED_UPGRADE = null;
    public static final ErrorCode LARK_CERTIFICATE_DECRYPTION_KEY_INVALID = null;
    public static final ErrorCode LARK_FAV_LAN_TRANS_FILE_REFUSE = null;
    public static final ErrorCode LARK_IM_MESSAGERE_STRICTED_UNABLE = null;
    public static final ErrorCode LINK_ADD_NON_CERTIFIED_TENANT_REFUSE = null;
    public static final ErrorCode LOCK_CHAT_FAILED = null;
    public static final ErrorCode Lark_IM_ExportMsgToDocs_ALL_MSG_IS_RESTRICTED = null;
    public static final ErrorCode Lark_IM_ExportMsgToDocs_CCM_FAIL = null;
    public static final ErrorCode Lark_IM_ExportMsgToDocs_CHAT_CAN_NOT_Export = null;
    public static final ErrorCode Lark_IM_ExportMsgToDocs_DisabledDueToRestrictSharing_Toast = null;
    public static final ErrorCode Lark_IM_ExportMsgToDocs_DisabledDueToRestrictedMode_Toast = null;
    public static final ErrorCode Lark_IM_ExportMsgToDocs_EMPTY_PARAM = null;
    public static final ErrorCode Lark_IM_ExportMsgToDocs_ExportFail_Toast = null;
    public static final ErrorCode Lark_IM_ExportMsgToDocs_WRONG_PARAM = null;
    public static final ErrorCode MAIL_ADD_CHANGE_IS_PROCESSING = null;
    public static final ErrorCode MAIL_ADD_CHANGE_NO_IMPLEMENTED = null;
    public static final ErrorCode MAIL_ADD_CHANGE_OUT_OF_SYNC = null;
    public static final ErrorCode MAIL_AI_ACTION_ID_INVALID = null;
    public static final ErrorCode MAIL_AI_PUSH_ONBOARDING_CARD_LAST_MSG_ID_NOT_FOUND = null;
    public static final ErrorCode MAIL_AI_PUSH_ONBOARDING_CARD_VERSION_OVERDUE = null;
    public static final ErrorCode MAIL_BASIC_EMAIl_PERMISSION_DISABLE = null;
    public static final ErrorCode MAIL_COMMON_DB_ERROR = null;
    public static final ErrorCode MAIL_COMMON_PARAM_INVALID = null;
    public static final ErrorCode MAIL_COMMON_RPC_FAIL = null;
    public static final ErrorCode MAIL_DEDUPLICATE_DELETE = null;
    public static final ErrorCode MAIL_FEED_FOLLOWEE_NOT_EXISTS = null;
    public static final ErrorCode MAIL_FEED_NOT_EXTERNAL_ADDRESS = null;
    public static final ErrorCode MAIL_FORBID_MODIFY_MAIL_TITLE = null;
    public static final ErrorCode MAIL_GROUP_CHAT_AUTH_PERMISSION_DENIED = null;
    public static final ErrorCode MAIL_GROUP_CHAT_TENANT_DOMAIN_NOT_VALID = null;
    public static final ErrorCode MAIL_GROUP_CHAT_TENANT_PERMISSION_DENIED = null;
    public static final ErrorCode MAIL_GROUP_CHAT_TYPE_PERMISSION_DENIED = null;
    public static final ErrorCode MAIL_GROUP_MANAGEMENT_PERMISSION_DENIED = null;
    public static final ErrorCode MAIL_GROUP_NOT_FOUND = null;
    public static final ErrorCode MAIL_GROUP_UNSUBSCRIBE_DENIED = null;
    public static final ErrorCode MAIL_GROUP_UNSUBSCRIBE_TYPE_UNSUPPORTED = null;
    public static final ErrorCode MAIL_GROUP_VIEW_PERMISSION_DENIED = null;
    public static final ErrorCode MAIL_IMAGE_NO_PERMISSION = null;
    public static final ErrorCode MAIL_LONG_RUNNING_TASK_BLOCK = null;
    public static final ErrorCode MAIL_LONG_RUNNING_TASK_BLOCK_NO_RETRY = null;
    public static final ErrorCode MAIL_LONG_RUNNING_TASK_MIGRATION_REJECT = null;
    public static final ErrorCode MAIL_LONG_RUNNING_TASK_SERVER_LIMIT = null;
    public static final ErrorCode MAIL_MAIL_STATE_ILLEGAL = null;
    public static final ErrorCode MAIL_MESSAGE_HAS_BEEN_RECALLED = null;
    public static final ErrorCode MAIL_MESSAGE_NOT_EXIST = null;
    public static final ErrorCode MAIL_MESSAGE_NOT_IN_SENT_STATE = null;
    public static final ErrorCode MAIL_MESSAGE_SENT_LONG_TIME_AGO = null;
    public static final ErrorCode MAIL_NAME_CARD_INVALID_OPERATE_USER = null;
    public static final ErrorCode MAIL_NOT_IN_MAIL_GROUP = null;
    public static final ErrorCode MAIL_NOT_VALID_ADDRESS = null;
    public static final ErrorCode MAIL_NO_DRIVE_PERMISSION = null;
    public static final ErrorCode MAIL_OVER_LIMIT_COUNT = null;
    public static final ErrorCode MAIL_READ_STATISTICS_RESULT_NOT_READY = null;
    public static final ErrorCode MAIL_REQUEST_PARAMS_LENGTH_LIMIT = null;
    public static final ErrorCode MAIL_SEARCH_BAD_REQUEST = null;
    public static final ErrorCode MAIL_SEND_READ_RECEIPT_DEDUPLICATE = null;
    public static final ErrorCode MAIL_SIGNATURE_INVALID_OPERATE_USER = null;
    public static final ErrorCode MAIL_SIGNATURE_NAME_DUPLICATE = null;
    public static final ErrorCode MAIL_TEMPLATE_BATCH_SIZE_LIMIT = null;
    public static final ErrorCode MAIL_TEMPLATE_CONTENT_SIZE_LIMIT = null;
    public static final ErrorCode MAIL_TEMPLATE_INVALID_TEMPLATE_ID = null;
    public static final ErrorCode MAIL_TEMPLATE_INVALID_TEMPLATE_NAME = null;
    public static final ErrorCode MAIL_TEMPLATE_OTHER_PARAM_ERROR = null;
    public static final ErrorCode MAIL_TEMPLATE_TEMPLATE_NUMBER_LIMIT = null;
    public static final ErrorCode MAIL_TEMPLATE_TOTAL_SIZE_LIMIT = null;
    public static final ErrorCode MAIL_UPLOAD_EML_GET_LOCK_FAIL = null;
    public static final ErrorCode MAIL_UPLOAD_EML_SIZE_TOO_LARGE = null;
    public static final ErrorCode MAIL_USER_ALLOW_BLOCK_DATA_INVALID = null;
    public static final ErrorCode MAIL_USER_ALLOW_BLOCK_SELF_ADDRESS = null;
    public static final ErrorCode MAIL_USER_ALLOW_BLOCK_SELF_DOMAIN = null;
    public static final ErrorCode MAIL_USER_ID_COMMAND_PROCESSED_LIMIT = null;
    public static final ErrorCode MAIL_USER_ID_DEVICE_ID_PROCESSED_LIMIT = null;
    public static final ErrorCode MEMORY_UNREAD_SUMMARY_NO_PERMISSION = null;
    public static final ErrorCode MEMORY_UNREAD_SUMMARY_OVER_LIMIT = null;
    public static final ErrorCode MERGE_FORWARD_CONTENT_REACH_LIMIT = null;
    public static final ErrorCode MERGE_FORWARD_CONTENT_TWO_LARGE_FAIL = null;
    public static final ErrorCode MERGE_FORWARD_MESSAGE_SOURCE_INVALID = null;
    public static final ErrorCode MESSAGE_CHANNEL_NOT_FOUND = null;
    public static final ErrorCode MESSAGE_CONTENT_TOO_LONG = null;
    public static final ErrorCode MESSAGE_COULD_NOT_SEND_ENCRYPTMSG = null;
    public static final ErrorCode MESSAGE_CROSS_KA_CHAT_UNSUPPORTED_MESSAGE_TYPE = null;
    public static final ErrorCode MESSAGE_DISABLE_ACTION_FOR_RESTRICTED_MODE_BURNED = null;
    public static final ErrorCode MESSAGE_DLP_FAILED_TO_DOWNLOAD_FILE_DENY = null;
    public static final ErrorCode MESSAGE_DLP_FAILED_TO_DOWNLOAD_FILE_DETECTING = null;
    public static final ErrorCode MESSAGE_DLP_FAILED_TO_DOWNLOAD_ORIGIN_IMAGE_DENY = null;
    public static final ErrorCode MESSAGE_DLP_FAILED_TO_DOWNLOAD_ORIGIN_IMAGE_DETECTING = null;
    public static final ErrorCode MESSAGE_DLP_FAILED_TO_PIN_MESSAGE = null;
    public static final ErrorCode MESSAGE_DLP_FAILED_TO_PREVIEW_FILE_DENY = null;
    public static final ErrorCode MESSAGE_DLP_FAILED_TO_PULL_MESSAGE_LINK = null;
    public static final ErrorCode MESSAGE_DLP_FAILED_TO_PUT_CHAT_TOP_NOTICE = null;
    public static final ErrorCode MESSAGE_DLP_FAILED_TO_PUT_STICKERS = null;
    public static final ErrorCode MESSAGE_DLP_FAILED_TO_SEND_MESSAGE = null;
    public static final ErrorCode MESSAGE_IS_CLEANED = null;
    public static final ErrorCode MESSAGE_NOT_FOUND = null;
    public static final ErrorCode MESSAGE_RESTRICTED_MODE_IS_BURNED = null;
    public static final ErrorCode MESSAGE_RESTRICTED_MODE_WILL_BURNED = null;
    public static final ErrorCode MESSAGE_SHARK_RISK_CONTROL_BLOCKED = null;
    public static final ErrorCode MESSAGE_TENANT_PUSH_BUSINESS_NOT_SUPPORT = null;
    public static final ErrorCode MESSAGE_TENANT_PUSH_DUPLICATE_REQUEST = null;
    public static final ErrorCode MESSAGE_THREAD_NOT_FOUND = null;
    public static final ErrorCode MOMENTS_BAD_USER_ID = null;
    public static final ErrorCode MOMENTS_CANNOT_CREATE_COMMENT = null;
    public static final ErrorCode MOMENTS_CANNOT_CREATE_POST = null;
    public static final ErrorCode MOMENTS_CANNOT_EDIT_COMMENT = null;
    public static final ErrorCode MOMENTS_CANNOT_EDIT_POST = null;
    public static final ErrorCode MOMENTS_CANNOT_READ = null;
    public static final ErrorCode MOMENTS_CANNOT_SHARE_KEEP_POST = null;
    public static final ErrorCode MOMENTS_CANNOT_SHARE_POST_NOT_AVAILABLE = null;
    public static final ErrorCode MOMENTS_CONTENT_ERROR = null;
    public static final ErrorCode MOMENTS_DUPLICATE_NICKNAME = null;
    public static final ErrorCode MOMENTS_NO_OFFICIAL_USER_PERMISSION = null;
    public static final ErrorCode MOMENTS_PARAM_ERROR = null;
    public static final ErrorCode MOMENTS_PERMISSION_ERROR = null;
    public static final ErrorCode MOMENTS_PIN_COMMENT_FAILED = null;
    public static final ErrorCode MOMENTS_PIN_POST_FAILED = null;
    public static final ErrorCode MOMENTS_REACH_LIMIT_ERROR = null;
    public static final ErrorCode MOMENTS_SESSION_ERROR = null;
    public static final ErrorCode MOMENTS_SET_RISK_WARNING_FAILED = null;
    public static final ErrorCode MOMENTS_SET_SELF_VISIBLE_FAILED = null;
    public static final ErrorCode MOMENTS_STOPPED_FEATURE = null;
    public static final ErrorCode MOMENTS_UNKNOWN_ERROR = null;
    public static final ErrorCode MYAI_CHAT_MESSAGE_NOT_SUPPORT_OPERATION = null;
    public static final ErrorCode MY_AI_ALREADY_INIT_SUCCESS = null;
    public static final ErrorCode MY_AI_PLUGIN_SELECTION_EXPIRED = null;
    public static final ErrorCode MY_AI_QUICK_ACTION_EXPIRED = null;
    public static final ErrorCode MY_AI_SCENE_ALREADY_ADDED = null;
    public static final ErrorCode My_AI_ALREADY_NEW_TOPIC = null;
    public static final ErrorCode NAME_NIL = null;
    public static final ErrorCode NAVIGATION_CUSTOM_APP_BEYOND_LIMIT = null;
    public static final ErrorCode NAVIGATION_CUSTOM_APP_NOT_UNIQUE = null;
    public static final ErrorCode NAVIGATION_GET_APP_INFO_FAIL = null;
    public static final ErrorCode NAVIGATION_GET_ORDER_FAIL = null;
    public static final ErrorCode NAVIGATION_GET_TENANT_ORDER_FAIL = null;
    public static final ErrorCode NAVIGATION_REQ_VERSION_NOT_LATEST = null;
    public static final ErrorCode NAVIGATION_SAVE_ORDER_FAIL = null;
    public static final ErrorCode NAVIGATION_TENANT_ID_NOT_VALID = null;
    public static final ErrorCode NAVIGATION_UNIQUE_ID_DUPLICATE = null;
    public static final ErrorCode NAVIGATION_USER_ID_NOT_VALID = null;
    public static final ErrorCode NEED_UPGRADE_FOR_APPLY_CHECK = null;
    public static final ErrorCode NEW_CONTACT_EXCEED_LIMIT = null;
    public static final ErrorCode NEW_TEAM_OWNER_NOT_SET = null;
    public static final ErrorCode NOT_IN_SAME_TENANT = null;
    public static final ErrorCode NOT_LATEST_LEAN_MODE_CONFIG = null;
    public static final ErrorCode NO_CHAT_ID_FOR_ADD_FRIEND = null;
    public static final ErrorCode NO_DEVICE_FOR_CRYPTO_MESSAGE_CONTENT = null;
    public static final ErrorCode NO_DEVICE_WHEN_CREATE_P2P_CHAT = null;
    public static final ErrorCode NO_FILE_SHARE_PERM = null;
    public static final ErrorCode NO_PERMISSION = null;
    public static final ErrorCode NO_PERMISSION_EDITING_DOC_FOR_OLD_VERSION = null;
    public static final ErrorCode NO_PERMISSION_TRANSMIT_TO_THIRD_PARTY_ENCRYTE_CHAT = null;
    public static final ErrorCode NO_PERMISSION_USE_OTHER_TENANT_EMOJI = null;
    public static final ErrorCode NO_PERM_THREAD_ID = null;
    public static final ErrorCode NO_RIGHT_CANDIDATE_OWNER = null;
    public static final ErrorCode OAUTH_INVALID_CHANNEL = null;
    public static final ErrorCode OAUTH_INVALID_CODE = null;
    public static final ErrorCode OAUTH_INVALID_STATE = null;
    public static final ErrorCode OAUTH_NOT_AUTHORIZED = null;
    public static final ErrorCode OAUTH_SERVER_ERROR = null;
    public static final ErrorCode ONE_BY_ONE_FORWARD_MESSAGE_MAX_REACHED = null;
    public static final ErrorCode ONLY_GROUP_CHAT_ALLOW_MODIFY_NAME = null;
    public static final ErrorCode ONLY_OWNER_CAN_INVITE_OTHERS = null;
    public static final ErrorCode OPERATE_MESSAGE_NOT_FROM_SAME_CHAT = null;
    public static final ErrorCode OPERATION_TOO_FREQUENTLY = null;
    public static final ErrorCode OPERATION_TO_PENDING_DELETE_FEED = null;
    public static final ErrorCode OWNER_CLOSE_GROUP_CHAT_SHARED = null;
    public static final ErrorCode OnTimeDelGlobalSwitchIsOff = null;
    public static final ErrorCode P2P_CHAT_NOT_CONTAIN_CREATOR_NOT = null;
    public static final ErrorCode P2P_CHAT_USER_COUNT_GT_TWO = null;
    public static final ErrorCode PARAM_ERR = null;
    public static final ErrorCode PARTIAL_URGENT_USERS_ARE_MANAGERS = null;
    public static final ErrorCode PB_PACKET_UNMARSHAL_ERR = null;
    public static final ErrorCode PB_PAYLOAD_UNMARSHAL_ERR = null;
    public static final ErrorCode PHONE_DUPLICATE = null;
    public static final ErrorCode PHONE_INVALID = null;
    public static final ErrorCode PIN_LAN_FILE_MESSAGE_FAILED_WHILE_TRANSFERRING = null;
    public static final ErrorCode PIN_OPERATION_PERMISSION_DENIED = null;
    public static final ErrorCode PLEASE_WAIT_GENERAL = null;
    public static final ErrorCode PLEASE_WAIT_MULTIPLE_USERS = null;
    public static final ErrorCode PRICING_PACKAGE = null;
    public static final ErrorCode PRICING_PACKAGE_ADD_CHAT_CHATTER_REACH_LIMIT = null;
    public static final ErrorCode PRICING_PACKAGE_AUTO_TRANSLATE_DISALLOWED = null;
    public static final ErrorCode PRICING_PACKAGE_CRYPTO_CHAT_DISALLOWED = null;
    public static final ErrorCode PRICING_PACKAGE_CRYPTO_CHAT_URGENT_DISALLOWED = null;
    public static final ErrorCode PRICING_PACKAGE_URGENT_REACH_LIMIT = null;
    public static final ErrorCode PROFILE_TOKEN_STOLEN = null;
    public static final ErrorCode PUBLIC_CHAT_NAMED_EXISTED = null;
    public static final ErrorCode PULL_GROUP_CHAT_MEMBER_VERSION_RETRY = null;
    public static final ErrorCode PULL_MESSAGE_FAIL_FOR_NOT_IN_CHAT = null;
    public static final ErrorCode PUT_MERGE_FORWARD_MESSAGE_TYPE_INVALID = null;
    public static final ErrorCode PUT_OTHER_TENANT_REACTION = null;
    public static final ErrorCode PUT_SHORTCUTS_FAILED = null;
    public static final ErrorCode PUT_TRANSMIT_MESSAGE_TYPE_INVALID = null;
    public static final ErrorCode QR_CODE_ADD_NON_CERTIFIED_TENANT_REFUSE = null;
    public static final ErrorCode QR_CODE_INVITER_NOT_IN_CHAT = null;
    public static final ErrorCode RECOGNITION_WITH_EMPTY_RESULT = null;
    public static final ErrorCode REMOVE_LAN_FILE_MESSAGE_FAILED_WHILE_TRANSFERRING = null;
    public static final ErrorCode REPEATED_PUT_CHAT_CHATTER_REQUEST = null;
    public static final ErrorCode REQUEST_OVER_FREQUENCY = null;
    public static final ErrorCode RESET_CONTACT_TOKEN_TOO_FAST = null;
    public static final ErrorCode RESTRICTED_MESSAGE_ALREADY_CLOSE = null;
    public static final ErrorCode RESTRICTED_MESSAGE_ALREADY_OPEN = null;
    public static final ErrorCode RESTRICTED_MESSAGE_FAILED_TO_CLOSE = null;
    public static final ErrorCode RESTRICTED_MESSAGE_FAILED_TO_OPEN = null;
    public static final ErrorCode RESTRICTED_MESSAGE_FORBID_CLOSE_SWITCH = null;
    public static final ErrorCode RESTRICTED_MESSAGE_FORBID_FORWARD_MESSAGE = null;
    public static final ErrorCode RESTRICTED_MESSAGE_FORBID_OPEN_SWITCH = null;
    public static final ErrorCode RESTRICTED_MESSAGE_FORBID_PUT_LINK = null;
    public static final ErrorCode RESTRICTED_MESSAGE_NOT_SUPPORT_SCENE = null;
    public static final ErrorCode RETENTION_BATCH_DELETE_CHAT_NOT_SUPPORT = null;
    public static final ErrorCode RETENTION_BATCH_DELETE_NOT_SUPPORT_MESSAGE_ACTION = null;
    public static final ErrorCode RETENTION_BATCH_DELETE_NO_MESSAGE_NEED_DELETE = null;
    public static final ErrorCode SAFETY_CHECK_FORBIDDEN_DOWNLOAD = null;
    public static final ErrorCode SAME_CHAT_NAME_IN_TEAM = null;
    public static final ErrorCode SAME_TEAM_NAME_IN_TENANT = null;
    public static final ErrorCode SCHEDULE_MESSAGE_CHAT_PENDING_COUNT_OVER_LIMIT = null;
    public static final ErrorCode SCHEDULE_MESSAGE_ENTITY_PENDING_COUNT_OVER_LIMIT = null;
    public static final ErrorCode SCHEDULE_MESSAGE_FAILED_TO_CREATE = null;
    public static final ErrorCode SCHEDULE_MESSAGE_FAILED_TO_SEND_BY_USER_RESIGN = null;
    public static final ErrorCode SCHEDULE_MESSAGE_FAILED_TO_UPDATE = null;
    public static final ErrorCode SEND_MISSING_CRYPTO_MESSAGE_MISSING_CONTENT = null;
    public static final ErrorCode SEND_MISSING_CRYPTO_MESSAGE_MISSING_MAIN_CONTENT = null;
    public static final ErrorCode SENSITIVE_MESSAGE_BLOCKED = null;
    public static final ErrorCode SENSITIVE_USER_NAME = null;
    public static final ErrorCode SHARE_CARD_ADD_NON_CERTIFIED_TENANT_REFUSE = null;
    public static final ErrorCode SHARE_CHAT_DEPRECATED = null;
    public static final ErrorCode SHARE_CHAT_FORBID = null;
    public static final ErrorCode SID_NOT_IN_FRONTIER_DOWNGRADE_PIPE = null;
    public static final ErrorCode SPECIAL_PROTECT_CHAT_TRIGGER_LIMITER = null;
    public static final ErrorCode STATIC_RESOURCE_API_HARDLINK_FAILED = null;
    public static final ErrorCode STATIC_RESOURCE_API_HARDLINK_Key_EXCEED_LIMIT = null;
    public static final ErrorCode STATIC_RESOURCE_COMPRESSED_FOLDER_GONE = null;
    public static final ErrorCode STATIC_RESOURCE_DELETED_BY_ADMIN = null;
    public static final ErrorCode STATIC_RESOURCE_DOWNLOAD_LAN_FILE_FROM_SERVER = null;
    public static final ErrorCode STATIC_RESOURCE_DOWNLOAD_RISKY_NAME = null;
    public static final ErrorCode STATIC_RESOURCE_FOLDER_DEPTH_EXCEED_LIMIT = null;
    public static final ErrorCode STATIC_RESOURCE_FOLDER_SUB_FILES_NUMBER_EXCEED_LIMIT = null;
    public static final ErrorCode STATIC_RESOURCE_FROZEN_BY_ADMIN = null;
    public static final ErrorCode STATIC_RESOURCE_IMAGE_OCR_FAILED = null;
    public static final ErrorCode STATIC_RESOURCE_INVALID_COMPRESS_ALGORITHM = null;
    public static final ErrorCode STATIC_RESOURCE_NOT_EXIST = null;
    public static final ErrorCode STATIC_RESOURCE_SHREDDED_BY_ADMIN = null;
    public static final ErrorCode STATIC_RESOURCE_UNCOMPRESS_DEPTH_EXCEED_LIMIT = null;
    public static final ErrorCode STATIC_RESOURCE_UNCOMPRESS_NOT_ALLOW = null;
    public static final ErrorCode STATIC_RESOURCE_UNCOMPRESS_SIZE_EXCEED_LIMIT = null;
    public static final ErrorCode STATIC_RESOURCE_UNCOMPRESS_SUB_FILES_NUMBER_EXCEED_LIMIT = null;
    public static final ErrorCode STATIC_RESOURCE_UNCOMPRESS_UNABLE = null;
    public static final ErrorCode STATIC_RESOURCE_UNCOMPRESS_UNSUPPORT_FORMAT = null;
    public static final ErrorCode STATIC_RESOURCE_UPLOAD_FOLDER_EMPTY = null;
    public static final ErrorCode STATIC_RESOURCE_UPLOAD_NOT_COMPLETE = null;
    public static final ErrorCode STATIC_RESOURCE_UPLOAD_RISKY_NAME = null;
    public static final ErrorCode STICKER_SET_ALREADY_EXISTS = null;
    public static final ErrorCode STOPPED_FEATURE_DEPRECATED = null;
    public static final ErrorCode STOPPED_FEATURE_NEED_UPGRADE = null;
    public static final ErrorCode SUPER_CHAT_THREAD_SUBSCRIBE_TOO_MUCH = null;
    public static final ErrorCode SUPER_CHAT_UNSUPPORTED_MESSAGE_TYPE = null;
    public static final ErrorCode SYNCTOCHAT_MESSAGE_FORBID_REPLY_IN_THREAD = null;
    public static final ErrorCode SYNCTOCHAT_OPERATE_NOT_SUPPORT_THIS_SCENE = null;
    public static final ErrorCode SYNC_TO_CHAT_MESSAGE_NOT_SUPPORT_REPLY_IN_THREAD = null;
    public static final ErrorCode TARGET_EXTERNAL_COORDINATE_CTL = null;
    public static final ErrorCode TENANT_DATA_TRANSFER_ON_MARCHING = null;
    public static final ErrorCode THIRD_PARTY_ENCRYPT_CHAT_UNSUPPORTED_ADD_BOTS = null;
    public static final ErrorCode THIRD_PARTY_ENCRYPT_CHAT_UNSUPPORTED_CROSS = null;
    public static final ErrorCode THREAD_ALREADY_WITHDRAW = null;
    public static final ErrorCode THREAD_CLOSED = null;
    public static final ErrorCode TOO_SHORT_PUBLIC_GROUP_NAME = null;
    public static final ErrorCode TRANSFER_CHAT_OWNER_FAIL = null;
    public static final ErrorCode TRANSMIT_CHAT_IS_NO_VALID = null;
    public static final ErrorCode TRANSMIT_MESSAGE_HAS_RECALL = null;
    public static final ErrorCode TRANSMIT_MESSAGE_IS_NO_VALID = null;
    public static final ErrorCode TRANSMIT_MESSAGE_SOURCE_INVALID = null;
    public static final ErrorCode TRANSMIT_MESSAGE_TYPE_IS_CRYPTO_INVALID = null;
    public static final ErrorCode TY_SINGLE_CHAT_FORBIDDEN_TRIGGER = null;
    public static final ErrorCode TY_SINGLE_CHAT_OVER_LIMIT = null;
    public static final ErrorCode UG_REACH_CORE_ERROR = null;
    public static final ErrorCode UG_REACH_DUPLICATE_REQUEST = null;
    public static final ErrorCode UG_REACH_LACK_REQUEST_PARAMETER = null;
    public static final ErrorCode UG_REACH_REPORT_GUIDE_FAIL = null;
    public static final ErrorCode UNABLE_TO_ADD_IMPORTANT_CONTACTS_MAX100 = null;
    public static final ErrorCode UNABLE_TO_ADD_SOME_MEMBERS = null;
    public static final ErrorCode UNKNOWN_CODE = null;
    public static final ErrorCode UNKNOWN_SYSTEM_ERROR = null;
    public static final ErrorCode UPDATE_CHAT_ICON_FAIL = null;
    public static final ErrorCode UPDATE_CONTAINER_MESSAGE_IS_ILLEGAL = null;
    public static final ErrorCode UPDATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT = null;
    public static final ErrorCode UPDATE_MESSAGE_TRIGGER_MSG_RATE_LIMIT = null;
    public static final ErrorCode URGENT_PEOPLE_LIMIT = null;
    public static final ErrorCode URL_PREVIEW_APP_CONTEXT_MISSING = null;
    public static final ErrorCode URL_PREVIEW_NEED_GET_CARD_PREVIEW = null;
    public static final ErrorCode URL_PREVIEW_PERMISSION_DENIED = null;
    public static final ErrorCode URL_PREVIEW_RESOURCE_EXHAUSTED = null;
    public static final ErrorCode URL_PREVIEW_RESOURCE_UNAVAILABLE = null;
    public static final ErrorCode URL_PREVIEW_SERVICE_UNAVAILABLE = null;
    public static final ErrorCode URL_PREVIEW_URL_MISMATCH = null;
    public static final ErrorCode VC_CREATE_MESSAGE_CONFERENCE_ID_NOT_MATCH_CHANNEL_ID = null;
    public static final ErrorCode VC_CREATE_MESSAGE_USER_NOT_IN_MEETING = null;
    public static final ErrorCode WILL_OVERFLOW_AFTER_ADD_MEMBER = null;
    public static final ErrorCode WILL_OVERFLOW_AFTER_BIND_CHAT = null;
    public static final ErrorCode WITHDRAW_MESSAGE_EXPIRED = null;
    public static final ErrorCode WITH_DRAW_PERMISSION_EXPIRED = null;
    public static final ErrorCode WRITE_CHAT_TRIGGER_LIMITER = null;
    public static final ErrorCode ZAXIS_AUTH_REVOKED = null;
    public static final ErrorCode ZAXIS_BAD_REQUEST = null;
    public static final ErrorCode ZAXIS_DEPENDENCY_ERROR = null;
    public static final ErrorCode ZAXIS_ENTITY_NOT_FOUND = null;
    public static final ErrorCode ZAXIS_INVALID_AUTH_CODE = null;
    public static final ErrorCode ZAXIS_INVALID_AUTH_TOKEN = null;
    public static final ErrorCode ZAXIS_NOT_AUTHORIZED = null;
    public static final ErrorCode ZAXIS_NOT_LOGGED_IN = null;
    public static final ErrorCode ZAXIS_UNKNOWN_SYSTEM_ERROR = null;
    private final int value;

    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }

    static {
        ErrorCode r0 = new ErrorCode("UNKNOWN_CODE", 0, 0);
        UNKNOWN_CODE = r0;
        ErrorCode r1 = new ErrorCode("CREATE_MESSAGE_INVALID_CARD_CONTENT", 1, 1);
        CREATE_MESSAGE_INVALID_CARD_CONTENT = r1;
        ErrorCode r3 = new ErrorCode("STOPPED_FEATURE_DEPRECATED", 2, 10);
        STOPPED_FEATURE_DEPRECATED = r3;
        ErrorCode r5 = new ErrorCode("STOPPED_FEATURE_NEED_UPGRADE", 3, 11);
        STOPPED_FEATURE_NEED_UPGRADE = r5;
        ErrorCode r8 = new ErrorCode("NO_PERMISSION", 4, 4000);
        NO_PERMISSION = r8;
        ErrorCode r11 = new ErrorCode("FORBID_ADD_MEMBER_FOR_NOT_IN_CHAT", 5, 4001);
        FORBID_ADD_MEMBER_FOR_NOT_IN_CHAT = r11;
        ErrorCode r12 = new ErrorCode("FORBID_ADD_MEMBER_TO_P2P_CHAT", 6, 4002);
        FORBID_ADD_MEMBER_TO_P2P_CHAT = r12;
        ErrorCode r14 = new ErrorCode("FORBID_DEL_MEMBER_FOR_NOT_IN_CHAT", 7, 4003);
        FORBID_DEL_MEMBER_FOR_NOT_IN_CHAT = r14;
        ErrorCode r13 = new ErrorCode("ONLY_GROUP_CHAT_ALLOW_MODIFY_NAME", 8, 4004);
        ONLY_GROUP_CHAT_ALLOW_MODIFY_NAME = r13;
        ErrorCode r9 = new ErrorCode("FORBID_MODIFY_ARCHIVED_CHAT_NAME", 9, 4005);
        FORBID_MODIFY_ARCHIVED_CHAT_NAME = r9;
        ErrorCode r6 = new ErrorCode("FORBID_MODIFY_CHAT_NAME_FOR_NOT_IN_CHAT", 10, 4006);
        FORBID_MODIFY_CHAT_NAME_FOR_NOT_IN_CHAT = r6;
        ErrorCode r4 = new ErrorCode("FORBID_PULL_CHAT_MEMBERS_FOR_NOT_IN_CHAT", 11, 4007);
        FORBID_PULL_CHAT_MEMBERS_FOR_NOT_IN_CHAT = r4;
        ErrorCode r7 = new ErrorCode("FORBID_PULL_MESSAGES_FOR_NOT_IN_CHAT", 12, 4008);
        FORBID_PULL_MESSAGES_FOR_NOT_IN_CHAT = r7;
        ErrorCode r10 = new ErrorCode("FORBID_SEND_MESSAGE_FOR_CHAT_DELETED_OR_ARCHIVED", 13, 4009);
        FORBID_SEND_MESSAGE_FOR_CHAT_DELETED_OR_ARCHIVED = r10;
        ErrorCode r2 = new ErrorCode("NOT_IN_SAME_TENANT", 14, 4010);
        NOT_IN_SAME_TENANT = r2;
        ErrorCode r15 = new ErrorCode("GROUP_CHAT_SHARED_CARD_EXPIRED", 15, 4011);
        GROUP_CHAT_SHARED_CARD_EXPIRED = r15;
        ErrorCode r16 = new ErrorCode("ALREADY_IN_CHAT", 16, 4012);
        ALREADY_IN_CHAT = r16;
        ErrorCode r17 = new ErrorCode("CHAT_USER_COUNT_GT_LIMIT", 17, 4013);
        CHAT_USER_COUNT_GT_LIMIT = r17;
        ErrorCode r18 = new ErrorCode("ONLY_OWNER_CAN_INVITE_OTHERS", 18, 4014);
        ONLY_OWNER_CAN_INVITE_OTHERS = r18;
        ErrorCode r19 = new ErrorCode("SHARE_CHAT_FORBID", 19, 4015);
        SHARE_CHAT_FORBID = r19;
        ErrorCode r20 = new ErrorCode("WITHDRAW_MESSAGE_EXPIRED", 20, 4016);
        WITHDRAW_MESSAGE_EXPIRED = r20;
        ErrorCode r21 = new ErrorCode("FORBID_ADD_OUT_TENANT_USER", 21, 4017);
        FORBID_ADD_OUT_TENANT_USER = r21;
        ErrorCode r22 = new ErrorCode("GROUP_CHAT_DISSOLVED", 22, 4018);
        GROUP_CHAT_DISSOLVED = r22;
        ErrorCode r23 = new ErrorCode("CHAT_NOT_FOUND", 23, 4019);
        CHAT_NOT_FOUND = r23;
        ErrorCode r24 = new ErrorCode("FORBID_SET_NAME", 24, 4020);
        FORBID_SET_NAME = r24;
        ErrorCode r25 = new ErrorCode("TENANT_DATA_TRANSFER_ON_MARCHING", 25, 4021);
        TENANT_DATA_TRANSFER_ON_MARCHING = r25;
        ErrorCode r26 = new ErrorCode("INVITEE_MOBILE_MARKED_MALICIOUS", 26, 4022);
        INVITEE_MOBILE_MARKED_MALICIOUS = r26;
        ErrorCode r27 = new ErrorCode("OWNER_CLOSE_GROUP_CHAT_SHARED", 27, 4023);
        OWNER_CLOSE_GROUP_CHAT_SHARED = r27;
        ErrorCode r28 = new ErrorCode("SAFETY_CHECK_FORBIDDEN_DOWNLOAD", 28, 4024);
        SAFETY_CHECK_FORBIDDEN_DOWNLOAD = r28;
        ErrorCode r29 = new ErrorCode("NO_RIGHT_CANDIDATE_OWNER", 29, 4025);
        NO_RIGHT_CANDIDATE_OWNER = r29;
        ErrorCode r30 = new ErrorCode("LINK_ADD_NON_CERTIFIED_TENANT_REFUSE", 30, 4026);
        LINK_ADD_NON_CERTIFIED_TENANT_REFUSE = r30;
        ErrorCode r31 = new ErrorCode("QR_CODE_ADD_NON_CERTIFIED_TENANT_REFUSE", 31, 4027);
        QR_CODE_ADD_NON_CERTIFIED_TENANT_REFUSE = r31;
        ErrorCode r32 = new ErrorCode("SHARE_CARD_ADD_NON_CERTIFIED_TENANT_REFUSE", 32, 4028);
        SHARE_CARD_ADD_NON_CERTIFIED_TENANT_REFUSE = r32;
        ErrorCode r33 = new ErrorCode("NO_FILE_SHARE_PERM", 33, 4029);
        NO_FILE_SHARE_PERM = r33;
        ErrorCode r34 = new ErrorCode("OPERATION_TOO_FREQUENTLY", 34, 4030);
        OPERATION_TOO_FREQUENTLY = r34;
        ErrorCode r35 = new ErrorCode("FORBID_CREATE_CHAT_FOR_USER_RESIGNED", 35, 4031);
        FORBID_CREATE_CHAT_FOR_USER_RESIGNED = r35;
        ErrorCode r36 = new ErrorCode("FORBID_QUIT_YOUR_CUSTOM_CHAT", 36, 4032);
        FORBID_QUIT_YOUR_CUSTOM_CHAT = r36;
        ErrorCode r37 = new ErrorCode("FORBID_LARK_ASSISTANT_QUIT_CUSTOM_CHAT", 37, 4033);
        FORBID_LARK_ASSISTANT_QUIT_CUSTOM_CHAT = r37;
        ErrorCode r38 = new ErrorCode("GET_CHAT_CHATTERS_FAIL", 38, 4034);
        GET_CHAT_CHATTERS_FAIL = r38;
        ErrorCode r39 = new ErrorCode("INVALID_CONTACT_TOKEN", 39, 4035);
        INVALID_CONTACT_TOKEN = r39;
        ErrorCode r40 = new ErrorCode("RESET_CONTACT_TOKEN_TOO_FAST", 40, 4036);
        RESET_CONTACT_TOKEN_TOO_FAST = r40;
        ErrorCode r41 = new ErrorCode("FORBID_ADD_OUT_TENANT_USER_V2", 41, 4037);
        FORBID_ADD_OUT_TENANT_USER_V2 = r41;
        ErrorCode r42 = new ErrorCode("TRANSFER_CHAT_OWNER_FAIL", 42, 4038);
        TRANSFER_CHAT_OWNER_FAIL = r42;
        ErrorCode r43 = new ErrorCode("FORBID_CREATE_CRYPTO_CHAT_OR_ADD_CHATTER", 43, 4039);
        FORBID_CREATE_CRYPTO_CHAT_OR_ADD_CHATTER = r43;
        ErrorCode r44 = new ErrorCode("FORBID_PULL_CHAT_THREAD_FOR_NOT_IN_CHAT", 44, 4040);
        FORBID_PULL_CHAT_THREAD_FOR_NOT_IN_CHAT = r44;
        ErrorCode r45 = new ErrorCode("FORBID_PULL_THREAD_MESSAGE_FOR_NOT_IN_CHAT", 45, 4041);
        FORBID_PULL_THREAD_MESSAGE_FOR_NOT_IN_CHAT = r45;
        ErrorCode r46 = new ErrorCode("FORBID_SEND_MESSAGE_IN_CHAT", 46, 4042);
        FORBID_SEND_MESSAGE_IN_CHAT = r46;
        ErrorCode r47 = new ErrorCode("ALL_URGENT_USERS_ARE_MANAGERS", 47, 4043);
        ALL_URGENT_USERS_ARE_MANAGERS = r47;
        ErrorCode r48 = new ErrorCode("PARTIAL_URGENT_USERS_ARE_MANAGERS", 48, 4044);
        PARTIAL_URGENT_USERS_ARE_MANAGERS = r48;
        ErrorCode r49 = new ErrorCode("PULL_MESSAGE_FAIL_FOR_NOT_IN_CHAT", 49, 4045);
        PULL_MESSAGE_FAIL_FOR_NOT_IN_CHAT = r49;
        ErrorCode r50 = new ErrorCode("WITH_DRAW_PERMISSION_EXPIRED", 50, 4046);
        WITH_DRAW_PERMISSION_EXPIRED = r50;
        ErrorCode r51 = new ErrorCode("DELETE_THREAD_PERMISSION_EXPIRED", 51, 4047);
        DELETE_THREAD_PERMISSION_EXPIRED = r51;
        ErrorCode r52 = new ErrorCode("FORBID_WITHDRAW_GROUP_OWNER", 52, 4048);
        FORBID_WITHDRAW_GROUP_OWNER = r52;
        ErrorCode r53 = new ErrorCode("JOIN_TOKEN_NOT_SET", 53, 4049);
        JOIN_TOKEN_NOT_SET = r53;
        ErrorCode r54 = new ErrorCode("FORBID_DISABLE_SHARED_CHAT", 54, 4050);
        FORBID_DISABLE_SHARED_CHAT = r54;
        ErrorCode r55 = new ErrorCode("FORBID_PUT_P2P_CHAT", 55, 4051);
        FORBID_PUT_P2P_CHAT = r55;
        ErrorCode r56 = new ErrorCode("FORBID_PUT_P2P_CHATS", 56, 4052);
        FORBID_PUT_P2P_CHATS = r56;
        ErrorCode r57 = new ErrorCode("FORBID_PUT_URGENT", 57, 4053);
        FORBID_PUT_URGENT = r57;
        ErrorCode r58 = new ErrorCode("URGENT_PEOPLE_LIMIT", 58, 4054);
        URGENT_PEOPLE_LIMIT = r58;
        ErrorCode r59 = new ErrorCode("FORBID_SET_AVATAR", 59, 4055);
        FORBID_SET_AVATAR = r59;
        ErrorCode r60 = new ErrorCode("FORBIDDEN_EXIT_DEPARTMENT_CHAT", 60, 4056);
        FORBIDDEN_EXIT_DEPARTMENT_CHAT = r60;
        ErrorCode r61 = new ErrorCode("HOTSPOT_CHAT_LIMITED", 61, 4057);
        HOTSPOT_CHAT_LIMITED = r61;
        ErrorCode r62 = new ErrorCode("HOTSPOT_CHAT_LIMITED_FOR_REPORT", 62, 4058);
        HOTSPOT_CHAT_LIMITED_FOR_REPORT = r62;
        ErrorCode r63 = new ErrorCode("DOUBAO_CHAT_NOT_SUPPORTED", 63, 4059);
        DOUBAO_CHAT_NOT_SUPPORTED = r63;
        ErrorCode r64 = new ErrorCode("ACCOUNT_FORBIDDEN", 64, 4100);
        ACCOUNT_FORBIDDEN = r64;
        ErrorCode r65 = new ErrorCode("ACCOUNT_LOGOUT_ERROR", 65, 4101);
        ACCOUNT_LOGOUT_ERROR = r65;
        ErrorCode r66 = new ErrorCode("MAIL_NOT_IN_MAIL_GROUP", 66, 4200);
        MAIL_NOT_IN_MAIL_GROUP = r66;
        ErrorCode r67 = new ErrorCode("MAIL_FORBID_MODIFY_MAIL_TITLE", 67, 4201);
        MAIL_FORBID_MODIFY_MAIL_TITLE = r67;
        ErrorCode r68 = new ErrorCode("GATEWAY_AUTH_APP_TOKEN_NOT_FOUND", 68, 4301);
        GATEWAY_AUTH_APP_TOKEN_NOT_FOUND = r68;
        ErrorCode r69 = new ErrorCode("GATEWAY_AUTH_SESSION_NOT_FOUND", 69, 4302);
        GATEWAY_AUTH_SESSION_NOT_FOUND = r69;
        ErrorCode r70 = new ErrorCode("GATEWAY_AUTH_SESSION_DEVICE_MISMATCH", 70, 4303);
        GATEWAY_AUTH_SESSION_DEVICE_MISMATCH = r70;
        ErrorCode r71 = new ErrorCode("GATEWAY_AUTH_INVALID_TICKET", 71, 4304);
        GATEWAY_AUTH_INVALID_TICKET = r71;
        ErrorCode r72 = new ErrorCode("GATEWAY_AUTH_BAD_REQUEST", 72, 4305);
        GATEWAY_AUTH_BAD_REQUEST = r72;
        ErrorCode r73 = new ErrorCode("GATEWAY_AUTH_SESSION_INCONSISTENT_WITH_PACKET_USER", 73, 4307);
        GATEWAY_AUTH_SESSION_INCONSISTENT_WITH_PACKET_USER = r73;
        ErrorCode r74 = new ErrorCode("SID_NOT_IN_FRONTIER_DOWNGRADE_PIPE", 74, 4306);
        SID_NOT_IN_FRONTIER_DOWNGRADE_PIPE = r74;
        ErrorCode r75 = new ErrorCode("HONGBAO_PARAM_ERROR", 75, 4401);
        HONGBAO_PARAM_ERROR = r75;
        ErrorCode r76 = new ErrorCode("HONGBAO_INVALID_CHAT", 76, 4402);
        HONGBAO_INVALID_CHAT = r76;
        ErrorCode r77 = new ErrorCode("HONGBAO_ZERO_LEFT", 77, 4403);
        HONGBAO_ZERO_LEFT = r77;
        ErrorCode r78 = new ErrorCode("HONGBAO_ALREADY_GRAB", 78, 4404);
        HONGBAO_ALREADY_GRAB = r78;
        ErrorCode r79 = new ErrorCode("HONGBAO_EXPIRED", 79, 4405);
        HONGBAO_EXPIRED = r79;
        ErrorCode r80 = new ErrorCode("HONGBAO_INVALID_USER", 80, 4406);
        HONGBAO_INVALID_USER = r80;
        ErrorCode r81 = new ErrorCode("HONGBAO_INVALID_QUERY", 81, 4407);
        HONGBAO_INVALID_QUERY = r81;
        ErrorCode r82 = new ErrorCode("HONGBAO_USER_NEED_AUTONYM", 82, 4408);
        HONGBAO_USER_NEED_AUTONYM = r82;
        ErrorCode r83 = new ErrorCode("HONGBAO_GRAB_TOO_FAST", 83, 4409);
        HONGBAO_GRAB_TOO_FAST = r83;
        ErrorCode r84 = new ErrorCode("HONGBAO_CANNOT_GRAB", 84, 4410);
        HONGBAO_CANNOT_GRAB = r84;
        ErrorCode r85 = new ErrorCode("CAIJING_ACCOUNT_NEED_UPGRADE", 85, 4411);
        CAIJING_ACCOUNT_NEED_UPGRADE = r85;
        ErrorCode r86 = new ErrorCode("LARK_APP_NEED_UPGRADE", 86, 4412);
        LARK_APP_NEED_UPGRADE = r86;
        ErrorCode r87 = new ErrorCode("DEVICE_NOT_HAVE_LEAN_MODE_AUTHORITY", 87, 4500);
        DEVICE_NOT_HAVE_LEAN_MODE_AUTHORITY = r87;
        ErrorCode r88 = new ErrorCode("DEVICE_IN_LEAN_MODE_CANNOT_USE_CRYPTO_CHAT", 88, 4501);
        DEVICE_IN_LEAN_MODE_CANNOT_USE_CRYPTO_CHAT = r88;
        ErrorCode r89 = new ErrorCode("FORBID_FORWARD_MESSAGE_IN_RESTRICTED_MODE", 89, 4502);
        FORBID_FORWARD_MESSAGE_IN_RESTRICTED_MODE = r89;
        ErrorCode r90 = new ErrorCode("FORBID_DELETE_USER_IN_MEETING", 90, 4503);
        FORBID_DELETE_USER_IN_MEETING = r90;
        ErrorCode r91 = new ErrorCode("FORBID_DISSOLVED_CHAT_DURING_MEETING", 91, 4504);
        FORBID_DISSOLVED_CHAT_DURING_MEETING = r91;
        ErrorCode r92 = new ErrorCode("NOT_LATEST_LEAN_MODE_CONFIG", 92, 4505);
        NOT_LATEST_LEAN_MODE_CONFIG = r92;
        ErrorCode r93 = new ErrorCode("CHAT_IS_FROZEN", 93, 4506);
        CHAT_IS_FROZEN = r93;
        ErrorCode r94 = new ErrorCode("INVALID_THREAD_ID", 94, 4507);
        INVALID_THREAD_ID = r94;
        ErrorCode r95 = new ErrorCode("NO_PERM_THREAD_ID", 95, 4508);
        NO_PERM_THREAD_ID = r95;
        ErrorCode r96 = new ErrorCode("CHAT_BOT_COUNT_GT_LIMIT", 96, 4509);
        CHAT_BOT_COUNT_GT_LIMIT = r96;
        ErrorCode r97 = new ErrorCode("PARAM_ERR", 97, 5000);
        PARAM_ERR = r97;
        ErrorCode r98 = new ErrorCode("P2P_CHAT_NOT_CONTAIN_CREATOR_NOT", 98, 5001);
        P2P_CHAT_NOT_CONTAIN_CREATOR_NOT = r98;
        ErrorCode r99 = new ErrorCode("P2P_CHAT_USER_COUNT_GT_TWO", 99, 5002);
        P2P_CHAT_USER_COUNT_GT_TWO = r99;
        ErrorCode r100 = new ErrorCode("INVALID_CHAT_TYPE", 100, 5003);
        INVALID_CHAT_TYPE = r100;
        ErrorCode r101 = new ErrorCode("CHAT_NOT_FOUND_V2", BaseField.FIELD_TYPE_S_PHONE_NUMBER, 5004);
        CHAT_NOT_FOUND_V2 = r101;
        ErrorCode r102 = new ErrorCode("CHAT_DESC_TOO_LONG", BaseField.FIELD_TYPE_S_FRIEND_LINK, 5005);
        CHAT_DESC_TOO_LONG = r102;
        ErrorCode r103 = new ErrorCode("UPDATE_CHAT_ICON_FAIL", 103, 5006);
        UPDATE_CHAT_ICON_FAIL = r103;
        ErrorCode r104 = new ErrorCode("MESSAGE_CONTENT_TOO_LONG", BaseField.FIELD_TYPE_ALIAS_AND_MEMO, 5007);
        MESSAGE_CONTENT_TOO_LONG = r104;
        ErrorCode r105 = new ErrorCode("REPEATED_PUT_CHAT_CHATTER_REQUEST", BaseField.FIELD_TYPE_MEMO_DESCRIPTION, 5008);
        REPEATED_PUT_CHAT_CHATTER_REQUEST = r105;
        ErrorCode r106 = new ErrorCode("FORBID_SEND_MESSAGE_FOR_NOT_FRIEND", 106, 5009);
        FORBID_SEND_MESSAGE_FOR_NOT_FRIEND = r106;
        ErrorCode r107 = new ErrorCode("FORBID_ADD_FRIEND_FOR_USER_PRIVATE_SETTING", 107, 5010);
        FORBID_ADD_FRIEND_FOR_USER_PRIVATE_SETTING = r107;
        ErrorCode r108 = new ErrorCode("INVALID_PHONE_FORMAT", 108, 5011);
        INVALID_PHONE_FORMAT = r108;
        ErrorCode r109 = new ErrorCode("INVALID_MAIL", 109, 5012);
        INVALID_MAIL = r109;
        ErrorCode r110 = new ErrorCode("FORBID_CREATE_CHAT_FOR_NOT_FRIEND", 110, 5013);
        FORBID_CREATE_CHAT_FOR_NOT_FRIEND = r110;
        ErrorCode r111 = new ErrorCode("LARK_ACCOUNT_ID_NOT_MATCH_DOC", 111, 5014);
        LARK_ACCOUNT_ID_NOT_MATCH_DOC = r111;
        ErrorCode r112 = new ErrorCode("INVALID_QR_CODE", 112, 5015);
        INVALID_QR_CODE = r112;
        ErrorCode r113 = new ErrorCode("QR_CODE_INVITER_NOT_IN_CHAT", 113, 5016);
        QR_CODE_INVITER_NOT_IN_CHAT = r113;
        ErrorCode r114 = new ErrorCode("PB_PACKET_UNMARSHAL_ERR", 114, 5017);
        PB_PACKET_UNMARSHAL_ERR = r114;
        ErrorCode r115 = new ErrorCode("PB_PAYLOAD_UNMARSHAL_ERR", 115, 5018);
        PB_PAYLOAD_UNMARSHAL_ERR = r115;
        ErrorCode r116 = new ErrorCode("PUBLIC_CHAT_NAMED_EXISTED", 116, 5019);
        PUBLIC_CHAT_NAMED_EXISTED = r116;
        ErrorCode r117 = new ErrorCode("NEED_UPGRADE_FOR_APPLY_CHECK", 117, 5020);
        NEED_UPGRADE_FOR_APPLY_CHECK = r117;
        ErrorCode r118 = new ErrorCode("ADD_FRIENDS_TIMEOUT_VIA_CONTACT", 118, 5021);
        ADD_FRIENDS_TIMEOUT_VIA_CONTACT = r118;
        ErrorCode r119 = new ErrorCode("PROFILE_TOKEN_STOLEN", 119, 5022);
        PROFILE_TOKEN_STOLEN = r119;
        ErrorCode r120 = new ErrorCode("ADD_FRIEND_ERR_FOR_FRIEND_NOT_IN_CHAT", 120, 5023);
        ADD_FRIEND_ERR_FOR_FRIEND_NOT_IN_CHAT = r120;
        ErrorCode r121 = new ErrorCode("NO_CHAT_ID_FOR_ADD_FRIEND", 121, 5024);
        NO_CHAT_ID_FOR_ADD_FRIEND = r121;
        ErrorCode r122 = new ErrorCode("ADD_FRIEND_ERR_FOR_SEARCH_MANNER_CLOSED", 122, 5025);
        ADD_FRIEND_ERR_FOR_SEARCH_MANNER_CLOSED = r122;
        ErrorCode r123 = new ErrorCode("ADD_FRIEND_ERR_FOR_CHAT_MANNER_CLOSED", 123, 5026);
        ADD_FRIEND_ERR_FOR_CHAT_MANNER_CLOSED = r123;
        ErrorCode r124 = new ErrorCode("ADD_CHAT_CHATTER_APPLY_NOT_OPEN", 124, 5027);
        ADD_CHAT_CHATTER_APPLY_NOT_OPEN = r124;
        ErrorCode r125 = new ErrorCode("THREAD_ALREADY_WITHDRAW", 125, 5028);
        THREAD_ALREADY_WITHDRAW = r125;
        ErrorCode r126 = new ErrorCode("RECOGNITION_WITH_EMPTY_RESULT", 126, 5029);
        RECOGNITION_WITH_EMPTY_RESULT = r126;
        ErrorCode r127 = new ErrorCode("THREAD_CLOSED", 127, 5030);
        THREAD_CLOSED = r127;
        ErrorCode r128 = new ErrorCode("TOO_SHORT_PUBLIC_GROUP_NAME", 128, 5031);
        TOO_SHORT_PUBLIC_GROUP_NAME = r128;
        ErrorCode r129 = new ErrorCode("MERGE_FORWARD_CONTENT_REACH_LIMIT", 129, 5040);
        MERGE_FORWARD_CONTENT_REACH_LIMIT = r129;
        ErrorCode r130 = new ErrorCode("MERGE_FORWARD_CONTENT_TWO_LARGE_FAIL", 130, 5041);
        MERGE_FORWARD_CONTENT_TWO_LARGE_FAIL = r130;
        ErrorCode r131 = new ErrorCode("MESSAGE_CHANNEL_NOT_FOUND", 131, 5042);
        MESSAGE_CHANNEL_NOT_FOUND = r131;
        ErrorCode r132 = new ErrorCode("MESSAGE_THREAD_NOT_FOUND", 132, 5043);
        MESSAGE_THREAD_NOT_FOUND = r132;
        ErrorCode r133 = new ErrorCode("INVALID_USER_NAME_LENGTH", 133, 5044);
        INVALID_USER_NAME_LENGTH = r133;
        ErrorCode r134 = new ErrorCode("CREATE_MESSAGE_TRIGGER_PSM_RATE_LIMIT", 134, 5045);
        CREATE_MESSAGE_TRIGGER_PSM_RATE_LIMIT = r134;
        ErrorCode r135 = new ErrorCode("CREATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT", 135, 5046);
        CREATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT = r135;
        ErrorCode r136 = new ErrorCode("CREATE_MESSAGE_REQUEST_IS_PROCESSING", 136, 204);
        CREATE_MESSAGE_REQUEST_IS_PROCESSING = r136;
        ErrorCode r137 = new ErrorCode("PIN_OPERATION_PERMISSION_DENIED", 137, 5047);
        PIN_OPERATION_PERMISSION_DENIED = r137;
        ErrorCode r138 = new ErrorCode("INVALID_CHAT_LINK_TOKEN", 138, 5048);
        INVALID_CHAT_LINK_TOKEN = r138;
        ErrorCode r139 = new ErrorCode("CHAT_LINK_INVITER_NOT_IN_CHAT", 139, 5049);
        CHAT_LINK_INVITER_NOT_IN_CHAT = r139;
        ErrorCode r140 = new ErrorCode("CREATE_MESSAGE_AT_ALL_DENIED", 140, 5050);
        CREATE_MESSAGE_AT_ALL_DENIED = r140;
        ErrorCode r141 = new ErrorCode("CREATE_MESSAGE_TRIGGER_USER_RATE_LIMIT", 141, 5051);
        CREATE_MESSAGE_TRIGGER_USER_RATE_LIMIT = r141;
        ErrorCode r142 = new ErrorCode("CREATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT_ENQUEUE", 142, 5052);
        CREATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT_ENQUEUE = r142;
        ErrorCode r143 = new ErrorCode("CREATE_MESSAGE_TRIGGER_CONTAINER_LIMIT", 143, 5053);
        CREATE_MESSAGE_TRIGGER_CONTAINER_LIMIT = r143;
        ErrorCode r144 = new ErrorCode("CREATE_ANONYMOUS_MESSAGE_SETTING_CLOSE", 144, 5054);
        CREATE_ANONYMOUS_MESSAGE_SETTING_CLOSE = r144;
        ErrorCode r145 = new ErrorCode("CREATE_ANONYMOUS_MESSAGE_NO_MORE_QUOTA", 145, 5055);
        CREATE_ANONYMOUS_MESSAGE_NO_MORE_QUOTA = r145;
        ErrorCode r146 = new ErrorCode("GET_MESSAGE_POSITION_BY_TIMESTAMP_NUMBER_OF_CHAT_EXCEED_LIMIT", 146, 5056);
        GET_MESSAGE_POSITION_BY_TIMESTAMP_NUMBER_OF_CHAT_EXCEED_LIMIT = r146;
        ErrorCode r147 = new ErrorCode("GET_MESSAGE_POSITION_BY_TIMESTAMP_PARAMS_ERROR", 147, 5057);
        GET_MESSAGE_POSITION_BY_TIMESTAMP_PARAMS_ERROR = r147;
        ErrorCode r148 = new ErrorCode("REMOVE_LAN_FILE_MESSAGE_FAILED_WHILE_TRANSFERRING", 148, 5058);
        REMOVE_LAN_FILE_MESSAGE_FAILED_WHILE_TRANSFERRING = r148;
        ErrorCode r149 = new ErrorCode("PIN_LAN_FILE_MESSAGE_FAILED_WHILE_TRANSFERRING", 149, 5059);
        PIN_LAN_FILE_MESSAGE_FAILED_WHILE_TRANSFERRING = r149;
        ErrorCode r150 = new ErrorCode("ONE_BY_ONE_FORWARD_MESSAGE_MAX_REACHED", 150, 5060);
        ONE_BY_ONE_FORWARD_MESSAGE_MAX_REACHED = r150;
        ErrorCode r151 = new ErrorCode("DLP_SENSITIVE_MESSAGE_BLOCKED", 151, 5061);
        DLP_SENSITIVE_MESSAGE_BLOCKED = r151;
        ErrorCode r152 = new ErrorCode("MESSAGE_NOT_FOUND", 152, 5062);
        MESSAGE_NOT_FOUND = r152;
        ErrorCode r153 = new ErrorCode("SUPER_CHAT_UNSUPPORTED_MESSAGE_TYPE", 153, 5063);
        SUPER_CHAT_UNSUPPORTED_MESSAGE_TYPE = r153;
        ErrorCode r154 = new ErrorCode("CREATE_MESSAGE_INVALID_USER_CARD", 154, 5064);
        CREATE_MESSAGE_INVALID_USER_CARD = r154;
        ErrorCode r155 = new ErrorCode("SUPER_CHAT_THREAD_SUBSCRIBE_TOO_MUCH", 155, 5065);
        SUPER_CHAT_THREAD_SUBSCRIBE_TOO_MUCH = r155;
        ErrorCode r156 = new ErrorCode("UNABLE_TO_ADD_IMPORTANT_CONTACTS_MAX100", 156, 5066);
        UNABLE_TO_ADD_IMPORTANT_CONTACTS_MAX100 = r156;
        ErrorCode r157 = new ErrorCode("OPERATION_TO_PENDING_DELETE_FEED", 157, 5067);
        OPERATION_TO_PENDING_DELETE_FEED = r157;
        ErrorCode r158 = new ErrorCode("UPDATE_MESSAGE_TRIGGER_MSG_RATE_LIMIT", 158, 5068);
        UPDATE_MESSAGE_TRIGGER_MSG_RATE_LIMIT = r158;
        ErrorCode r159 = new ErrorCode("UPDATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT", 159, 5069);
        UPDATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT = r159;
        ErrorCode r160 = new ErrorCode("VC_CREATE_MESSAGE_CONFERENCE_ID_NOT_MATCH_CHANNEL_ID", 160, 5070);
        VC_CREATE_MESSAGE_CONFERENCE_ID_NOT_MATCH_CHANNEL_ID = r160;
        ErrorCode r161 = new ErrorCode("VC_CREATE_MESSAGE_USER_NOT_IN_MEETING", 161, 5071);
        VC_CREATE_MESSAGE_USER_NOT_IN_MEETING = r161;
        ErrorCode r162 = new ErrorCode("CREATE_REPLY_IN_THREAD_CHAT_UNSUPPORTED", 162, 5072);
        CREATE_REPLY_IN_THREAD_CHAT_UNSUPPORTED = r162;
        ErrorCode r163 = new ErrorCode("CREATE_REPLY_IN_THREAD_FOLD_MESSAGE_UNSUPPORTED", 163, 5073);
        CREATE_REPLY_IN_THREAD_FOLD_MESSAGE_UNSUPPORTED = r163;
        ErrorCode r164 = new ErrorCode("CREATE_REPLY_IN_THREAD_SYSTEM_MESSAGE_UNSUPPORTED", 164, 5074);
        CREATE_REPLY_IN_THREAD_SYSTEM_MESSAGE_UNSUPPORTED = r164;
        ErrorCode r165 = new ErrorCode("CREATE_REPLY_IN_THREAD_ROOT_MESSAGE_RECALLED", 165, 5075);
        CREATE_REPLY_IN_THREAD_ROOT_MESSAGE_RECALLED = r165;
        ErrorCode r166 = new ErrorCode("FORWARD_TO_THREAD_CHAT_THREAD_MISMATCH", 166, 5076);
        FORWARD_TO_THREAD_CHAT_THREAD_MISMATCH = r166;
        ErrorCode r167 = new ErrorCode("FORWARD_NO_VALID_TARGET", 167, 5077);
        FORWARD_NO_VALID_TARGET = r167;
        ErrorCode r168 = new ErrorCode("CREATE_MESSAGE_AT_USER_GROUP_DENIED", 168, 5078);
        CREATE_MESSAGE_AT_USER_GROUP_DENIED = r168;
        ErrorCode r169 = new ErrorCode("CREATE_MESSAGE_MYAI_UNSUPPORTED_LOW_VERSION", 169, 5079);
        CREATE_MESSAGE_MYAI_UNSUPPORTED_LOW_VERSION = r169;
        ErrorCode r170 = new ErrorCode("FORWARD_NO_PERMISSION_TRANSMIT_HISTORY_MESSAGE", 170, 5080);
        FORWARD_NO_PERMISSION_TRANSMIT_HISTORY_MESSAGE = r170;
        ErrorCode r171 = new ErrorCode("EXPIRE_CLEANED_MESSAGE_NOT_SUPPORT_UPDATE", 171, 5081);
        EXPIRE_CLEANED_MESSAGE_NOT_SUPPORT_UPDATE = r171;
        ErrorCode r172 = new ErrorCode("NO_DEVICE_FOR_CRYPTO_MESSAGE_CONTENT", 172, 5100);
        NO_DEVICE_FOR_CRYPTO_MESSAGE_CONTENT = r172;
        ErrorCode r173 = new ErrorCode("NO_DEVICE_WHEN_CREATE_P2P_CHAT", 173, 5101);
        NO_DEVICE_WHEN_CREATE_P2P_CHAT = r173;
        ErrorCode r174 = new ErrorCode("THIRD_PARTY_ENCRYPT_CHAT_UNSUPPORTED_CROSS", 174, 5102);
        THIRD_PARTY_ENCRYPT_CHAT_UNSUPPORTED_CROSS = r174;
        ErrorCode r175 = new ErrorCode("THIRD_PARTY_ENCRYPT_CHAT_UNSUPPORTED_ADD_BOTS", 175, 5103);
        THIRD_PARTY_ENCRYPT_CHAT_UNSUPPORTED_ADD_BOTS = r175;
        ErrorCode r176 = new ErrorCode("EDIT_MESSAGE_NOT_IN_VALID_TIME", 176, 5104);
        EDIT_MESSAGE_NOT_IN_VALID_TIME = r176;
        ErrorCode r177 = new ErrorCode("EDIT_MESSAGE_OVER_TIMES", 177, 5105);
        EDIT_MESSAGE_OVER_TIMES = r177;
        ErrorCode r178 = new ErrorCode("EDIT_MESSAGE_RECALLED", 178, 5106);
        EDIT_MESSAGE_RECALLED = r178;
        ErrorCode r179 = new ErrorCode("COPY_MESSAGE_EXCEED_RESOURCE", 179, 5107);
        COPY_MESSAGE_EXCEED_RESOURCE = r179;
        ErrorCode r180 = new ErrorCode("DEEP_COPY_EXCEED_LIMIT", 180, 5108);
        DEEP_COPY_EXCEED_LIMIT = r180;
        ErrorCode r181 = new ErrorCode("DEEP_COPY_NO_VALID_MESSAGE", 181, 5109);
        DEEP_COPY_NO_VALID_MESSAGE = r181;
        ErrorCode r182 = new ErrorCode("PUT_SHORTCUTS_FAILED", 182, 5110);
        PUT_SHORTCUTS_FAILED = r182;
        ErrorCode r183 = new ErrorCode("PUT_MERGE_FORWARD_MESSAGE_TYPE_INVALID", 183, 5111);
        PUT_MERGE_FORWARD_MESSAGE_TYPE_INVALID = r183;
        ErrorCode r184 = new ErrorCode("PUT_TRANSMIT_MESSAGE_TYPE_INVALID", 184, 5112);
        PUT_TRANSMIT_MESSAGE_TYPE_INVALID = r184;
        ErrorCode r185 = new ErrorCode("NO_PERMISSION_TRANSMIT_TO_THIRD_PARTY_ENCRYTE_CHAT", 185, 5113);
        NO_PERMISSION_TRANSMIT_TO_THIRD_PARTY_ENCRYTE_CHAT = r185;
        ErrorCode r186 = new ErrorCode("TRANSMIT_CHAT_IS_NO_VALID", 186, 5114);
        TRANSMIT_CHAT_IS_NO_VALID = r186;
        ErrorCode r187 = new ErrorCode("TRANSMIT_MESSAGE_IS_NO_VALID", 187, 5115);
        TRANSMIT_MESSAGE_IS_NO_VALID = r187;
        ErrorCode r188 = new ErrorCode("TRANSMIT_MESSAGE_HAS_RECALL", 188, 5116);
        TRANSMIT_MESSAGE_HAS_RECALL = r188;
        ErrorCode r189 = new ErrorCode("TRANSMIT_MESSAGE_TYPE_IS_CRYPTO_INVALID", 189, 5117);
        TRANSMIT_MESSAGE_TYPE_IS_CRYPTO_INVALID = r189;
        ErrorCode r190 = new ErrorCode("MERGE_FORWARD_MESSAGE_SOURCE_INVALID", 190, 5118);
        MERGE_FORWARD_MESSAGE_SOURCE_INVALID = r190;
        ErrorCode r191 = new ErrorCode("TRANSMIT_MESSAGE_SOURCE_INVALID", 191, 5119);
        TRANSMIT_MESSAGE_SOURCE_INVALID = r191;
        ErrorCode r192 = new ErrorCode("OPERATE_MESSAGE_NOT_FROM_SAME_CHAT", 192, 5120);
        OPERATE_MESSAGE_NOT_FROM_SAME_CHAT = r192;
        ErrorCode r193 = new ErrorCode("NO_PERMISSION_USE_OTHER_TENANT_EMOJI", 193, 5121);
        NO_PERMISSION_USE_OTHER_TENANT_EMOJI = r193;
        ErrorCode r194 = new ErrorCode("CRYPTO_CHAT_UNSUPPORTED_ADD_BOTS", 194, 5122);
        CRYPTO_CHAT_UNSUPPORTED_ADD_BOTS = r194;
        ErrorCode r195 = new ErrorCode("FORBID_TRANSMIT_ONE_AUDIO_MESSAGE", 195, 5123);
        FORBID_TRANSMIT_ONE_AUDIO_MESSAGE = r195;
        ErrorCode r196 = new ErrorCode("EDIT_MESSAGE_NOT_VISIBLE", 196, 5124);
        EDIT_MESSAGE_NOT_VISIBLE = r196;
        ErrorCode r197 = new ErrorCode("EDIT_MESSAGE_USERID_NOT_SAME_FROM_REQUEST", 197, 5125);
        EDIT_MESSAGE_USERID_NOT_SAME_FROM_REQUEST = r197;
        ErrorCode r198 = new ErrorCode("EDIT_MESSAGE_USER_NOT_IN_MESSAGE_CHAT", 198, 5126);
        EDIT_MESSAGE_USER_NOT_IN_MESSAGE_CHAT = r198;
        ErrorCode r199 = new ErrorCode("EDIT_MESSAGE_USER_CAN_NOT_SEND_MESSAGE", 199, 5127);
        EDIT_MESSAGE_USER_CAN_NOT_SEND_MESSAGE = r199;
        ErrorCode r200 = new ErrorCode("EDIT_MESSAGE_SUBMIT_FOR_REVIEW_FAIL", 200, 5128);
        EDIT_MESSAGE_SUBMIT_FOR_REVIEW_FAIL = r200;
        ErrorCode r201 = new ErrorCode("EDIT_MESSAGE_DLP_REVIEW_FAIL", 201, 5129);
        EDIT_MESSAGE_DLP_REVIEW_FAIL = r201;
        ErrorCode r202 = new ErrorCode("EDIT_MESSAGE_SENSITIVE_WORDS_REVIEW_FAIL", 202, 5130);
        EDIT_MESSAGE_SENSITIVE_WORDS_REVIEW_FAIL = r202;
        ErrorCode r203 = new ErrorCode("EDIT_MESSAGE_IS_CRYPTO", 203, 5131);
        EDIT_MESSAGE_IS_CRYPTO = r203;
        ErrorCode r204 = new ErrorCode("EDIT_MESSAGE_IS_ILLEGAL", 204, 5132);
        EDIT_MESSAGE_IS_ILLEGAL = r204;
        ErrorCode r205 = new ErrorCode("EDIT_MESSAGE_IS_ENCRYPT", 205, 5133);
        EDIT_MESSAGE_IS_ENCRYPT = r205;
        ErrorCode r206 = new ErrorCode("EDIT_MESSAGE_DELETED", 206, 5134);
        EDIT_MESSAGE_DELETED = r206;
        ErrorCode r207 = new ErrorCode("UPDATE_CONTAINER_MESSAGE_IS_ILLEGAL", 207, 5135);
        UPDATE_CONTAINER_MESSAGE_IS_ILLEGAL = r207;
        ErrorCode r208 = new ErrorCode("NO_PERMISSION_EDITING_DOC_FOR_OLD_VERSION", 208, 5200);
        NO_PERMISSION_EDITING_DOC_FOR_OLD_VERSION = r208;
        ErrorCode r209 = new ErrorCode("SHARE_CHAT_DEPRECATED", 209, 5555);
        SHARE_CHAT_DEPRECATED = r209;
        ErrorCode r210 = new ErrorCode("SENSITIVE_MESSAGE_BLOCKED", 210, 5566);
        SENSITIVE_MESSAGE_BLOCKED = r210;
        ErrorCode r211 = new ErrorCode("SENSITIVE_USER_NAME", 211, 5567);
        SENSITIVE_USER_NAME = r211;
        ErrorCode r212 = new ErrorCode("COPY_MESSAGE_AUTHED_ID_NIL", 212, 5568);
        COPY_MESSAGE_AUTHED_ID_NIL = r212;
        ErrorCode r213 = new ErrorCode("FILEINFO_IS_DELETED", 213, 5600);
        FILEINFO_IS_DELETED = r213;
        ErrorCode r214 = new ErrorCode("STATIC_RESOURCE_FROZEN_BY_ADMIN", 214, 5601);
        STATIC_RESOURCE_FROZEN_BY_ADMIN = r214;
        ErrorCode r215 = new ErrorCode("STATIC_RESOURCE_SHREDDED_BY_ADMIN", 215, 5602);
        STATIC_RESOURCE_SHREDDED_BY_ADMIN = r215;
        ErrorCode r216 = new ErrorCode("LARK_CERTIFICATE_DECRYPTION_KEY_INVALID", 216, 5603);
        LARK_CERTIFICATE_DECRYPTION_KEY_INVALID = r216;
        ErrorCode r217 = new ErrorCode("CHAT_CROSS_WITH_KA_UNSUPPORTED_MESSAGE_TYPE", 217, 5604);
        CHAT_CROSS_WITH_KA_UNSUPPORTED_MESSAGE_TYPE = r217;
        ErrorCode r218 = new ErrorCode("STATIC_RESOURCE_DOWNLOAD_LAN_FILE_FROM_SERVER", 218, 5605);
        STATIC_RESOURCE_DOWNLOAD_LAN_FILE_FROM_SERVER = r218;
        ErrorCode r219 = new ErrorCode("FG_KA_CROSS_SEND_MESSAGE_FORBID", 219, 5606);
        FG_KA_CROSS_SEND_MESSAGE_FORBID = r219;
        ErrorCode r220 = new ErrorCode("STATIC_RESOURCE_DELETED_BY_ADMIN", 220, 5607);
        STATIC_RESOURCE_DELETED_BY_ADMIN = r220;
        ErrorCode r221 = new ErrorCode("STATIC_RESOURCE_NOT_EXIST", 221, 5608);
        STATIC_RESOURCE_NOT_EXIST = r221;
        ErrorCode r222 = new ErrorCode("STATIC_RESOURCE_UPLOAD_NOT_COMPLETE", 222, 5609);
        STATIC_RESOURCE_UPLOAD_NOT_COMPLETE = r222;
        ErrorCode r223 = new ErrorCode("IM_STORAGE_DELETED_BY_ADMIN", 223, 5610);
        IM_STORAGE_DELETED_BY_ADMIN = r223;
        ErrorCode r224 = new ErrorCode("IM_STORAGE_DESTROY_BY_ADMIN", 224, 5611);
        IM_STORAGE_DESTROY_BY_ADMIN = r224;
        ErrorCode r225 = new ErrorCode("IM_STORAGE_CAPACITY_LIMIT", 225, 5612);
        IM_STORAGE_CAPACITY_LIMIT = r225;
        ErrorCode r226 = new ErrorCode("IM_FILE_PARAM_NOT_SUPPORT", 226, 5613);
        IM_FILE_PARAM_NOT_SUPPORT = r226;
        ErrorCode r227 = new ErrorCode("IM_FILE_API_NOT_AVAILABLE", 227, 5614);
        IM_FILE_API_NOT_AVAILABLE = r227;
        ErrorCode r228 = new ErrorCode("IM_FILE_API_QPS_LIMIT", 228, 5615);
        IM_FILE_API_QPS_LIMIT = r228;
        ErrorCode r229 = new ErrorCode("IM_FILE_DELETE_BY_CSAM", 229, 5616);
        IM_FILE_DELETE_BY_CSAM = r229;
        ErrorCode r230 = new ErrorCode("IM_USER_STORAGE_QUOTA_LIMIT", 230, 5617);
        IM_USER_STORAGE_QUOTA_LIMIT = r230;
        ErrorCode r231 = new ErrorCode("IM_DEPARTMENT_STORAGE_QUOTA_LIMIT", 231, 5618);
        IM_DEPARTMENT_STORAGE_QUOTA_LIMIT = r231;
        ErrorCode r232 = new ErrorCode("IM_TENANT_STORAGE_QUOTA_LIMIT", 232, 5619);
        IM_TENANT_STORAGE_QUOTA_LIMIT = r232;
        ErrorCode r233 = new ErrorCode("IM_FILE_DATA_RETENTION", 233, 5620);
        IM_FILE_DATA_RETENTION = r233;
        ErrorCode r234 = new ErrorCode("IM_STORAGE_DESTROY_BY_OWN", 234, 5621);
        IM_STORAGE_DESTROY_BY_OWN = r234;
        ErrorCode r235 = new ErrorCode("REQUEST_OVER_FREQUENCY", 235, 5650);
        REQUEST_OVER_FREQUENCY = r235;
        ErrorCode r236 = new ErrorCode("INVALID_FACE_TO_FACE_TOKEN", 236, 5651);
        INVALID_FACE_TO_FACE_TOKEN = r236;
        ErrorCode r237 = new ErrorCode("STATIC_RESOURCE_UPLOAD_RISKY_NAME", 237, 5652);
        STATIC_RESOURCE_UPLOAD_RISKY_NAME = r237;
        ErrorCode r238 = new ErrorCode("STATIC_RESOURCE_DOWNLOAD_RISKY_NAME", 238, 5653);
        STATIC_RESOURCE_DOWNLOAD_RISKY_NAME = r238;
        ErrorCode r239 = new ErrorCode("STATIC_RESOURCE_UPLOAD_FOLDER_EMPTY", 239, 5654);
        STATIC_RESOURCE_UPLOAD_FOLDER_EMPTY = r239;
        ErrorCode r240 = new ErrorCode("STATIC_RESOURCE_FOLDER_DEPTH_EXCEED_LIMIT", 240, 5655);
        STATIC_RESOURCE_FOLDER_DEPTH_EXCEED_LIMIT = r240;
        ErrorCode r241 = new ErrorCode("STATIC_RESOURCE_FOLDER_SUB_FILES_NUMBER_EXCEED_LIMIT", 241, 5656);
        STATIC_RESOURCE_FOLDER_SUB_FILES_NUMBER_EXCEED_LIMIT = r241;
        ErrorCode r242 = new ErrorCode("STATIC_RESOURCE_UNCOMPRESS_UNABLE", 242, 5657);
        STATIC_RESOURCE_UNCOMPRESS_UNABLE = r242;
        ErrorCode r243 = new ErrorCode("STATIC_RESOURCE_UNCOMPRESS_NOT_ALLOW", 243, 5658);
        STATIC_RESOURCE_UNCOMPRESS_NOT_ALLOW = r243;
        ErrorCode r244 = new ErrorCode("STATIC_RESOURCE_UNCOMPRESS_UNSUPPORT_FORMAT", 244, 5659);
        STATIC_RESOURCE_UNCOMPRESS_UNSUPPORT_FORMAT = r244;
        ErrorCode r245 = new ErrorCode("STATIC_RESOURCE_UNCOMPRESS_SIZE_EXCEED_LIMIT", 245, 5660);
        STATIC_RESOURCE_UNCOMPRESS_SIZE_EXCEED_LIMIT = r245;
        ErrorCode r246 = new ErrorCode("STATIC_RESOURCE_UNCOMPRESS_DEPTH_EXCEED_LIMIT", 246, 5661);
        STATIC_RESOURCE_UNCOMPRESS_DEPTH_EXCEED_LIMIT = r246;
        ErrorCode r247 = new ErrorCode("STATIC_RESOURCE_UNCOMPRESS_SUB_FILES_NUMBER_EXCEED_LIMIT", 247, 5662);
        STATIC_RESOURCE_UNCOMPRESS_SUB_FILES_NUMBER_EXCEED_LIMIT = r247;
        ErrorCode r248 = new ErrorCode("STATIC_RESOURCE_IMAGE_OCR_FAILED", 248, 5663);
        STATIC_RESOURCE_IMAGE_OCR_FAILED = r248;
        ErrorCode r249 = new ErrorCode("STATIC_RESOURCE_API_HARDLINK_FAILED", 249, 5664);
        STATIC_RESOURCE_API_HARDLINK_FAILED = r249;
        ErrorCode r250 = new ErrorCode("STATIC_RESOURCE_API_HARDLINK_Key_EXCEED_LIMIT", 250, 5665);
        STATIC_RESOURCE_API_HARDLINK_Key_EXCEED_LIMIT = r250;
        ErrorCode r251 = new ErrorCode("STATIC_RESOURCE_COMPRESSED_FOLDER_GONE", 251, 5666);
        STATIC_RESOURCE_COMPRESSED_FOLDER_GONE = r251;
        ErrorCode r252 = new ErrorCode("STATIC_RESOURCE_INVALID_COMPRESS_ALGORITHM", 252, 5667);
        STATIC_RESOURCE_INVALID_COMPRESS_ALGORITHM = r252;
        ErrorCode r253 = new ErrorCode("CHAT_ADMIN_USER_REACH_LIMIT", 253, 5700);
        CHAT_ADMIN_USER_REACH_LIMIT = r253;
        ErrorCode r254 = new ErrorCode("ADD_CHAT_CHATTER_APPLY_ALREADY_PROCESSED", 254, 5701);
        ADD_CHAT_CHATTER_APPLY_ALREADY_PROCESSED = r254;
        ErrorCode r255 = new ErrorCode("CURRENT_CHAT_NOT_CAN_SET_SEARCH", 255, 5702);
        CURRENT_CHAT_NOT_CAN_SET_SEARCH = r255;
        ErrorCode r256 = new ErrorCode("SEND_MISSING_CRYPTO_MESSAGE_MISSING_CONTENT", 256, 5703);
        SEND_MISSING_CRYPTO_MESSAGE_MISSING_CONTENT = r256;
        ErrorCode r257 = new ErrorCode("SEND_MISSING_CRYPTO_MESSAGE_MISSING_MAIN_CONTENT", 257, 5704);
        SEND_MISSING_CRYPTO_MESSAGE_MISSING_MAIN_CONTENT = r257;
        ErrorCode r258 = new ErrorCode("PULL_GROUP_CHAT_MEMBER_VERSION_RETRY", 258, 5705);
        PULL_GROUP_CHAT_MEMBER_VERSION_RETRY = r258;
        ErrorCode r259 = new ErrorCode("CREATE_MESSAGE_INVALID_SHARED_GROUP_CHAT", 259, 5800);
        CREATE_MESSAGE_INVALID_SHARED_GROUP_CHAT = r259;
        ErrorCode r260 = new ErrorCode("CREATE_MESSAGE_BLOCK_IN_THREAD_DISPLAY_MODE", 260, 5801);
        CREATE_MESSAGE_BLOCK_IN_THREAD_DISPLAY_MODE = r260;
        ErrorCode r261 = new ErrorCode("CREATE_MESSAGE_SHARE_USER_CARD_NO_FRIENDSHIP", 261, 5802);
        CREATE_MESSAGE_SHARE_USER_CARD_NO_FRIENDSHIP = r261;
        ErrorCode r262 = new ErrorCode("CREATE_MESSAGE_GENERATION_SHARE_CARD_FAILURE", 262, 5803);
        CREATE_MESSAGE_GENERATION_SHARE_CARD_FAILURE = r262;
        ErrorCode r263 = new ErrorCode("PRICING_PACKAGE", 263, 6000);
        PRICING_PACKAGE = r263;
        ErrorCode r264 = new ErrorCode("PRICING_PACKAGE_URGENT_REACH_LIMIT", 264, 6001);
        PRICING_PACKAGE_URGENT_REACH_LIMIT = r264;
        ErrorCode r265 = new ErrorCode("PRICING_PACKAGE_ADD_CHAT_CHATTER_REACH_LIMIT", 265, 6002);
        PRICING_PACKAGE_ADD_CHAT_CHATTER_REACH_LIMIT = r265;
        ErrorCode r266 = new ErrorCode("PRICING_PACKAGE_CRYPTO_CHAT_DISALLOWED", 266, 6003);
        PRICING_PACKAGE_CRYPTO_CHAT_DISALLOWED = r266;
        ErrorCode r267 = new ErrorCode("PRICING_PACKAGE_CRYPTO_CHAT_URGENT_DISALLOWED", 267, 6004);
        PRICING_PACKAGE_CRYPTO_CHAT_URGENT_DISALLOWED = r267;
        ErrorCode r268 = new ErrorCode("PRICING_PACKAGE_AUTO_TRANSLATE_DISALLOWED", 268, 6005);
        PRICING_PACKAGE_AUTO_TRANSLATE_DISALLOWED = r268;
        ErrorCode r269 = new ErrorCode("LARK_FAV_LAN_TRANS_FILE_REFUSE", 269, 6200);
        LARK_FAV_LAN_TRANS_FILE_REFUSE = r269;
        ErrorCode r270 = new ErrorCode("ANALYZE_SHEET_NO_EDIT_PERM", 270, 7001);
        ANALYZE_SHEET_NO_EDIT_PERM = r270;
        ErrorCode r271 = new ErrorCode("ANALYZE_SHEET_EMPTY_FILE", 271, 7002);
        ANALYZE_SHEET_EMPTY_FILE = r271;
        ErrorCode r272 = new ErrorCode("ANALYZE_SHEET_REACH_CHAT_CHATTER_COUNT_LIMIT", 272, 7003);
        ANALYZE_SHEET_REACH_CHAT_CHATTER_COUNT_LIMIT = r272;
        ErrorCode r273 = new ErrorCode("ANALYZE_SHEET_FAIL", 273, 7004);
        ANALYZE_SHEET_FAIL = r273;
        ErrorCode r274 = new ErrorCode("CHAT_SECURITY_CHECK_BLOCK", 274, 7005);
        CHAT_SECURITY_CHECK_BLOCK = r274;
        ErrorCode r275 = new ErrorCode("BLOCK_BY_STRANGER_RELATION", 275, 7006);
        BLOCK_BY_STRANGER_RELATION = r275;
        ErrorCode r276 = new ErrorCode("CHAT_BANNED_BY_TNS", 276, 7007);
        CHAT_BANNED_BY_TNS = r276;
        ErrorCode r277 = new ErrorCode("BLOCK_BY_SHARK", 277, 7008);
        BLOCK_BY_SHARK = r277;
        ErrorCode r278 = new ErrorCode("CERT_TENANT_ADD_CHAT_CHATTER_REACH_LIMIT", 278, 7010);
        CERT_TENANT_ADD_CHAT_CHATTER_REACH_LIMIT = r278;
        ErrorCode r279 = new ErrorCode("CHAT_USER_OVER_LIMIT_NEED_APPLY", 279, 7011);
        CHAT_USER_OVER_LIMIT_NEED_APPLY = r279;
        ErrorCode r280 = new ErrorCode("CROSS_TENANT_CHAT_USER_OVER_LIMIT_NEED_APPLY", 280, 7012);
        CROSS_TENANT_CHAT_USER_OVER_LIMIT_NEED_APPLY = r280;
        ErrorCode r281 = new ErrorCode("CHAT_PIN_NUM_REACH_LIMIT", 281, 7100);
        CHAT_PIN_NUM_REACH_LIMIT = r281;
        ErrorCode r282 = new ErrorCode("CHAT_NAME_TRANSLATE_FAILED", 282, 7200);
        CHAT_NAME_TRANSLATE_FAILED = r282;
        ErrorCode r283 = new ErrorCode("HONGBAO_LICENSE_AUTH_FAILED", 283, 9000);
        HONGBAO_LICENSE_AUTH_FAILED = r283;
        ErrorCode r284 = new ErrorCode("STICKER_SET_ALREADY_EXISTS", 284, 11001);
        STICKER_SET_ALREADY_EXISTS = r284;
        ErrorCode r285 = new ErrorCode("MAIL_ADD_CHANGE_OUT_OF_SYNC", 285, 250000);
        MAIL_ADD_CHANGE_OUT_OF_SYNC = r285;
        ErrorCode r286 = new ErrorCode("MAIL_USER_ID_DEVICE_ID_PROCESSED_LIMIT", 286, 250001);
        MAIL_USER_ID_DEVICE_ID_PROCESSED_LIMIT = r286;
        ErrorCode r287 = new ErrorCode("MAIL_ADD_CHANGE_IS_PROCESSING", 287, 250002);
        MAIL_ADD_CHANGE_IS_PROCESSING = r287;
        ErrorCode r288 = new ErrorCode("MAIL_NO_DRIVE_PERMISSION", 288, 250003);
        MAIL_NO_DRIVE_PERMISSION = r288;
        ErrorCode r289 = new ErrorCode("MAIL_ADD_CHANGE_NO_IMPLEMENTED", 289, 250004);
        MAIL_ADD_CHANGE_NO_IMPLEMENTED = r289;
        ErrorCode r290 = new ErrorCode("MAIL_COMMON_DB_ERROR", 290, 250005);
        MAIL_COMMON_DB_ERROR = r290;
        ErrorCode r291 = new ErrorCode("MAIL_COMMON_RPC_FAIL", 291, 250006);
        MAIL_COMMON_RPC_FAIL = r291;
        ErrorCode r292 = new ErrorCode("MAIL_COMMON_PARAM_INVALID", 292, 250007);
        MAIL_COMMON_PARAM_INVALID = r292;
        ErrorCode r293 = new ErrorCode("MAIL_USER_ID_COMMAND_PROCESSED_LIMIT", 293, 250008);
        MAIL_USER_ID_COMMAND_PROCESSED_LIMIT = r293;
        ErrorCode r294 = new ErrorCode("MAIL_BASIC_EMAIl_PERMISSION_DISABLE", 294, 250009);
        MAIL_BASIC_EMAIl_PERMISSION_DISABLE = r294;
        ErrorCode r295 = new ErrorCode("MAIL_REQUEST_PARAMS_LENGTH_LIMIT", 295, 250101);
        MAIL_REQUEST_PARAMS_LENGTH_LIMIT = r295;
        ErrorCode r296 = new ErrorCode("MAIL_MESSAGE_SENT_LONG_TIME_AGO", 296, 250201);
        MAIL_MESSAGE_SENT_LONG_TIME_AGO = r296;
        ErrorCode r297 = new ErrorCode("MAIL_MESSAGE_NOT_IN_SENT_STATE", 297, 250202);
        MAIL_MESSAGE_NOT_IN_SENT_STATE = r297;
        ErrorCode r298 = new ErrorCode("MAIL_MESSAGE_HAS_BEEN_RECALLED", 298, 250203);
        MAIL_MESSAGE_HAS_BEEN_RECALLED = r298;
        ErrorCode r299 = new ErrorCode("MAIL_LONG_RUNNING_TASK_BLOCK", 299, 250301);
        MAIL_LONG_RUNNING_TASK_BLOCK = r299;
        ErrorCode r300 = new ErrorCode("MAIL_LONG_RUNNING_TASK_BLOCK_NO_RETRY", 300, 250302);
        MAIL_LONG_RUNNING_TASK_BLOCK_NO_RETRY = r300;
        ErrorCode r301 = new ErrorCode("MAIL_LONG_RUNNING_TASK_SERVER_LIMIT", 301, 250303);
        MAIL_LONG_RUNNING_TASK_SERVER_LIMIT = r301;
        ErrorCode r302 = new ErrorCode("MAIL_LONG_RUNNING_TASK_MIGRATION_REJECT", 302, 250304);
        MAIL_LONG_RUNNING_TASK_MIGRATION_REJECT = r302;
        ErrorCode r303 = new ErrorCode("MAIL_GROUP_MANAGEMENT_PERMISSION_DENIED", 303, 250401);
        MAIL_GROUP_MANAGEMENT_PERMISSION_DENIED = r303;
        ErrorCode r304 = new ErrorCode("MAIL_OVER_LIMIT_COUNT", 304, 250402);
        MAIL_OVER_LIMIT_COUNT = r304;
        ErrorCode r305 = new ErrorCode("MAIL_NOT_VALID_ADDRESS", 305, 250403);
        MAIL_NOT_VALID_ADDRESS = r305;
        ErrorCode r306 = new ErrorCode("MAIL_GROUP_NOT_FOUND", 306, 250404);
        MAIL_GROUP_NOT_FOUND = r306;
        ErrorCode r307 = new ErrorCode("MAIL_GROUP_VIEW_PERMISSION_DENIED", 307, 250405);
        MAIL_GROUP_VIEW_PERMISSION_DENIED = r307;
        ErrorCode r308 = new ErrorCode("MAIL_GROUP_UNSUBSCRIBE_DENIED", 308, 250406);
        MAIL_GROUP_UNSUBSCRIBE_DENIED = r308;
        ErrorCode r309 = new ErrorCode("MAIL_GROUP_UNSUBSCRIBE_TYPE_UNSUPPORTED", 309, 250407);
        MAIL_GROUP_UNSUBSCRIBE_TYPE_UNSUPPORTED = r309;
        ErrorCode r310 = new ErrorCode("MAIL_USER_ALLOW_BLOCK_DATA_INVALID", 310, 250450);
        MAIL_USER_ALLOW_BLOCK_DATA_INVALID = r310;
        ErrorCode r311 = new ErrorCode("MAIL_USER_ALLOW_BLOCK_SELF_ADDRESS", 311, 250451);
        MAIL_USER_ALLOW_BLOCK_SELF_ADDRESS = r311;
        ErrorCode r312 = new ErrorCode("MAIL_USER_ALLOW_BLOCK_SELF_DOMAIN", 312, 250452);
        MAIL_USER_ALLOW_BLOCK_SELF_DOMAIN = r312;
        ErrorCode r313 = new ErrorCode("MAIL_SIGNATURE_NAME_DUPLICATE", 313, 250501);
        MAIL_SIGNATURE_NAME_DUPLICATE = r313;
        ErrorCode r314 = new ErrorCode("MAIL_SIGNATURE_INVALID_OPERATE_USER", 314, 250502);
        MAIL_SIGNATURE_INVALID_OPERATE_USER = r314;
        ErrorCode r315 = new ErrorCode("MAIL_IMAGE_NO_PERMISSION", 315, 250503);
        MAIL_IMAGE_NO_PERMISSION = r315;
        ErrorCode r316 = new ErrorCode("MAIL_NAME_CARD_INVALID_OPERATE_USER", 316, 250504);
        MAIL_NAME_CARD_INVALID_OPERATE_USER = r316;
        ErrorCode r317 = new ErrorCode("MAIL_SEARCH_BAD_REQUEST", 317, 250505);
        MAIL_SEARCH_BAD_REQUEST = r317;
        ErrorCode r318 = new ErrorCode("MAIL_READ_STATISTICS_RESULT_NOT_READY", 318, 250550);
        MAIL_READ_STATISTICS_RESULT_NOT_READY = r318;
        ErrorCode r319 = new ErrorCode("MAIL_MESSAGE_NOT_EXIST", 319, 250601);
        MAIL_MESSAGE_NOT_EXIST = r319;
        ErrorCode r320 = new ErrorCode("MAIL_GROUP_CHAT_AUTH_PERMISSION_DENIED", 320, 250602);
        MAIL_GROUP_CHAT_AUTH_PERMISSION_DENIED = r320;
        ErrorCode r321 = new ErrorCode("MAIL_GROUP_CHAT_TYPE_PERMISSION_DENIED", 321, 250603);
        MAIL_GROUP_CHAT_TYPE_PERMISSION_DENIED = r321;
        ErrorCode r322 = new ErrorCode("MAIL_GROUP_CHAT_TENANT_PERMISSION_DENIED", 322, 250604);
        MAIL_GROUP_CHAT_TENANT_PERMISSION_DENIED = r322;
        ErrorCode r323 = new ErrorCode("MAIL_GROUP_CHAT_TENANT_DOMAIN_NOT_VALID", 323, 250605);
        MAIL_GROUP_CHAT_TENANT_DOMAIN_NOT_VALID = r323;
        ErrorCode r324 = new ErrorCode("MAIL_MAIL_STATE_ILLEGAL", 324, 250701);
        MAIL_MAIL_STATE_ILLEGAL = r324;
        ErrorCode r325 = new ErrorCode("MAIL_UPLOAD_EML_SIZE_TOO_LARGE", 325, 250702);
        MAIL_UPLOAD_EML_SIZE_TOO_LARGE = r325;
        ErrorCode r326 = new ErrorCode("MAIL_UPLOAD_EML_GET_LOCK_FAIL", 326, 250703);
        MAIL_UPLOAD_EML_GET_LOCK_FAIL = r326;
        ErrorCode r327 = new ErrorCode("MAIL_DEDUPLICATE_DELETE", 327, 250800);
        MAIL_DEDUPLICATE_DELETE = r327;
        ErrorCode r328 = new ErrorCode("MAIL_SEND_READ_RECEIPT_DEDUPLICATE", 328, 250801);
        MAIL_SEND_READ_RECEIPT_DEDUPLICATE = r328;
        ErrorCode r329 = new ErrorCode("MAIL_TEMPLATE_INVALID_TEMPLATE_NAME", 329, 250850);
        MAIL_TEMPLATE_INVALID_TEMPLATE_NAME = r329;
        ErrorCode r330 = new ErrorCode("MAIL_TEMPLATE_TEMPLATE_NUMBER_LIMIT", 330, 250851);
        MAIL_TEMPLATE_TEMPLATE_NUMBER_LIMIT = r330;
        ErrorCode r331 = new ErrorCode("MAIL_TEMPLATE_CONTENT_SIZE_LIMIT", 331, 250852);
        MAIL_TEMPLATE_CONTENT_SIZE_LIMIT = r331;
        ErrorCode r332 = new ErrorCode("MAIL_TEMPLATE_INVALID_TEMPLATE_ID", 332, 250853);
        MAIL_TEMPLATE_INVALID_TEMPLATE_ID = r332;
        ErrorCode r333 = new ErrorCode("MAIL_TEMPLATE_BATCH_SIZE_LIMIT", 333, 250854);
        MAIL_TEMPLATE_BATCH_SIZE_LIMIT = r333;
        ErrorCode r334 = new ErrorCode("MAIL_TEMPLATE_TOTAL_SIZE_LIMIT", 334, 250855);
        MAIL_TEMPLATE_TOTAL_SIZE_LIMIT = r334;
        ErrorCode r335 = new ErrorCode("MAIL_TEMPLATE_OTHER_PARAM_ERROR", 335, 250858);
        MAIL_TEMPLATE_OTHER_PARAM_ERROR = r335;
        ErrorCode r336 = new ErrorCode("MAIL_FEED_NOT_EXTERNAL_ADDRESS", 336, 250901);
        MAIL_FEED_NOT_EXTERNAL_ADDRESS = r336;
        ErrorCode r337 = new ErrorCode("MAIL_FEED_FOLLOWEE_NOT_EXISTS", 337, 250902);
        MAIL_FEED_FOLLOWEE_NOT_EXISTS = r337;
        ErrorCode r338 = new ErrorCode("MAIL_AI_ACTION_ID_INVALID", 338, 250903);
        MAIL_AI_ACTION_ID_INVALID = r338;
        ErrorCode r339 = new ErrorCode("MAIL_AI_PUSH_ONBOARDING_CARD_VERSION_OVERDUE", 339, 250904);
        MAIL_AI_PUSH_ONBOARDING_CARD_VERSION_OVERDUE = r339;
        ErrorCode r340 = new ErrorCode("MAIL_AI_PUSH_ONBOARDING_CARD_LAST_MSG_ID_NOT_FOUND", 340, 250905);
        MAIL_AI_PUSH_ONBOARDING_CARD_LAST_MSG_ID_NOT_FOUND = r340;
        ErrorCode r341 = new ErrorCode("COLLABORATION_AUTH_FAILED_BLOCKED", 341, 260000);
        COLLABORATION_AUTH_FAILED_BLOCKED = r341;
        ErrorCode r342 = new ErrorCode("COLLABORATION_AUTH_FAILED_NO_RIGHTS", 342, 260001);
        COLLABORATION_AUTH_FAILED_NO_RIGHTS = r342;
        ErrorCode r343 = new ErrorCode("COLLABORATION_SEND_MSG_REACH_LIMIT", 343, 260002);
        COLLABORATION_SEND_MSG_REACH_LIMIT = r343;
        ErrorCode r344 = new ErrorCode("COLLABORATION_AUTH_FAILED_BE_BLOCKED", 344, 260003);
        COLLABORATION_AUTH_FAILED_BE_BLOCKED = r344;
        ErrorCode r345 = new ErrorCode("COLLABORATION_AUTH_FAILED_PRIVACY_SETTING", 345, 260004);
        COLLABORATION_AUTH_FAILED_PRIVACY_SETTING = r345;
        ErrorCode r346 = new ErrorCode("COLLABORATION_AUTH_FAILED_TARGET_PRIVACY_SETTING", 346, 260005);
        COLLABORATION_AUTH_FAILED_TARGET_PRIVACY_SETTING = r346;
        ErrorCode r347 = new ErrorCode("CHAT_WITH_NO_CONTACTS_REACH_DAILY_LIMIT", 347, 260006);
        CHAT_WITH_NO_CONTACTS_REACH_DAILY_LIMIT = r347;
        ErrorCode r348 = new ErrorCode("COLLABORATION_AUTH_NO_PERMISSION", 348, 260007);
        COLLABORATION_AUTH_NO_PERMISSION = r348;
        ErrorCode r349 = new ErrorCode("EXTERNAL_COORDINATE_CTL", 349, 260008);
        EXTERNAL_COORDINATE_CTL = r349;
        ErrorCode r350 = new ErrorCode("TARGET_EXTERNAL_COORDINATE_CTL", 350, 260009);
        TARGET_EXTERNAL_COORDINATE_CTL = r350;
        ErrorCode r351 = new ErrorCode("COLLABORATION_AUTH_P2P_SEND_MESSAGE_FAILED", 351, 260010);
        COLLABORATION_AUTH_P2P_SEND_MESSAGE_FAILED = r351;
        ErrorCode r352 = new ErrorCode("COLLABORATION_AUTH_P2P_BOT_SEND_MESSAGE_FAILED", 352, 260011);
        COLLABORATION_AUTH_P2P_BOT_SEND_MESSAGE_FAILED = r352;
        ErrorCode r353 = new ErrorCode("AUTH_MESSAGE_FAILED_RETRY", 353, 260012);
        AUTH_MESSAGE_FAILED_RETRY = r353;
        ErrorCode r354 = new ErrorCode("COLLABORATION_AUTH_FAILED_CAN_APPLY", 354, 260013);
        COLLABORATION_AUTH_FAILED_CAN_APPLY = r354;
        ErrorCode r355 = new ErrorCode("COLLABORATION_NO_SEND_MESSAGE_TO_MY_AI", 355, 260014);
        COLLABORATION_NO_SEND_MESSAGE_TO_MY_AI = r355;
        ErrorCode r356 = new ErrorCode("CONTACT_NUM_EXCEED_LIMIT", 356, 270000);
        CONTACT_NUM_EXCEED_LIMIT = r356;
        ErrorCode r357 = new ErrorCode("NEW_CONTACT_EXCEED_LIMIT", 357, 270001);
        NEW_CONTACT_EXCEED_LIMIT = r357;
        ErrorCode r358 = new ErrorCode("CONTACT_IN_SAME_TENANT", 358, 270002);
        CONTACT_IN_SAME_TENANT = r358;
        ErrorCode r359 = new ErrorCode("FORBID_ADD_SEARCH_DISABLE", 359, 270003);
        FORBID_ADD_SEARCH_DISABLE = r359;
        ErrorCode r360 = new ErrorCode("FORBID_ADD_NAME_CARD_DISABLE", 360, 270004);
        FORBID_ADD_NAME_CARD_DISABLE = r360;
        ErrorCode r361 = new ErrorCode("FORBID_ADD_LINK_DISABLE", 361, 270005);
        FORBID_ADD_LINK_DISABLE = r361;
        ErrorCode r362 = new ErrorCode("PLEASE_WAIT_GENERAL", 362, 270006);
        PLEASE_WAIT_GENERAL = r362;
        ErrorCode r363 = new ErrorCode("PLEASE_WAIT_MULTIPLE_USERS", 363, 270007);
        PLEASE_WAIT_MULTIPLE_USERS = r363;
        ErrorCode r364 = new ErrorCode("CANT_ADD_CONTACT_BE_BLOCKED", 364, 270008);
        CANT_ADD_CONTACT_BE_BLOCKED = r364;
        ErrorCode r365 = new ErrorCode("CANT_ADD_CONTACT_BLOCK_OTHER", 365, 270009);
        CANT_ADD_CONTACT_BLOCK_OTHER = r365;
        ErrorCode r366 = new ErrorCode("CONTACT_REQUEST_SENT_PLEASE_WAIT", 366, 270010);
        CONTACT_REQUEST_SENT_PLEASE_WAIT = r366;
        ErrorCode r367 = new ErrorCode("APPLICATION_REASON_EXCEED_LIMIT", 367, 270011);
        APPLICATION_REASON_EXCEED_LIMIT = r367;
        ErrorCode r368 = new ErrorCode("UNKNOWN_SYSTEM_ERROR", 368, 280000);
        UNKNOWN_SYSTEM_ERROR = r368;
        ErrorCode r369 = new ErrorCode("ILLEGAL_REQUEST_ERROR", 369, 280001);
        ILLEGAL_REQUEST_ERROR = r369;
        ErrorCode r370 = new ErrorCode("OAUTH_SERVER_ERROR", 370, 280002);
        OAUTH_SERVER_ERROR = r370;
        ErrorCode r371 = new ErrorCode("OAUTH_INVALID_STATE", 371, 280003);
        OAUTH_INVALID_STATE = r371;
        ErrorCode r372 = new ErrorCode("OAUTH_INVALID_CODE", 372, 280004);
        OAUTH_INVALID_CODE = r372;
        ErrorCode r373 = new ErrorCode("OAUTH_NOT_AUTHORIZED", 373, 280005);
        OAUTH_NOT_AUTHORIZED = r373;
        ErrorCode r374 = new ErrorCode("OAUTH_INVALID_CHANNEL", 374, 280006);
        OAUTH_INVALID_CHANNEL = r374;
        ErrorCode r375 = new ErrorCode("ZAXIS_UNKNOWN_SYSTEM_ERROR", 375, 290000);
        ZAXIS_UNKNOWN_SYSTEM_ERROR = r375;
        ErrorCode r376 = new ErrorCode("ZAXIS_BAD_REQUEST", 376, 290001);
        ZAXIS_BAD_REQUEST = r376;
        ErrorCode r377 = new ErrorCode("ZAXIS_INVALID_AUTH_CODE", 377, 290002);
        ZAXIS_INVALID_AUTH_CODE = r377;
        ErrorCode r378 = new ErrorCode("ZAXIS_INVALID_AUTH_TOKEN", 378, 290003);
        ZAXIS_INVALID_AUTH_TOKEN = r378;
        ErrorCode r379 = new ErrorCode("ZAXIS_NOT_AUTHORIZED", 379, 290004);
        ZAXIS_NOT_AUTHORIZED = r379;
        ErrorCode r380 = new ErrorCode("ZAXIS_NOT_LOGGED_IN", 380, 290005);
        ZAXIS_NOT_LOGGED_IN = r380;
        ErrorCode r381 = new ErrorCode("ZAXIS_ENTITY_NOT_FOUND", 381, 290006);
        ZAXIS_ENTITY_NOT_FOUND = r381;
        ErrorCode r382 = new ErrorCode("ZAXIS_DEPENDENCY_ERROR", 382, 290007);
        ZAXIS_DEPENDENCY_ERROR = r382;
        ErrorCode r383 = new ErrorCode("ZAXIS_AUTH_REVOKED", 383, 290008);
        ZAXIS_AUTH_REVOKED = r383;
        ErrorCode r384 = new ErrorCode("EDU_UNKNOWN_SYSTEM_ERROR", 384, 300000);
        EDU_UNKNOWN_SYSTEM_ERROR = r384;
        ErrorCode r385 = new ErrorCode("EDU_NOT_AUTHORIZED", 385, 300001);
        EDU_NOT_AUTHORIZED = r385;
        ErrorCode r386 = new ErrorCode("EDU_CLASS_INVALID", 386, 300002);
        EDU_CLASS_INVALID = r386;
        ErrorCode r387 = new ErrorCode("EDU_HOME_SCHOOL_CHAT_CREATED", 387, 300003);
        EDU_HOME_SCHOOL_CHAT_CREATED = r387;
        ErrorCode r388 = new ErrorCode("EDU_INVITATION_SEND_MESSAGE_FREQUENCY", 388, 300004);
        EDU_INVITATION_SEND_MESSAGE_FREQUENCY = r388;
        ErrorCode r389 = new ErrorCode("DATA_EXPORT_TASK_NOT_FOUND", 389, 310000);
        DATA_EXPORT_TASK_NOT_FOUND = r389;
        ErrorCode r390 = new ErrorCode("DATA_EXPORT_REQUEST_PARAM_ERROR", 390, 310001);
        DATA_EXPORT_REQUEST_PARAM_ERROR = r390;
        ErrorCode r391 = new ErrorCode("DATA_EXPORT_CREATE_TASK_CONFLICT", 391, 310002);
        DATA_EXPORT_CREATE_TASK_CONFLICT = r391;
        ErrorCode r392 = new ErrorCode("DATA_EXPORT_EXECUTE_TASK_TIMEOUT", 392, 310003);
        DATA_EXPORT_EXECUTE_TASK_TIMEOUT = r392;
        ErrorCode r393 = new ErrorCode("DATA_EXPORT_ATTACHMENG_ID_ERROR", 393, 310004);
        DATA_EXPORT_ATTACHMENG_ID_ERROR = r393;
        ErrorCode r394 = new ErrorCode("DATA_EXPORT_TASK_TERMINATED", 394, 310005);
        DATA_EXPORT_TASK_TERMINATED = r394;
        ErrorCode r395 = new ErrorCode("DATA_EXPORT_TASK_ALREADY_EXIST", 395, 310006);
        DATA_EXPORT_TASK_ALREADY_EXIST = r395;
        ErrorCode r396 = new ErrorCode("DATA_EXPORT_REACH_TENANT_TASK_LIMIT", 396, 310007);
        DATA_EXPORT_REACH_TENANT_TASK_LIMIT = r396;
        ErrorCode r397 = new ErrorCode("DATA_EXPORT_REACH_GLOBAL_TASK_LIMIT", 397, 310008);
        DATA_EXPORT_REACH_GLOBAL_TASK_LIMIT = r397;
        ErrorCode r398 = new ErrorCode("DATA_EXPORT_NO_MESSAGE_MATCH_KEYWORDS", 398, 310009);
        DATA_EXPORT_NO_MESSAGE_MATCH_KEYWORDS = r398;
        ErrorCode r399 = new ErrorCode("DATA_EXPORT_INVALID_ATTACHMENT_INFO", 399, 310010);
        DATA_EXPORT_INVALID_ATTACHMENT_INFO = r399;
        ErrorCode r400 = new ErrorCode("DATA_EXPORT_CHAT_TTP_GEO_BLOCKED", 400, 310011);
        DATA_EXPORT_CHAT_TTP_GEO_BLOCKED = r400;
        ErrorCode r401 = new ErrorCode("DATA_EXPORT_USER_TTP_GEO_BLOCKED", 401, 310012);
        DATA_EXPORT_USER_TTP_GEO_BLOCKED = r401;
        ErrorCode r402 = new ErrorCode("EM_REDUNDANT_TASK", 402, 311000);
        EM_REDUNDANT_TASK = r402;
        ErrorCode r403 = new ErrorCode("EM_AUTH_FAILED", 403, 311001);
        EM_AUTH_FAILED = r403;
        ErrorCode r404 = new ErrorCode("EM_TASK_ALREADY_DONE", 404, 311002);
        EM_TASK_ALREADY_DONE = r404;
        ErrorCode r405 = new ErrorCode("EM_GET_DATA_FAILED", 405, 311003);
        EM_GET_DATA_FAILED = r405;
        ErrorCode r406 = new ErrorCode("INVALID_CIPHER_FAILED_TO_SEND_MESSAGE", 406, 311100);
        INVALID_CIPHER_FAILED_TO_SEND_MESSAGE = r406;
        ErrorCode r407 = new ErrorCode("INVALID_CIPHER_FAILED_TO_OPERATE_MESSAGE", 407, 311101);
        INVALID_CIPHER_FAILED_TO_OPERATE_MESSAGE = r407;
        ErrorCode r408 = new ErrorCode("INVALID_CIPHER_FAILED_TO_ACCESS_FILE", 408, 311102);
        INVALID_CIPHER_FAILED_TO_ACCESS_FILE = r408;
        ErrorCode r409 = new ErrorCode("INVALID_CIPHER_FAILED_TO_UPLOAD_FILE", 409, 311103);
        INVALID_CIPHER_FAILED_TO_UPLOAD_FILE = r409;
        ErrorCode r410 = new ErrorCode("MESSAGE_DLP_FAILED_TO_SEND_MESSAGE", 410, 311120);
        MESSAGE_DLP_FAILED_TO_SEND_MESSAGE = r410;
        ErrorCode r411 = new ErrorCode("MESSAGE_DLP_FAILED_TO_DOWNLOAD_FILE_DENY", 411, 311121);
        MESSAGE_DLP_FAILED_TO_DOWNLOAD_FILE_DENY = r411;
        ErrorCode r412 = new ErrorCode("MESSAGE_DLP_FAILED_TO_DOWNLOAD_ORIGIN_IMAGE_DENY", 412, 311122);
        MESSAGE_DLP_FAILED_TO_DOWNLOAD_ORIGIN_IMAGE_DENY = r412;
        ErrorCode r413 = new ErrorCode("MESSAGE_DLP_FAILED_TO_DOWNLOAD_FILE_DETECTING", 413, 311123);
        MESSAGE_DLP_FAILED_TO_DOWNLOAD_FILE_DETECTING = r413;
        ErrorCode r414 = new ErrorCode("MESSAGE_DLP_FAILED_TO_DOWNLOAD_ORIGIN_IMAGE_DETECTING", 414, 311124);
        MESSAGE_DLP_FAILED_TO_DOWNLOAD_ORIGIN_IMAGE_DETECTING = r414;
        ErrorCode r415 = new ErrorCode("MESSAGE_DLP_FAILED_TO_PREVIEW_FILE_DENY", 415, 311125);
        MESSAGE_DLP_FAILED_TO_PREVIEW_FILE_DENY = r415;
        ErrorCode r416 = new ErrorCode("MESSAGE_DLP_FAILED_TO_PIN_MESSAGE", 416, 311126);
        MESSAGE_DLP_FAILED_TO_PIN_MESSAGE = r416;
        ErrorCode r417 = new ErrorCode("MESSAGE_DLP_FAILED_TO_PUT_CHAT_TOP_NOTICE", 417, 311127);
        MESSAGE_DLP_FAILED_TO_PUT_CHAT_TOP_NOTICE = r417;
        ErrorCode r418 = new ErrorCode("MESSAGE_DLP_FAILED_TO_PUT_STICKERS", 418, 311128);
        MESSAGE_DLP_FAILED_TO_PUT_STICKERS = r418;
        ErrorCode r419 = new ErrorCode("MESSAGE_DLP_FAILED_TO_PULL_MESSAGE_LINK", 419, 311129);
        MESSAGE_DLP_FAILED_TO_PULL_MESSAGE_LINK = r419;
        ErrorCode r420 = new ErrorCode("SCHEDULE_MESSAGE_CHAT_PENDING_COUNT_OVER_LIMIT", 420, 311140);
        SCHEDULE_MESSAGE_CHAT_PENDING_COUNT_OVER_LIMIT = r420;
        ErrorCode r421 = new ErrorCode("SCHEDULE_MESSAGE_ENTITY_PENDING_COUNT_OVER_LIMIT", 421, 311141);
        SCHEDULE_MESSAGE_ENTITY_PENDING_COUNT_OVER_LIMIT = r421;
        ErrorCode r422 = new ErrorCode("SCHEDULE_MESSAGE_FAILED_TO_CREATE", 422, 311142);
        SCHEDULE_MESSAGE_FAILED_TO_CREATE = r422;
        ErrorCode r423 = new ErrorCode("SCHEDULE_MESSAGE_FAILED_TO_UPDATE", 423, 311143);
        SCHEDULE_MESSAGE_FAILED_TO_UPDATE = r423;
        ErrorCode r424 = new ErrorCode("SCHEDULE_MESSAGE_FAILED_TO_SEND_BY_USER_RESIGN", 424, 311144);
        SCHEDULE_MESSAGE_FAILED_TO_SEND_BY_USER_RESIGN = r424;
        ErrorCode r425 = new ErrorCode("RESTRICTED_MESSAGE_FORBID_OPEN_SWITCH", 425, 311145);
        RESTRICTED_MESSAGE_FORBID_OPEN_SWITCH = r425;
        ErrorCode r426 = new ErrorCode("RESTRICTED_MESSAGE_FORBID_CLOSE_SWITCH", 426, 311146);
        RESTRICTED_MESSAGE_FORBID_CLOSE_SWITCH = r426;
        ErrorCode r427 = new ErrorCode("RESTRICTED_MESSAGE_FORBID_FORWARD_MESSAGE", 427, 311147);
        RESTRICTED_MESSAGE_FORBID_FORWARD_MESSAGE = r427;
        ErrorCode r428 = new ErrorCode("RESTRICTED_MESSAGE_FAILED_TO_OPEN", 428, 311148);
        RESTRICTED_MESSAGE_FAILED_TO_OPEN = r428;
        ErrorCode r429 = new ErrorCode("RESTRICTED_MESSAGE_FAILED_TO_CLOSE", 429, 311149);
        RESTRICTED_MESSAGE_FAILED_TO_CLOSE = r429;
        ErrorCode r430 = new ErrorCode("LARK_IM_MESSAGERE_STRICTED_UNABLE", 430, 311150);
        LARK_IM_MESSAGERE_STRICTED_UNABLE = r430;
        ErrorCode r431 = new ErrorCode("RESTRICTED_MESSAGE_NOT_SUPPORT_SCENE", 431, 311151);
        RESTRICTED_MESSAGE_NOT_SUPPORT_SCENE = r431;
        ErrorCode r432 = new ErrorCode("RESTRICTED_MESSAGE_ALREADY_OPEN", 432, 311152);
        RESTRICTED_MESSAGE_ALREADY_OPEN = r432;
        ErrorCode r433 = new ErrorCode("RESTRICTED_MESSAGE_ALREADY_CLOSE", 433, 311153);
        RESTRICTED_MESSAGE_ALREADY_CLOSE = r433;
        ErrorCode r434 = new ErrorCode("RESTRICTED_MESSAGE_FORBID_PUT_LINK", 434, 311154);
        RESTRICTED_MESSAGE_FORBID_PUT_LINK = r434;
        ErrorCode r435 = new ErrorCode("MESSAGE_DISABLE_ACTION_FOR_RESTRICTED_MODE_BURNED", 435, 311155);
        MESSAGE_DISABLE_ACTION_FOR_RESTRICTED_MODE_BURNED = r435;
        ErrorCode r436 = new ErrorCode("MESSAGE_RESTRICTED_MODE_WILL_BURNED", 436, 311156);
        MESSAGE_RESTRICTED_MODE_WILL_BURNED = r436;
        ErrorCode r437 = new ErrorCode("MESSAGE_RESTRICTED_MODE_IS_BURNED", 437, 311157);
        MESSAGE_RESTRICTED_MODE_IS_BURNED = r437;
        ErrorCode r438 = new ErrorCode("MESSAGE_IS_CLEANED", 438, 311158);
        MESSAGE_IS_CLEANED = r438;
        ErrorCode r439 = new ErrorCode("MYAI_CHAT_MESSAGE_NOT_SUPPORT_OPERATION", 439, 311159);
        MYAI_CHAT_MESSAGE_NOT_SUPPORT_OPERATION = r439;
        ErrorCode r440 = new ErrorCode("SYNCTOCHAT_MESSAGE_FORBID_REPLY_IN_THREAD", 440, 311160);
        SYNCTOCHAT_MESSAGE_FORBID_REPLY_IN_THREAD = r440;
        ErrorCode r441 = new ErrorCode("RETENTION_BATCH_DELETE_CHAT_NOT_SUPPORT", 441, 311161);
        RETENTION_BATCH_DELETE_CHAT_NOT_SUPPORT = r441;
        ErrorCode r442 = new ErrorCode("RETENTION_BATCH_DELETE_NO_MESSAGE_NEED_DELETE", 442, 311162);
        RETENTION_BATCH_DELETE_NO_MESSAGE_NEED_DELETE = r442;
        ErrorCode r443 = new ErrorCode("RETENTION_BATCH_DELETE_NOT_SUPPORT_MESSAGE_ACTION", 443, 311163);
        RETENTION_BATCH_DELETE_NOT_SUPPORT_MESSAGE_ACTION = r443;
        ErrorCode r444 = new ErrorCode("SYNCTOCHAT_OPERATE_NOT_SUPPORT_THIS_SCENE", 444, 311164);
        SYNCTOCHAT_OPERATE_NOT_SUPPORT_THIS_SCENE = r444;
        ErrorCode r445 = new ErrorCode("PUT_OTHER_TENANT_REACTION", 445, 311165);
        PUT_OTHER_TENANT_REACTION = r445;
        ErrorCode r446 = new ErrorCode("CREATE_MESSAGE_WITH_SOURCE_BOT_NO_PERMISSION", 446, 311166);
        CREATE_MESSAGE_WITH_SOURCE_BOT_NO_PERMISSION = r446;
        ErrorCode r447 = new ErrorCode("CREATE_MESSAGE_WITH_SOURCE_OWNERID_INVALID", 447, 311167);
        CREATE_MESSAGE_WITH_SOURCE_OWNERID_INVALID = r447;
        ErrorCode r448 = new ErrorCode("CREATE_MESSAGE_WITH_SOURCE_PARAM_INCOMPLETE", 448, 3111678);
        CREATE_MESSAGE_WITH_SOURCE_PARAM_INCOMPLETE = r448;
        ErrorCode r449 = new ErrorCode("CREATE_MESSAGE_WITH_SOURCE_TICKET_INVALID", 449, 311169);
        CREATE_MESSAGE_WITH_SOURCE_TICKET_INVALID = r449;
        ErrorCode r450 = new ErrorCode("CREATE_MESSAGE_WITH_SOURCE_NO_SCOPE", 450, 311170);
        CREATE_MESSAGE_WITH_SOURCE_NO_SCOPE = r450;
        ErrorCode r451 = new ErrorCode("CREATE_MESSAGE_WITH_SOURCE_CONTENT_INVALID", 451, 311171);
        CREATE_MESSAGE_WITH_SOURCE_CONTENT_INVALID = r451;
        ErrorCode r452 = new ErrorCode("MESSAGE_COULD_NOT_SEND_ENCRYPTMSG", 452, 311172);
        MESSAGE_COULD_NOT_SEND_ENCRYPTMSG = r452;
        ErrorCode r453 = new ErrorCode("CREATE_MESSAGE_WITH_SOURCE_UNSUPPORTED_CRYPTO_MESSAGE", 453, 311173);
        CREATE_MESSAGE_WITH_SOURCE_UNSUPPORTED_CRYPTO_MESSAGE = r453;
        ErrorCode r454 = new ErrorCode("MESSAGE_CROSS_KA_CHAT_UNSUPPORTED_MESSAGE_TYPE", 454, 311174);
        MESSAGE_CROSS_KA_CHAT_UNSUPPORTED_MESSAGE_TYPE = r454;
        ErrorCode r455 = new ErrorCode("SYNC_TO_CHAT_MESSAGE_NOT_SUPPORT_REPLY_IN_THREAD", 455, 311175);
        SYNC_TO_CHAT_MESSAGE_NOT_SUPPORT_REPLY_IN_THREAD = r455;
        ErrorCode r456 = new ErrorCode("LAN_TRANS_AUTH_PASS", 456, 320000);
        LAN_TRANS_AUTH_PASS = r456;
        ErrorCode r457 = new ErrorCode("LAN_TRANS_AUTH_FAILED", 457, 320001);
        LAN_TRANS_AUTH_FAILED = r457;
        ErrorCode r458 = new ErrorCode("LAN_TRANS_AUTH_AUTH_CHAT_FAILED", 458, 320002);
        LAN_TRANS_AUTH_AUTH_CHAT_FAILED = r458;
        ErrorCode r459 = new ErrorCode("LAN_TRANS_AUTH_ONLINE_DEVICES_NOT_FOUND", 459, 320003);
        LAN_TRANS_AUTH_ONLINE_DEVICES_NOT_FOUND = r459;
        ErrorCode r460 = new ErrorCode("LAN_TRANS_AUTH_FEATURE_NOT_ALLOWED", 460, 320004);
        LAN_TRANS_AUTH_FEATURE_NOT_ALLOWED = r460;
        ErrorCode r461 = new ErrorCode("ACCESS_FILE_AUTH_NO_PASS", 461, 321000);
        ACCESS_FILE_AUTH_NO_PASS = r461;
        ErrorCode r462 = new ErrorCode("MOMENTS_UNKNOWN_ERROR", 462, 330000);
        MOMENTS_UNKNOWN_ERROR = r462;
        ErrorCode r463 = new ErrorCode("MOMENTS_STOPPED_FEATURE", 463, 330100);
        MOMENTS_STOPPED_FEATURE = r463;
        ErrorCode r464 = new ErrorCode("MOMENTS_SESSION_ERROR", 464, 330200);
        MOMENTS_SESSION_ERROR = r464;
        ErrorCode r465 = new ErrorCode("MOMENTS_PERMISSION_ERROR", 465, 330300);
        MOMENTS_PERMISSION_ERROR = r465;
        ErrorCode r466 = new ErrorCode("MOMENTS_NO_OFFICIAL_USER_PERMISSION", 466, 330301);
        MOMENTS_NO_OFFICIAL_USER_PERMISSION = r466;
        ErrorCode r467 = new ErrorCode("MOMENTS_PARAM_ERROR", 467, 330400);
        MOMENTS_PARAM_ERROR = r467;
        ErrorCode r468 = new ErrorCode("MOMENTS_BAD_USER_ID", 468, 330401);
        MOMENTS_BAD_USER_ID = r468;
        ErrorCode r469 = new ErrorCode("MOMENTS_DUPLICATE_NICKNAME", 469, 330402);
        MOMENTS_DUPLICATE_NICKNAME = r469;
        ErrorCode r470 = new ErrorCode("MOMENTS_PIN_POST_FAILED", 470, 330403);
        MOMENTS_PIN_POST_FAILED = r470;
        ErrorCode r471 = new ErrorCode("MOMENTS_PIN_COMMENT_FAILED", 471, 330404);
        MOMENTS_PIN_COMMENT_FAILED = r471;
        ErrorCode r472 = new ErrorCode("MOMENTS_SET_RISK_WARNING_FAILED", 472, 330405);
        MOMENTS_SET_RISK_WARNING_FAILED = r472;
        ErrorCode r473 = new ErrorCode("MOMENTS_SET_SELF_VISIBLE_FAILED", 473, 330406);
        MOMENTS_SET_SELF_VISIBLE_FAILED = r473;
        ErrorCode r474 = new ErrorCode("MOMENTS_CONTENT_ERROR", 474, 330500);
        MOMENTS_CONTENT_ERROR = r474;
        ErrorCode r475 = new ErrorCode("MOMENTS_CANNOT_CREATE_POST", 475, 330501);
        MOMENTS_CANNOT_CREATE_POST = r475;
        ErrorCode r476 = new ErrorCode("MOMENTS_CANNOT_CREATE_COMMENT", 476, 330502);
        MOMENTS_CANNOT_CREATE_COMMENT = r476;
        ErrorCode r477 = new ErrorCode("MOMENTS_CANNOT_READ", 477, 330503);
        MOMENTS_CANNOT_READ = r477;
        ErrorCode r478 = new ErrorCode("MOMENTS_CANNOT_SHARE_POST_NOT_AVAILABLE", 478, 330504);
        MOMENTS_CANNOT_SHARE_POST_NOT_AVAILABLE = r478;
        ErrorCode r479 = new ErrorCode("MOMENTS_CANNOT_SHARE_KEEP_POST", 479, 330505);
        MOMENTS_CANNOT_SHARE_KEEP_POST = r479;
        ErrorCode r480 = new ErrorCode("MOMENTS_CANNOT_EDIT_POST", 480, 330506);
        MOMENTS_CANNOT_EDIT_POST = r480;
        ErrorCode r481 = new ErrorCode("MOMENTS_CANNOT_EDIT_COMMENT", 481, 330507);
        MOMENTS_CANNOT_EDIT_COMMENT = r481;
        ErrorCode r482 = new ErrorCode("MOMENTS_REACH_LIMIT_ERROR", 482, 330600);
        MOMENTS_REACH_LIMIT_ERROR = r482;
        ErrorCode r483 = new ErrorCode("CROSS_WITH_KA_FEATURE_UNAVAILABLE", 483, 340000);
        CROSS_WITH_KA_FEATURE_UNAVAILABLE = r483;
        ErrorCode r484 = new ErrorCode("CROSS_WITH_KA_MESSAGE_ACTIONS_UNAVAILABLE", 484, 341000);
        CROSS_WITH_KA_MESSAGE_ACTIONS_UNAVAILABLE = r484;
        ErrorCode r485 = new ErrorCode("CROSS_WITH_KA_UNABLE_TO_SEND_MESSAGE", 485, 341001);
        CROSS_WITH_KA_UNABLE_TO_SEND_MESSAGE = r485;
        ErrorCode r486 = new ErrorCode("CROSS_WITH_KA_UNABLE_TO_FORWARD_MESSAGE", 486, 341002);
        CROSS_WITH_KA_UNABLE_TO_FORWARD_MESSAGE = r486;
        ErrorCode r487 = new ErrorCode("CROSS_WITH_KA_UNABLE_TO_CREATE_GROUP_CHAT", 487, 342000);
        CROSS_WITH_KA_UNABLE_TO_CREATE_GROUP_CHAT = r487;
        ErrorCode r488 = new ErrorCode("CROSS_WITH_KA_CHAT_SETTINGS_UNAVAILABLE", 488, 342001);
        CROSS_WITH_KA_CHAT_SETTINGS_UNAVAILABLE = r488;
        ErrorCode r489 = new ErrorCode("CROSS_WITH_KA_UNABLE_TO_INVITE_GROUP_MEMBER", 489, 342002);
        CROSS_WITH_KA_UNABLE_TO_INVITE_GROUP_MEMBER = r489;
        ErrorCode r490 = new ErrorCode("CROSS_WITH_KA_UNABLE_TO_REMOVE_MEMBER", 490, 342003);
        CROSS_WITH_KA_UNABLE_TO_REMOVE_MEMBER = r490;
        ErrorCode r491 = new ErrorCode("CROSS_WITH_KA_CANT_SEE_PROFILE", 491, 343000);
        CROSS_WITH_KA_CANT_SEE_PROFILE = r491;
        ErrorCode r492 = new ErrorCode("UG_REACH_DUPLICATE_REQUEST", 492, 350000);
        UG_REACH_DUPLICATE_REQUEST = r492;
        ErrorCode r493 = new ErrorCode("UG_REACH_LACK_REQUEST_PARAMETER", 493, 350001);
        UG_REACH_LACK_REQUEST_PARAMETER = r493;
        ErrorCode r494 = new ErrorCode("UG_REACH_REPORT_GUIDE_FAIL", 494, 350002);
        UG_REACH_REPORT_GUIDE_FAIL = r494;
        ErrorCode r495 = new ErrorCode("UG_REACH_CORE_ERROR", 495, 350003);
        UG_REACH_CORE_ERROR = r495;
        ErrorCode r496 = new ErrorCode("NAVIGATION_CUSTOM_APP_BEYOND_LIMIT", 496, 350100);
        NAVIGATION_CUSTOM_APP_BEYOND_LIMIT = r496;
        ErrorCode r497 = new ErrorCode("NAVIGATION_CUSTOM_APP_NOT_UNIQUE", 497, 350101);
        NAVIGATION_CUSTOM_APP_NOT_UNIQUE = r497;
        ErrorCode r498 = new ErrorCode("NAVIGATION_UNIQUE_ID_DUPLICATE", 498, 350102);
        NAVIGATION_UNIQUE_ID_DUPLICATE = r498;
        ErrorCode r499 = new ErrorCode("NAVIGATION_USER_ID_NOT_VALID", 499, 350103);
        NAVIGATION_USER_ID_NOT_VALID = r499;
        ErrorCode r500 = new ErrorCode("NAVIGATION_TENANT_ID_NOT_VALID", BaseField.FIELD_TYPE_NAME_CARD_PHONE, 350104);
        NAVIGATION_TENANT_ID_NOT_VALID = r500;
        ErrorCode r501 = new ErrorCode("NAVIGATION_GET_ORDER_FAIL", 501, 350105);
        NAVIGATION_GET_ORDER_FAIL = r501;
        ErrorCode r502 = new ErrorCode("NAVIGATION_GET_APP_INFO_FAIL", 502, 350106);
        NAVIGATION_GET_APP_INFO_FAIL = r502;
        ErrorCode r503 = new ErrorCode("NAVIGATION_REQ_VERSION_NOT_LATEST", 503, 350107);
        NAVIGATION_REQ_VERSION_NOT_LATEST = r503;
        ErrorCode r504 = new ErrorCode("NAVIGATION_GET_TENANT_ORDER_FAIL", 504, 350108);
        NAVIGATION_GET_TENANT_ORDER_FAIL = r504;
        ErrorCode r505 = new ErrorCode("NAVIGATION_SAVE_ORDER_FAIL", 505, 350109);
        NAVIGATION_SAVE_ORDER_FAIL = r505;
        ErrorCode r506 = new ErrorCode("EMAIL_INVALID", 506, 370000);
        EMAIL_INVALID = r506;
        ErrorCode r507 = new ErrorCode("EMAIL_DUPLICATE", 507, 370001);
        EMAIL_DUPLICATE = r507;
        ErrorCode r508 = new ErrorCode("PHONE_INVALID", 508, 370002);
        PHONE_INVALID = r508;
        ErrorCode r509 = new ErrorCode("PHONE_DUPLICATE", 509, 370003);
        PHONE_DUPLICATE = r509;
        ErrorCode r510 = new ErrorCode("NAME_NIL", 510, 370004);
        NAME_NIL = r510;
        ErrorCode r511 = new ErrorCode("DELETED_NAMECARD", 511, 370005);
        DELETED_NAMECARD = r511;
        ErrorCode r512 = new ErrorCode("DEFAULT_NAMECARD_ERROR", 512, 370006);
        DEFAULT_NAMECARD_ERROR = r512;
        ErrorCode r513 = new ErrorCode("LARKTODO_REACH_LIMIT_ERROR", 513, 380000);
        LARKTODO_REACH_LIMIT_ERROR = r513;
        ErrorCode r514 = new ErrorCode("LARKTODO_TODO_NOT_FOUND_ERROR", 514, 380001);
        LARKTODO_TODO_NOT_FOUND_ERROR = r514;
        ErrorCode r515 = new ErrorCode("LARKTODO_TODO_EDITTED", 515, 380002);
        LARKTODO_TODO_EDITTED = r515;
        ErrorCode r516 = new ErrorCode("LARKTODO_TASK_LIST_PROCESSING", 516, 380010);
        LARKTODO_TASK_LIST_PROCESSING = r516;
        ErrorCode r517 = new ErrorCode("LARKTODO_TASK_LIST_NOT_BLAND", 517, 380011);
        LARKTODO_TASK_LIST_NOT_BLAND = r517;
        ErrorCode r518 = new ErrorCode("FEED_GROUP_NAME_DUPLICATE_ERROR", 518, 390000);
        FEED_GROUP_NAME_DUPLICATE_ERROR = r518;
        ErrorCode r519 = new ErrorCode("SAME_CHAT_NAME_IN_TEAM", 519, 400000);
        SAME_CHAT_NAME_IN_TEAM = r519;
        ErrorCode r520 = new ErrorCode("SAME_TEAM_NAME_IN_TENANT", 520, 400001);
        SAME_TEAM_NAME_IN_TENANT = r520;
        ErrorCode r521 = new ErrorCode("CANNOT_ADD_OR_LEAVE_IN_TEAM_CHAT", 521, 400002);
        CANNOT_ADD_OR_LEAVE_IN_TEAM_CHAT = r521;
        ErrorCode r522 = new ErrorCode("WILL_OVERFLOW_AFTER_BIND_CHAT", 522, 400003);
        WILL_OVERFLOW_AFTER_BIND_CHAT = r522;
        ErrorCode r523 = new ErrorCode("WILL_OVERFLOW_AFTER_ADD_MEMBER", 523, 400004);
        WILL_OVERFLOW_AFTER_ADD_MEMBER = r523;
        ErrorCode r524 = new ErrorCode("NEW_TEAM_OWNER_NOT_SET", 524, 400005);
        NEW_TEAM_OWNER_NOT_SET = r524;
        ErrorCode r525 = new ErrorCode("FORBID_OPERATE_CHAT_IN_TEAM", 525, 400006);
        FORBID_OPERATE_CHAT_IN_TEAM = r525;
        ErrorCode r526 = new ErrorCode("FORBID_CHAT_SETTING_IN_TEAM", 526, 400007);
        FORBID_CHAT_SETTING_IN_TEAM = r526;
        ErrorCode r527 = new ErrorCode("UNABLE_TO_ADD_SOME_MEMBERS", 527, 400008);
        UNABLE_TO_ADD_SOME_MEMBERS = r527;
        ErrorCode r528 = new ErrorCode("CREATE_TEAM_REACH_LIMIT", 528, 400009);
        CREATE_TEAM_REACH_LIMIT = r528;
        ErrorCode r529 = new ErrorCode("FORBID_ADD_TEAM_MEMBERS", 529, 400010);
        FORBID_ADD_TEAM_MEMBERS = r529;
        ErrorCode r530 = new ErrorCode("FORBID_BIND_TEAM_CHAT", 530, 400011);
        FORBID_BIND_TEAM_CHAT = r530;
        ErrorCode r531 = new ErrorCode("FORBID_CREATE_TEAM_CHAT", 531, 400012);
        FORBID_CREATE_TEAM_CHAT = r531;
        ErrorCode r532 = new ErrorCode("FORBID_SELECT_NOT_OWN_CHAT", 532, 400013);
        FORBID_SELECT_NOT_OWN_CHAT = r532;
        ErrorCode r533 = new ErrorCode("CHAT_IS_BIND_ANOTHER_TEAM", 533, 400014);
        CHAT_IS_BIND_ANOTHER_TEAM = r533;
        ErrorCode r534 = new ErrorCode("FORBID_SELECT_EXTERNAL_CONTACTS", 534, 400015);
        FORBID_SELECT_EXTERNAL_CONTACTS = r534;
        ErrorCode r535 = new ErrorCode("CANNOT_SHARE_TEAM_CHAT", 535, 400016);
        CANNOT_SHARE_TEAM_CHAT = r535;
        ErrorCode r536 = new ErrorCode("CANNOT_RESOLVE_TEAM_DEFAULT_CHAT", 536, 400017);
        CANNOT_RESOLVE_TEAM_DEFAULT_CHAT = r536;
        ErrorCode r537 = new ErrorCode("CANNOT_TRANSFER_TEAM_DEFAULT_CHAT_OWNER", 537, 400018);
        CANNOT_TRANSFER_TEAM_DEFAULT_CHAT_OWNER = r537;
        ErrorCode r538 = new ErrorCode("MESSAGE_TENANT_PUSH_DUPLICATE_REQUEST", 538, 410001);
        MESSAGE_TENANT_PUSH_DUPLICATE_REQUEST = r538;
        ErrorCode r539 = new ErrorCode("MESSAGE_TENANT_PUSH_BUSINESS_NOT_SUPPORT", 539, 410002);
        MESSAGE_TENANT_PUSH_BUSINESS_NOT_SUPPORT = r539;
        ErrorCode r540 = new ErrorCode("URL_PREVIEW_PERMISSION_DENIED", 540, 420001);
        URL_PREVIEW_PERMISSION_DENIED = r540;
        ErrorCode r541 = new ErrorCode("URL_PREVIEW_APP_CONTEXT_MISSING", 541, 420002);
        URL_PREVIEW_APP_CONTEXT_MISSING = r541;
        ErrorCode r542 = new ErrorCode("URL_PREVIEW_URL_MISMATCH", 542, 420003);
        URL_PREVIEW_URL_MISMATCH = r542;
        ErrorCode r543 = new ErrorCode("URL_PREVIEW_SERVICE_UNAVAILABLE", 543, 420004);
        URL_PREVIEW_SERVICE_UNAVAILABLE = r543;
        ErrorCode r544 = new ErrorCode("URL_PREVIEW_RESOURCE_UNAVAILABLE", 544, 420005);
        URL_PREVIEW_RESOURCE_UNAVAILABLE = r544;
        ErrorCode r545 = new ErrorCode("URL_PREVIEW_RESOURCE_EXHAUSTED", 545, 420006);
        URL_PREVIEW_RESOURCE_EXHAUSTED = r545;
        ErrorCode r546 = new ErrorCode("URL_PREVIEW_NEED_GET_CARD_PREVIEW", 546, 420007);
        URL_PREVIEW_NEED_GET_CARD_PREVIEW = r546;
        ErrorCode r547 = new ErrorCode("OnTimeDelGlobalSwitchIsOff", 547, 450001);
        OnTimeDelGlobalSwitchIsOff = r547;
        ErrorCode r548 = new ErrorCode("Lark_IM_ExportMsgToDocs_DisabledDueToRestrictSharing_Toast", 548, 460000);
        Lark_IM_ExportMsgToDocs_DisabledDueToRestrictSharing_Toast = r548;
        ErrorCode r549 = new ErrorCode("Lark_IM_ExportMsgToDocs_DisabledDueToRestrictedMode_Toast", 549, 460001);
        Lark_IM_ExportMsgToDocs_DisabledDueToRestrictedMode_Toast = r549;
        ErrorCode r550 = new ErrorCode("Lark_IM_ExportMsgToDocs_ExportFail_Toast", 550, 460002);
        Lark_IM_ExportMsgToDocs_ExportFail_Toast = r550;
        ErrorCode r551 = new ErrorCode("Lark_IM_ExportMsgToDocs_CHAT_CAN_NOT_Export", 551, 460003);
        Lark_IM_ExportMsgToDocs_CHAT_CAN_NOT_Export = r551;
        ErrorCode r552 = new ErrorCode("Lark_IM_ExportMsgToDocs_ALL_MSG_IS_RESTRICTED", 552, 460004);
        Lark_IM_ExportMsgToDocs_ALL_MSG_IS_RESTRICTED = r552;
        ErrorCode r553 = new ErrorCode("Lark_IM_ExportMsgToDocs_EMPTY_PARAM", 553, 460005);
        Lark_IM_ExportMsgToDocs_EMPTY_PARAM = r553;
        ErrorCode r554 = new ErrorCode("Lark_IM_ExportMsgToDocs_WRONG_PARAM", 554, 460006);
        Lark_IM_ExportMsgToDocs_WRONG_PARAM = r554;
        ErrorCode r555 = new ErrorCode("Lark_IM_ExportMsgToDocs_CCM_FAIL", 555, 460007);
        Lark_IM_ExportMsgToDocs_CCM_FAIL = r555;
        ErrorCode r556 = new ErrorCode("CREATE_GROUP_CHAT_TRIGGER_LIMITER", 556, 500000);
        CREATE_GROUP_CHAT_TRIGGER_LIMITER = r556;
        ErrorCode r557 = new ErrorCode("WRITE_CHAT_TRIGGER_LIMITER", 557, 500001);
        WRITE_CHAT_TRIGGER_LIMITER = r557;
        ErrorCode r558 = new ErrorCode("SPECIAL_PROTECT_CHAT_TRIGGER_LIMITER", 558, 500002);
        SPECIAL_PROTECT_CHAT_TRIGGER_LIMITER = r558;
        ErrorCode r559 = new ErrorCode("LOCK_CHAT_FAILED", 559, 500010);
        LOCK_CHAT_FAILED = r559;
        ErrorCode r560 = new ErrorCode("AUTH_USER_NOT_IN_CHAT", 560, 500020);
        AUTH_USER_NOT_IN_CHAT = r560;
        ErrorCode r561 = new ErrorCode("AUTH_OWNER_OR_ADMIN_BLOCKED", 561, 500021);
        AUTH_OWNER_OR_ADMIN_BLOCKED = r561;
        ErrorCode r562 = new ErrorCode("AUTH_SYSTEM_BANNER_BLOCKED", 562, 500022);
        AUTH_SYSTEM_BANNER_BLOCKED = r562;
        ErrorCode r563 = new ErrorCode("MY_AI_ALREADY_INIT_SUCCESS", 563, 500100);
        MY_AI_ALREADY_INIT_SUCCESS = r563;
        ErrorCode r564 = new ErrorCode("My_AI_ALREADY_NEW_TOPIC", 564, 500101);
        My_AI_ALREADY_NEW_TOPIC = r564;
        ErrorCode r565 = new ErrorCode("MY_AI_QUICK_ACTION_EXPIRED", 565, 500102);
        MY_AI_QUICK_ACTION_EXPIRED = r565;
        ErrorCode r566 = new ErrorCode("MY_AI_PLUGIN_SELECTION_EXPIRED", 566, 500103);
        MY_AI_PLUGIN_SELECTION_EXPIRED = r566;
        ErrorCode r567 = new ErrorCode("MY_AI_SCENE_ALREADY_ADDED", 567, 500104);
        MY_AI_SCENE_ALREADY_ADDED = r567;
        ErrorCode r568 = new ErrorCode("MEMORY_UNREAD_SUMMARY_NO_PERMISSION", 568, 500201);
        MEMORY_UNREAD_SUMMARY_NO_PERMISSION = r568;
        ErrorCode r569 = new ErrorCode("MEMORY_UNREAD_SUMMARY_OVER_LIMIT", 569, 500202);
        MEMORY_UNREAD_SUMMARY_OVER_LIMIT = r569;
        ErrorCode r570 = new ErrorCode("TY_SINGLE_CHAT_FORBIDDEN_TRIGGER", 570, 500300);
        TY_SINGLE_CHAT_FORBIDDEN_TRIGGER = r570;
        ErrorCode r571 = new ErrorCode("TY_SINGLE_CHAT_OVER_LIMIT", 571, 500301);
        TY_SINGLE_CHAT_OVER_LIMIT = r571;
        ErrorCode r572 = new ErrorCode("AI_KNOWLEDGE_ANSWER_INTERNAL", 572, 500400);
        AI_KNOWLEDGE_ANSWER_INTERNAL = r572;
        ErrorCode r573 = new ErrorCode("AI_KNOWLEDGE_ANSWER_TNS_INPUT", 573, 500401);
        AI_KNOWLEDGE_ANSWER_TNS_INPUT = r573;
        ErrorCode r574 = new ErrorCode("AI_KNOWLEDGE_ANSWER_TNS_OUTPUT", 574, 500402);
        AI_KNOWLEDGE_ANSWER_TNS_OUTPUT = r574;
        ErrorCode r575 = new ErrorCode("AI_KNOWLEDGE_IMAGE_TNS_INPUT", 575, 500403);
        AI_KNOWLEDGE_IMAGE_TNS_INPUT = r575;
        ErrorCode r576 = new ErrorCode("AI_KNOWLEDGE_ANSWER_UNAVAILABLE", 576, 500404);
        AI_KNOWLEDGE_ANSWER_UNAVAILABLE = r576;
        ErrorCode r577 = new ErrorCode("AI_KNOWLEDGE_SHARE_LINK_DISABLE", 577, 500451);
        AI_KNOWLEDGE_SHARE_LINK_DISABLE = r577;
        ErrorCode r578 = new ErrorCode("AI_KNOWLEDGE_NEED_LOGIN", 578, 500452);
        AI_KNOWLEDGE_NEED_LOGIN = r578;
        ErrorCode r579 = new ErrorCode("AI_KNOWLEDGE_SHARE_IMAGE_INVALID_URL", 579, 500460);
        AI_KNOWLEDGE_SHARE_IMAGE_INVALID_URL = r579;
        ErrorCode r580 = new ErrorCode("AI_KNOWLEDGE_SHARE_IMAGE_TIME_OUT", 580, 500461);
        AI_KNOWLEDGE_SHARE_IMAGE_TIME_OUT = r580;
        ErrorCode r581 = new ErrorCode("AI_KNOWLEDGE_SHARE_IMAGE_EXCEED_LENGTH_LIMIT", 581, 500462);
        AI_KNOWLEDGE_SHARE_IMAGE_EXCEED_LENGTH_LIMIT = r581;
        ErrorCode r582 = new ErrorCode("AI_KNOWLEDGE_PULL_ANSWER_CACHE_EMPTY", 582, 500463);
        AI_KNOWLEDGE_PULL_ANSWER_CACHE_EMPTY = r582;
        ErrorCode r583 = new ErrorCode("AI_KNOWLEDGE_AI_TOPIC_IS_DELETED", 583, 500464);
        AI_KNOWLEDGE_AI_TOPIC_IS_DELETED = r583;
        ErrorCode r584 = new ErrorCode("AI_KNOWLEDGE_CONVERT_TO_QUERY_ERROR", 584, 500465);
        AI_KNOWLEDGE_CONVERT_TO_QUERY_ERROR = r584;
        ErrorCode r585 = new ErrorCode("AI_KNOWLEDGE_NO_WIKI_OPERATOR_PERMISSION", 585, 500466);
        AI_KNOWLEDGE_NO_WIKI_OPERATOR_PERMISSION = r585;
        ErrorCode r586 = new ErrorCode("AI_KNOWLEDGE_NO_WIKI_VIEW_PERMISSION", 586, 500467);
        AI_KNOWLEDGE_NO_WIKI_VIEW_PERMISSION = r586;
        ErrorCode r587 = new ErrorCode("AI_KNOWLEDGE_MANAGER_CANNOT_QUIT_WIKI", 587, 500468);
        AI_KNOWLEDGE_MANAGER_CANNOT_QUIT_WIKI = r587;
        ErrorCode r588 = new ErrorCode("AI_KNOWLEDGE_NEED_JOIN_WIKI", 588, 500469);
        AI_KNOWLEDGE_NEED_JOIN_WIKI = r588;
        ErrorCode r589 = new ErrorCode("AI_KNOWLEDGE_USER_JOINED_WIKI_OVER_LIMIT", 589, 500470);
        AI_KNOWLEDGE_USER_JOINED_WIKI_OVER_LIMIT = r589;
        ErrorCode r590 = new ErrorCode("AI_KNOWLEDGE_USER_MANAGED_WIKI_OVER_LIMIT", 590, 500471);
        AI_KNOWLEDGE_USER_MANAGED_WIKI_OVER_LIMIT = r590;
        ErrorCode r591 = new ErrorCode("AI_KNOWLEDGE_WIKI_INFO_CONTAINS_SENSITIVE_WORDS", 591, 500472);
        AI_KNOWLEDGE_WIKI_INFO_CONTAINS_SENSITIVE_WORDS = r591;
        ErrorCode r592 = new ErrorCode("AI_KNOWLEDGE_USER_CREATE_WIKI_OVER_LIMIT", 592, 500473);
        AI_KNOWLEDGE_USER_CREATE_WIKI_OVER_LIMIT = r592;
        ErrorCode r593 = new ErrorCode("AI_KNOWLEDGE_FEATURE_DISCONTINUED", 593, 500474);
        AI_KNOWLEDGE_FEATURE_DISCONTINUED = r593;
        ErrorCode r594 = new ErrorCode("AI_KNOWLEDGE_WIKI_IS_PRIVATE", 594, 500475);
        AI_KNOWLEDGE_WIKI_IS_PRIVATE = r594;
        ErrorCode r595 = new ErrorCode("AI_KNOWLEDGE_WIKI_NOT_RELEASE", 595, 500476);
        AI_KNOWLEDGE_WIKI_NOT_RELEASE = r595;
        ErrorCode r596 = new ErrorCode("AI_KNOWLEDGE_WIKI_NOT_EXISTS", 596, 500477);
        AI_KNOWLEDGE_WIKI_NOT_EXISTS = r596;
        ErrorCode r597 = new ErrorCode("AI_KNOWLEDGE_NO_SEND_HONG_BAO_PERMISSION", 597, 500478);
        AI_KNOWLEDGE_NO_SEND_HONG_BAO_PERMISSION = r597;
        ErrorCode r598 = new ErrorCode("AI_KNOWLEDGE_NOT_SUPER_ADMIN", 598, 500479);
        AI_KNOWLEDGE_NOT_SUPER_ADMIN = r598;
        ErrorCode r599 = new ErrorCode("AI_KNOWLEDGE_SCHEDULE_TASK_OVER_LIMITED", 599, 500480);
        AI_KNOWLEDGE_SCHEDULE_TASK_OVER_LIMITED = r599;
        ErrorCode r600 = new ErrorCode("AI_KNOWLEDGE_SCHEDULE_TASK_NOT_EXIST", 600, 500481);
        AI_KNOWLEDGE_SCHEDULE_TASK_NOT_EXIST = r600;
        ErrorCode r601 = new ErrorCode("AI_KNOWLEDGE_GEN_DISCOUNT_CODE_OVER_LIMIT", 601, 500482);
        AI_KNOWLEDGE_GEN_DISCOUNT_CODE_OVER_LIMIT = r601;
        ErrorCode r602 = new ErrorCode("AI_KNOWLEDGE_DISCOUNT_CODE_IS_USED", 602, 500483);
        AI_KNOWLEDGE_DISCOUNT_CODE_IS_USED = r602;
        ErrorCode r603 = new ErrorCode("AI_KNOWLEDGE_DISCOUNT_CODE_INVALID", 603, 500484);
        AI_KNOWLEDGE_DISCOUNT_CODE_INVALID = r603;
        ErrorCode r604 = new ErrorCode("AI_KNOWLEDGE_NEED_UPGRADE_VERSION", 604, 500485);
        AI_KNOWLEDGE_NEED_UPGRADE_VERSION = r604;
        ErrorCode r605 = new ErrorCode("AI_KNOWLEDGE_MISSING_DISCOUNT_CODE", 605, 500486);
        AI_KNOWLEDGE_MISSING_DISCOUNT_CODE = r605;
        ErrorCode r606 = new ErrorCode("AI_KNOWLEDGE_WIKI_DISCOUNT_OVER_LIMIT", 606, 500487);
        AI_KNOWLEDGE_WIKI_DISCOUNT_OVER_LIMIT = r606;
        ErrorCode r607 = new ErrorCode("AI_KNOWLEDGE_REMAINING_TRIAL_COUNT_IS_ZERO", 607, 500488);
        AI_KNOWLEDGE_REMAINING_TRIAL_COUNT_IS_ZERO = r607;
        ErrorCode r608 = new ErrorCode("AI_KNOWLEDGE_CHECK_DISCOUNT_CODE_OVER_LIMIT", 608, 500489);
        AI_KNOWLEDGE_CHECK_DISCOUNT_CODE_OVER_LIMIT = r608;
        ErrorCode r609 = new ErrorCode("AI_KNOWLEDGE_AI_PRODUCTIVITY_REPORT_RECORD_NOT_FOUND", 609, 500490);
        AI_KNOWLEDGE_AI_PRODUCTIVITY_REPORT_RECORD_NOT_FOUND = r609;
        ErrorCode r610 = new ErrorCode("AI_KNOWLEDGE_AI_PRODUCTIVITY_REPORT_NO_PERMISSION", 610, 500491);
        AI_KNOWLEDGE_AI_PRODUCTIVITY_REPORT_NO_PERMISSION = r610;
        ErrorCode r611 = new ErrorCode("AI_KNOWLEDGE_SCHEDULE_TASK_DUPLICATED", 611, 500492);
        AI_KNOWLEDGE_SCHEDULE_TASK_DUPLICATED = r611;
        ErrorCode r612 = new ErrorCode("AI_KNOWLEDGE_CANT_VIEW_WIKI_QA_REDIRECT", 612, 500493);
        AI_KNOWLEDGE_CANT_VIEW_WIKI_QA_REDIRECT = r612;
        ErrorCode r613 = new ErrorCode("AI_KNOWLEDGE_WIKI_ASK_TOO_OFTEN", 613, 500494);
        AI_KNOWLEDGE_WIKI_ASK_TOO_OFTEN = r613;
        ErrorCode r614 = new ErrorCode("AI_KNOWLEDGE_SEARCH_DEPARTMENT_LIMIT_EXCEED", 614, 500495);
        AI_KNOWLEDGE_SEARCH_DEPARTMENT_LIMIT_EXCEED = r614;
        ErrorCode r615 = new ErrorCode("AI_KNOWLEDGE_REFUND_IS_REQUIRED_BEFORE_DELETION", 615, 500496);
        AI_KNOWLEDGE_REFUND_IS_REQUIRED_BEFORE_DELETION = r615;
        ErrorCode r616 = new ErrorCode("AI_KNOWLEDGE_JOIN_WIKI_SPACE_NEED_PAID", 616, 500497);
        AI_KNOWLEDGE_JOIN_WIKI_SPACE_NEED_PAID = r616;
        ErrorCode r617 = new ErrorCode("AI_KNOWLEDGE_WIKI_USER_NO_NEED_CREATE_ORDER", 617, 500498);
        AI_KNOWLEDGE_WIKI_USER_NO_NEED_CREATE_ORDER = r617;
        ErrorCode r618 = new ErrorCode("AI_KNOWLEDGE_WIKI_DISCOUNT_CODE_NOT_MATCH", 618, 500499);
        AI_KNOWLEDGE_WIKI_DISCOUNT_CODE_NOT_MATCH = r618;
        ErrorCode r619 = new ErrorCode("AI_KNOWLEDGE_WIKI_ORDER_CREATING", 619, 500500);
        AI_KNOWLEDGE_WIKI_ORDER_CREATING = r619;
        ErrorCode r620 = new ErrorCode("AI_KNOWLEDGE_NO_WIKI_ORDER_OPERATOR_PERMISSION", 620, 500501);
        AI_KNOWLEDGE_NO_WIKI_ORDER_OPERATOR_PERMISSION = r620;
        ErrorCode r621 = new ErrorCode("AI_KNOWLEDGE_WIKI_ORDER_STATE_REFRESH", 621, 500502);
        AI_KNOWLEDGE_WIKI_ORDER_STATE_REFRESH = r621;
        ErrorCode r622 = new ErrorCode("AI_KNOWLEDGE_WIKI_ACCOUNT_NOT_ENOUGH", 622, 500503);
        AI_KNOWLEDGE_WIKI_ACCOUNT_NOT_ENOUGH = r622;
        ErrorCode r623 = new ErrorCode("AI_KNOWLEDGE_WIKI_ORDER_SALE_INFO_ERROR", 623, 500504);
        AI_KNOWLEDGE_WIKI_ORDER_SALE_INFO_ERROR = r623;
        ErrorCode r624 = new ErrorCode("AI_KNOWLEDGE_WIKI_SUB_MERCHANT_OUT_OF_LIMIT", 624, 500505);
        AI_KNOWLEDGE_WIKI_SUB_MERCHANT_OUT_OF_LIMIT = r624;
        ErrorCode r625 = new ErrorCode("AI_KNOWLEDGE_WIKI_ORG_ADMIN_RESTRICT_PERM_TOAST", 625, 500506);
        AI_KNOWLEDGE_WIKI_ORG_ADMIN_RESTRICT_PERM_TOAST = r625;
        ErrorCode r626 = new ErrorCode("AI_KNOWLEDGE_WORK_SPACE_NODE_NOT_EXISTS", 626, 500601);
        AI_KNOWLEDGE_WORK_SPACE_NODE_NOT_EXISTS = r626;
        ErrorCode r627 = new ErrorCode("AI_KNOWLEDGE_WORK_SPACE_NODE_HAS_BEEN_DELETED", 627, 500602);
        AI_KNOWLEDGE_WORK_SPACE_NODE_HAS_BEEN_DELETED = r627;
        ErrorCode r628 = new ErrorCode("AI_KNOWLEDGE_WORK_SPACE_NODE_NUM_OVER_LIMIT", 628, 500603);
        AI_KNOWLEDGE_WORK_SPACE_NODE_NUM_OVER_LIMIT = r628;
        ErrorCode r629 = new ErrorCode("MESSAGE_SHARK_RISK_CONTROL_BLOCKED", 629, 500701);
        MESSAGE_SHARK_RISK_CONTROL_BLOCKED = r629;
        $VALUES = new ErrorCode[]{r0, r1, r3, r5, r8, r11, r12, r14, r13, r9, r6, r4, r7, r10, r2, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239, r240, r241, r242, r243, r244, r245, r246, r247, r248, r249, r250, r251, r252, r253, r254, r255, r256, r257, r258, r259, r260, r261, r262, r263, r264, r265, r266, r267, r268, r269, r270, r271, r272, r273, r274, r275, r276, r277, r278, r279, r280, r281, r282, r283, r284, r285, r286, r287, r288, r289, r290, r291, r292, r293, r294, r295, r296, r297, r298, r299, r300, r301, r302, r303, r304, r305, r306, r307, r308, r309, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r330, r331, r332, r333, r334, r335, r336, r337, r338, r339, r340, r341, r342, r343, r344, r345, r346, r347, r348, r349, r350, r351, r352, r353, r354, r355, r356, r357, r358, r359, r360, r361, r362, r363, r364, r365, r366, r367, r368, r369, r370, r371, r372, r373, r374, r375, r376, r377, r378, r379, r380, r381, r382, r383, r384, r385, r386, r387, r388, r389, r390, r391, r392, r393, r394, r395, r396, r397, r398, r399, r400, r401, r402, r403, r404, r405, r406, r407, r408, r409, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r430, r431, r432, r433, r434, r435, r436, r437, r438, r439, r440, r441, r442, r443, r444, r445, r446, r447, r448, r449, r450, r451, r452, r453, r454, r455, r456, r457, r458, r459, r460, r461, r462, r463, r464, r465, r466, r467, r468, r469, r470, r471, r472, r473, r474, r475, r476, r477, r478, r479, r480, r481, r482, r483, r484, r485, r486, r487, r488, r489, r490, r491, r492, r493, r494, r495, r496, r497, r498, r499, r500, r501, r502, r503, r504, r505, r506, r507, r508, r509, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r520, r521, r522, r523, r524, r525, r526, r527, r528, r529, r530, r531, r532, r533, r534, r535, r536, r537, r538, r539, r540, r541, r542, r543, r544, r545, r546, r547, r548, r549, r550, r551, r552, r553, r554, r555, r556, r557, r558, r559, r560, r561, r562, r563, r564, r565, r566, r567, r568, r569, r570, r571, r572, r573, r574, r575, r576, r577, r578, r579, r580, r581, r582, r583, r584, r585, r586, r587, r588, r589, r590, r591, r592, r593, r594, r595, r596, r597, r598, r599, r600, r601, r602, r603, r604, r605, r606, r607, r608, r609, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r620, r621, r622, r623, r624, r625, r626, r627, r628, r629};
        ADAPTER = ProtoAdapter.newEnumAdapter(ErrorCode.class);
    }

    public static ErrorCode fromValue(int r1) {
        if (r1 == 0) goto L1284;
        if (r1 == 1) goto L1282;
        if (r1 == 10) goto L1280;
        if (r1 == 11) goto L1278;
        if (r1 == 4100) goto L1276;
        if (r1 == 4101) goto L1274;
        if (r1 == 4200) goto L1272;
        if (r1 == 4201) goto L1270;
        switch(r1) {
            case 204: goto L1268;
            case 4000: goto L1266;
            case 4001: goto L1264;
            case 4002: goto L1262;
            case 4003: goto L1260;
            case 4004: goto L1258;
            case 4005: goto L1256;
            case 4006: goto L1254;
            case 4007: goto L1252;
            case 4008: goto L1250;
            case 4009: goto L1248;
            case 4010: goto L1246;
            case 4011: goto L1244;
            case 4012: goto L1242;
            case 4013: goto L1240;
            case 4014: goto L1238;
            case 4015: goto L1236;
            case 4016: goto L1234;
            case 4017: goto L1232;
            case 4018: goto L1230;
            case 4019: goto L1228;
            case 4020: goto L1226;
            case 4021: goto L1224;
            case 4022: goto L1222;
            case 4023: goto L1220;
            case 4024: goto L1218;
            case 4025: goto L1216;
            case 4026: goto L1214;
            case 4027: goto L1212;
            case 4028: goto L1210;
            case 4029: goto L1208;
            case 4030: goto L1206;
            case 4031: goto L1204;
            case 4032: goto L1202;
            case 4033: goto L1200;
            case 4034: goto L1198;
            case 4035: goto L1196;
            case 4036: goto L1194;
            case 4037: goto L1192;
            case 4038: goto L1190;
            case 4039: goto L1188;
            case 4040: goto L1186;
            case 4041: goto L1184;
            case 4042: goto L1182;
            case 4043: goto L1180;
            case 4044: goto L1178;
            case 4045: goto L1176;
            case 4046: goto L1174;
            case 4047: goto L1172;
            case 4048: goto L1170;
            case 4049: goto L1168;
            case 4050: goto L1166;
            case 4051: goto L1164;
            case 4052: goto L1162;
            case 4053: goto L1160;
            case 4054: goto L1158;
            case 4055: goto L1156;
            case 4056: goto L1154;
            case 4057: goto L1152;
            case 4058: goto L1150;
            case 4059: goto L1148;
            case 5100: goto L1146;
            case 5101: goto L1144;
            case 5102: goto L1142;
            case 5103: goto L1140;
            case 5104: goto L1138;
            case 5105: goto L1136;
            case 5106: goto L1134;
            case 5107: goto L1132;
            case 5108: goto L1130;
            case 5109: goto L1128;
            case 5110: goto L1126;
            case 5111: goto L1124;
            case 5112: goto L1122;
            case 5113: goto L1120;
            case 5114: goto L1118;
            case 5115: goto L1116;
            case 5116: goto L1114;
            case 5117: goto L1112;
            case 5118: goto L1110;
            case 5119: goto L1108;
            case 5120: goto L1106;
            case 5121: goto L1104;
            case 5122: goto L1102;
            case 5123: goto L1100;
            case 5124: goto L1098;
            case 5125: goto L1096;
            case 5126: goto L1094;
            case 5127: goto L1092;
            case 5128: goto L1090;
            case 5129: goto L1088;
            case 5130: goto L1086;
            case 5131: goto L1084;
            case 5132: goto L1082;
            case 5133: goto L1080;
            case 5134: goto L1078;
            case 5135: goto L1076;
            case 5200: goto L1074;
            case 5555: goto L1072;
            case 5566: goto L1070;
            case 5567: goto L1068;
            case 5568: goto L1066;
            case 5600: goto L1064;
            case 5601: goto L1062;
            case 5602: goto L1060;
            case 5603: goto L1058;
            case 5604: goto L1056;
            case 5605: goto L1054;
            case 5606: goto L1052;
            case 5607: goto L1050;
            case 5608: goto L1048;
            case 5609: goto L1046;
            case 5610: goto L1044;
            case 5611: goto L1042;
            case 5612: goto L1040;
            case 5613: goto L1038;
            case 5614: goto L1036;
            case 5615: goto L1034;
            case 5616: goto L1032;
            case 5617: goto L1030;
            case 5618: goto L1028;
            case 5619: goto L1026;
            case 5620: goto L1024;
            case 5621: goto L1022;
            case 5650: goto L1020;
            case 5651: goto L1018;
            case 5652: goto L1016;
            case 5653: goto L1014;
            case 5654: goto L1012;
            case 5655: goto L1010;
            case 5656: goto L1008;
            case 5657: goto L1006;
            case 5658: goto L1004;
            case 5659: goto L1002;
            case 5660: goto L1000;
            case 5661: goto L998;
            case 5662: goto L996;
            case 5663: goto L994;
            case 5664: goto L992;
            case 5665: goto L990;
            case 5666: goto L988;
            case 5667: goto L986;
            case 5700: goto L984;
            case 5701: goto L982;
            case 5702: goto L980;
            case 5703: goto L978;
            case 5704: goto L976;
            case 5705: goto L974;
            case 5800: goto L972;
            case 5801: goto L970;
            case 5802: goto L968;
            case 5803: goto L966;
            case 6000: goto L964;
            case 6001: goto L962;
            case 6002: goto L960;
            case 6003: goto L958;
            case 6004: goto L956;
            case 6005: goto L954;
            case 6200: goto L952;
            case 7001: goto L950;
            case 7002: goto L948;
            case 7003: goto L946;
            case 7004: goto L944;
            case 7005: goto L942;
            case 7006: goto L940;
            case 7007: goto L938;
            case 7008: goto L936;
            case 7010: goto L934;
            case 7011: goto L932;
            case 7012: goto L930;
            case 7100: goto L928;
            case 7200: goto L926;
            case 9000: goto L924;
            case 11001: goto L922;
            case 250000: goto L920;
            case 250001: goto L918;
            case 250002: goto L916;
            case 250003: goto L914;
            case 250004: goto L912;
            case 250005: goto L910;
            case 250006: goto L908;
            case 250007: goto L906;
            case 250008: goto L904;
            case 250009: goto L902;
            case 250101: goto L900;
            case 250201: goto L898;
            case 250202: goto L896;
            case 250203: goto L894;
            case 250301: goto L892;
            case 250302: goto L890;
            case 250303: goto L888;
            case 250304: goto L886;
            case 250401: goto L884;
            case 250402: goto L882;
            case 250403: goto L880;
            case 250404: goto L878;
            case 250405: goto L876;
            case 250406: goto L874;
            case 250407: goto L872;
            case 250450: goto L870;
            case 250451: goto L868;
            case 250452: goto L866;
            case 250501: goto L864;
            case 250502: goto L862;
            case 250503: goto L860;
            case 250504: goto L858;
            case 250505: goto L856;
            case 250550: goto L854;
            case 250601: goto L852;
            case 250602: goto L850;
            case 250603: goto L848;
            case 250604: goto L846;
            case 250605: goto L844;
            case 250701: goto L842;
            case 250702: goto L840;
            case 250703: goto L838;
            case 250800: goto L836;
            case 250801: goto L834;
            case 250850: goto L832;
            case 250851: goto L830;
            case 250852: goto L828;
            case 250853: goto L826;
            case 250854: goto L824;
            case 250855: goto L822;
            case 250858: goto L820;
            case 250901: goto L818;
            case 250902: goto L816;
            case 250903: goto L814;
            case 250904: goto L812;
            case 250905: goto L810;
            case 260000: goto L808;
            case 260001: goto L806;
            case 260002: goto L804;
            case 260003: goto L802;
            case 260004: goto L800;
            case 260005: goto L798;
            case 260006: goto L796;
            case 260007: goto L794;
            case 260008: goto L792;
            case 260009: goto L790;
            case 260010: goto L788;
            case 260011: goto L786;
            case 260012: goto L784;
            case 260013: goto L782;
            case 260014: goto L780;
            case 270000: goto L778;
            case 270001: goto L776;
            case 270002: goto L774;
            case 270003: goto L772;
            case 270004: goto L770;
            case 270005: goto L768;
            case 270006: goto L766;
            case 270007: goto L764;
            case 270008: goto L762;
            case 270009: goto L760;
            case 270010: goto L758;
            case 270011: goto L756;
            case 280000: goto L754;
            case 280001: goto L752;
            case 280002: goto L750;
            case 280003: goto L748;
            case 280004: goto L746;
            case 280005: goto L744;
            case 280006: goto L742;
            case 290000: goto L740;
            case 290001: goto L738;
            case 290002: goto L736;
            case 290003: goto L734;
            case 290004: goto L732;
            case 290005: goto L730;
            case 290006: goto L728;
            case 290007: goto L726;
            case 290008: goto L724;
            case 300000: goto L722;
            case 300001: goto L720;
            case 300002: goto L718;
            case 300003: goto L716;
            case 300004: goto L714;
            case 310000: goto L712;
            case 310001: goto L710;
            case 310002: goto L708;
            case 310003: goto L706;
            case 310004: goto L704;
            case 310005: goto L702;
            case 310006: goto L700;
            case 310007: goto L698;
            case 310008: goto L696;
            case 310009: goto L694;
            case 310010: goto L692;
            case 310011: goto L690;
            case 310012: goto L688;
            case 311000: goto L686;
            case 311001: goto L684;
            case 311002: goto L682;
            case 311003: goto L680;
            case 311100: goto L678;
            case 311101: goto L676;
            case 311102: goto L674;
            case 311103: goto L672;
            case 311120: goto L670;
            case 311121: goto L668;
            case 311122: goto L666;
            case 311123: goto L664;
            case 311124: goto L662;
            case 311125: goto L660;
            case 311126: goto L658;
            case 311127: goto L656;
            case 311128: goto L654;
            case 311129: goto L652;
            case 311140: goto L650;
            case 311141: goto L648;
            case 311142: goto L646;
            case 311143: goto L644;
            case 311144: goto L642;
            case 311145: goto L640;
            case 311146: goto L638;
            case 311147: goto L636;
            case 311148: goto L634;
            case 311149: goto L632;
            case 311150: goto L630;
            case 311151: goto L628;
            case 311152: goto L626;
            case 311153: goto L624;
            case 311154: goto L622;
            case 311155: goto L620;
            case 311156: goto L618;
            case 311157: goto L616;
            case 311158: goto L614;
            case 311159: goto L612;
            case 311160: goto L610;
            case 311161: goto L608;
            case 311162: goto L606;
            case 311163: goto L604;
            case 311164: goto L602;
            case 311165: goto L600;
            case 311166: goto L598;
            case 311167: goto L596;
            case 311169: goto L594;
            case 311170: goto L592;
            case 311171: goto L590;
            case 311172: goto L588;
            case 311173: goto L586;
            case 311174: goto L584;
            case 311175: goto L582;
            case 320000: goto L580;
            case 320001: goto L578;
            case 320002: goto L576;
            case 320003: goto L574;
            case 320004: goto L572;
            case 321000: goto L570;
            case 330000: goto L568;
            case 330100: goto L566;
            case 330200: goto L564;
            case 330300: goto L562;
            case 330301: goto L560;
            case 330400: goto L558;
            case 330401: goto L556;
            case 330402: goto L554;
            case 330403: goto L552;
            case 330404: goto L550;
            case 330405: goto L548;
            case 330406: goto L546;
            case 330500: goto L544;
            case 330501: goto L542;
            case 330502: goto L540;
            case 330503: goto L538;
            case 330504: goto L536;
            case 330505: goto L534;
            case 330506: goto L532;
            case 330507: goto L530;
            case 330600: goto L528;
            case 340000: goto L526;
            case 341000: goto L524;
            case 341001: goto L522;
            case 341002: goto L520;
            case 342000: goto L518;
            case 342001: goto L516;
            case 342002: goto L514;
            case 342003: goto L512;
            case 343000: goto L510;
            case 350000: goto L508;
            case 350001: goto L506;
            case 350002: goto L504;
            case 350003: goto L502;
            case 350100: goto L500;
            case 350101: goto L498;
            case 350102: goto L496;
            case 350103: goto L494;
            case 350104: goto L492;
            case 350105: goto L490;
            case 350106: goto L488;
            case 350107: goto L486;
            case 350108: goto L484;
            case 350109: goto L482;
            case 370000: goto L480;
            case 370001: goto L478;
            case 370002: goto L476;
            case 370003: goto L474;
            case 370004: goto L472;
            case 370005: goto L470;
            case 370006: goto L468;
            case 380000: goto L466;
            case 380001: goto L464;
            case 380002: goto L462;
            case 380010: goto L460;
            case 380011: goto L458;
            case 390000: goto L456;
            case 400000: goto L454;
            case 400001: goto L452;
            case 400002: goto L450;
            case 400003: goto L448;
            case 400004: goto L446;
            case 400005: goto L444;
            case 400006: goto L442;
            case 400007: goto L440;
            case 400008: goto L438;
            case 400009: goto L436;
            case 400010: goto L434;
            case 400011: goto L432;
            case 400012: goto L430;
            case 400013: goto L428;
            case 400014: goto L426;
            case 400015: goto L424;
            case 400016: goto L422;
            case 400017: goto L420;
            case 400018: goto L418;
            case 410001: goto L416;
            case 410002: goto L414;
            case 420001: goto L412;
            case 420002: goto L410;
            case 420003: goto L408;
            case 420004: goto L406;
            case 420005: goto L404;
            case 420006: goto L402;
            case 420007: goto L400;
            case 450001: goto L398;
            case 460000: goto L396;
            case 460001: goto L394;
            case 460002: goto L392;
            case 460003: goto L390;
            case 460004: goto L388;
            case 460005: goto L386;
            case 460006: goto L384;
            case 460007: goto L382;
            case 500000: goto L380;
            case 500001: goto L378;
            case 500002: goto L376;
            case 500010: goto L374;
            case 500020: goto L372;
            case 500021: goto L370;
            case 500022: goto L368;
            case 500100: goto L366;
            case 500101: goto L364;
            case 500102: goto L362;
            case 500103: goto L360;
            case 500104: goto L358;
            case 500201: goto L356;
            case 500202: goto L354;
            case 500300: goto L352;
            case 500301: goto L350;
            case 500400: goto L348;
            case 500401: goto L346;
            case 500402: goto L344;
            case 500403: goto L342;
            case 500404: goto L340;
            case 500451: goto L338;
            case 500452: goto L336;
            case 500460: goto L334;
            case 500461: goto L332;
            case 500462: goto L330;
            case 500463: goto L328;
            case 500464: goto L326;
            case 500465: goto L324;
            case 500466: goto L322;
            case 500467: goto L320;
            case 500468: goto L318;
            case 500469: goto L316;
            case 500470: goto L314;
            case 500471: goto L312;
            case 500472: goto L310;
            case 500473: goto L308;
            case 500474: goto L306;
            case 500475: goto L304;
            case 500476: goto L302;
            case 500477: goto L300;
            case 500478: goto L298;
            case 500479: goto L296;
            case 500480: goto L294;
            case 500481: goto L292;
            case 500482: goto L290;
            case 500483: goto L288;
            case 500484: goto L286;
            case 500485: goto L284;
            case 500486: goto L282;
            case 500487: goto L280;
            case 500488: goto L278;
            case 500489: goto L276;
            case 500490: goto L274;
            case 500491: goto L272;
            case 500492: goto L270;
            case 500493: goto L268;
            case 500494: goto L266;
            case 500495: goto L264;
            case 500496: goto L262;
            case 500497: goto L260;
            case 500498: goto L258;
            case 500499: goto L256;
            case 500500: goto L254;
            case 500501: goto L252;
            case 500502: goto L250;
            case 500503: goto L248;
            case 500504: goto L246;
            case 500505: goto L244;
            case 500506: goto L242;
            case 500601: goto L240;
            case 500602: goto L238;
            case 500603: goto L236;
            case 500701: goto L234;
            case 3111678: goto L232;
            default: goto L18;
        };
    L18:
        switch(r1) {
            case 4301: goto L230;
            case 4302: goto L228;
            case 4303: goto L226;
            case 4304: goto L224;
            case 4305: goto L222;
            case 4306: goto L220;
            case 4307: goto L218;
            default: goto L19;
        };
    L19:
        switch(r1) {
            case 4401: goto L216;
            case 4402: goto L214;
            case 4403: goto L212;
            case 4404: goto L210;
            case 4405: goto L208;
            case 4406: goto L206;
            case 4407: goto L204;
            case 4408: goto L202;
            case 4409: goto L200;
            case 4410: goto L198;
            case 4411: goto L196;
            case 4412: goto L194;
            default: goto L20;
        };
    L20:
        switch(r1) {
            case 4500: goto L192;
            case 4501: goto L190;
            case 4502: goto L188;
            case 4503: goto L186;
            case 4504: goto L184;
            case 4505: goto L182;
            case 4506: goto L180;
            case 4507: goto L178;
            case 4508: goto L176;
            case 4509: goto L174;
            default: goto L21;
        };
    L21:
        switch(r1) {
            case 5000: goto L172;
            case 5001: goto L170;
            case 5002: goto L168;
            case 5003: goto L166;
            case 5004: goto L164;
            case 5005: goto L162;
            case 5006: goto L160;
            case 5007: goto L158;
            case 5008: goto L156;
            case 5009: goto L154;
            case 5010: goto L152;
            case 5011: goto L150;
            case 5012: goto L148;
            case 5013: goto L146;
            case 5014: goto L144;
            case 5015: goto L142;
            case 5016: goto L140;
            case 5017: goto L138;
            case 5018: goto L136;
            case 5019: goto L134;
            case 5020: goto L132;
            case 5021: goto L130;
            case 5022: goto L128;
            case 5023: goto L126;
            case 5024: goto L124;
            case 5025: goto L122;
            case 5026: goto L120;
            case 5027: goto L118;
            case 5028: goto L116;
            case 5029: goto L114;
            case 5030: goto L112;
            case 5031: goto L110;
            default: goto L22;
        };
    L22:
        switch(r1) {
            case 5040: goto L108;
            case 5041: goto L106;
            case 5042: goto L104;
            case 5043: goto L102;
            case 5044: goto L100;
            case 5045: goto L98;
            case 5046: goto L96;
            case 5047: goto L94;
            case 5048: goto L92;
            case 5049: goto L90;
            case 5050: goto L88;
            case 5051: goto L86;
            case 5052: goto L84;
            case 5053: goto L82;
            case 5054: goto L80;
            case 5055: goto L78;
            case 5056: goto L76;
            case 5057: goto L74;
            case 5058: goto L72;
            case 5059: goto L70;
            case 5060: goto L68;
            case 5061: goto L66;
            case 5062: goto L64;
            case 5063: goto L62;
            case 5064: goto L60;
            case 5065: goto L58;
            case 5066: goto L56;
            case 5067: goto L54;
            case 5068: goto L52;
            case 5069: goto L50;
            case 5070: goto L48;
            case 5071: goto L46;
            case 5072: goto L44;
            case 5073: goto L42;
            case 5074: goto L40;
            case 5075: goto L38;
            case 5076: goto L36;
            case 5077: goto L34;
            case 5078: goto L32;
            case 5079: goto L30;
            case 5080: goto L28;
            case 5081: goto L26;
            default: goto L23;
        };
    L23:
        return null;
    L26:
        return EXPIRE_CLEANED_MESSAGE_NOT_SUPPORT_UPDATE;
    L28:
        return FORWARD_NO_PERMISSION_TRANSMIT_HISTORY_MESSAGE;
    L30:
        return CREATE_MESSAGE_MYAI_UNSUPPORTED_LOW_VERSION;
    L32:
        return CREATE_MESSAGE_AT_USER_GROUP_DENIED;
    L34:
        return FORWARD_NO_VALID_TARGET;
    L36:
        return FORWARD_TO_THREAD_CHAT_THREAD_MISMATCH;
    L38:
        return CREATE_REPLY_IN_THREAD_ROOT_MESSAGE_RECALLED;
    L40:
        return CREATE_REPLY_IN_THREAD_SYSTEM_MESSAGE_UNSUPPORTED;
    L42:
        return CREATE_REPLY_IN_THREAD_FOLD_MESSAGE_UNSUPPORTED;
    L44:
        return CREATE_REPLY_IN_THREAD_CHAT_UNSUPPORTED;
    L46:
        return VC_CREATE_MESSAGE_USER_NOT_IN_MEETING;
    L48:
        return VC_CREATE_MESSAGE_CONFERENCE_ID_NOT_MATCH_CHANNEL_ID;
    L50:
        return UPDATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT;
    L52:
        return UPDATE_MESSAGE_TRIGGER_MSG_RATE_LIMIT;
    L54:
        return OPERATION_TO_PENDING_DELETE_FEED;
    L56:
        return UNABLE_TO_ADD_IMPORTANT_CONTACTS_MAX100;
    L58:
        return SUPER_CHAT_THREAD_SUBSCRIBE_TOO_MUCH;
    L60:
        return CREATE_MESSAGE_INVALID_USER_CARD;
    L62:
        return SUPER_CHAT_UNSUPPORTED_MESSAGE_TYPE;
    L64:
        return MESSAGE_NOT_FOUND;
    L66:
        return DLP_SENSITIVE_MESSAGE_BLOCKED;
    L68:
        return ONE_BY_ONE_FORWARD_MESSAGE_MAX_REACHED;
    L70:
        return PIN_LAN_FILE_MESSAGE_FAILED_WHILE_TRANSFERRING;
    L72:
        return REMOVE_LAN_FILE_MESSAGE_FAILED_WHILE_TRANSFERRING;
    L74:
        return GET_MESSAGE_POSITION_BY_TIMESTAMP_PARAMS_ERROR;
    L76:
        return GET_MESSAGE_POSITION_BY_TIMESTAMP_NUMBER_OF_CHAT_EXCEED_LIMIT;
    L78:
        return CREATE_ANONYMOUS_MESSAGE_NO_MORE_QUOTA;
    L80:
        return CREATE_ANONYMOUS_MESSAGE_SETTING_CLOSE;
    L82:
        return CREATE_MESSAGE_TRIGGER_CONTAINER_LIMIT;
    L84:
        return CREATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT_ENQUEUE;
    L86:
        return CREATE_MESSAGE_TRIGGER_USER_RATE_LIMIT;
    L88:
        return CREATE_MESSAGE_AT_ALL_DENIED;
    L90:
        return CHAT_LINK_INVITER_NOT_IN_CHAT;
    L92:
        return INVALID_CHAT_LINK_TOKEN;
    L94:
        return PIN_OPERATION_PERMISSION_DENIED;
    L96:
        return CREATE_MESSAGE_TRIGGER_CHAT_RATE_LIMIT;
    L98:
        return CREATE_MESSAGE_TRIGGER_PSM_RATE_LIMIT;
    L100:
        return INVALID_USER_NAME_LENGTH;
    L102:
        return MESSAGE_THREAD_NOT_FOUND;
    L104:
        return MESSAGE_CHANNEL_NOT_FOUND;
    L106:
        return MERGE_FORWARD_CONTENT_TWO_LARGE_FAIL;
    L108:
        return MERGE_FORWARD_CONTENT_REACH_LIMIT;
    L110:
        return TOO_SHORT_PUBLIC_GROUP_NAME;
    L112:
        return THREAD_CLOSED;
    L114:
        return RECOGNITION_WITH_EMPTY_RESULT;
    L116:
        return THREAD_ALREADY_WITHDRAW;
    L118:
        return ADD_CHAT_CHATTER_APPLY_NOT_OPEN;
    L120:
        return ADD_FRIEND_ERR_FOR_CHAT_MANNER_CLOSED;
    L122:
        return ADD_FRIEND_ERR_FOR_SEARCH_MANNER_CLOSED;
    L124:
        return NO_CHAT_ID_FOR_ADD_FRIEND;
    L126:
        return ADD_FRIEND_ERR_FOR_FRIEND_NOT_IN_CHAT;
    L128:
        return PROFILE_TOKEN_STOLEN;
    L130:
        return ADD_FRIENDS_TIMEOUT_VIA_CONTACT;
    L132:
        return NEED_UPGRADE_FOR_APPLY_CHECK;
    L134:
        return PUBLIC_CHAT_NAMED_EXISTED;
    L136:
        return PB_PAYLOAD_UNMARSHAL_ERR;
    L138:
        return PB_PACKET_UNMARSHAL_ERR;
    L140:
        return QR_CODE_INVITER_NOT_IN_CHAT;
    L142:
        return INVALID_QR_CODE;
    L144:
        return LARK_ACCOUNT_ID_NOT_MATCH_DOC;
    L146:
        return FORBID_CREATE_CHAT_FOR_NOT_FRIEND;
    L148:
        return INVALID_MAIL;
    L150:
        return INVALID_PHONE_FORMAT;
    L152:
        return FORBID_ADD_FRIEND_FOR_USER_PRIVATE_SETTING;
    L154:
        return FORBID_SEND_MESSAGE_FOR_NOT_FRIEND;
    L156:
        return REPEATED_PUT_CHAT_CHATTER_REQUEST;
    L158:
        return MESSAGE_CONTENT_TOO_LONG;
    L160:
        return UPDATE_CHAT_ICON_FAIL;
    L162:
        return CHAT_DESC_TOO_LONG;
    L164:
        return CHAT_NOT_FOUND_V2;
    L166:
        return INVALID_CHAT_TYPE;
    L168:
        return P2P_CHAT_USER_COUNT_GT_TWO;
    L170:
        return P2P_CHAT_NOT_CONTAIN_CREATOR_NOT;
    L172:
        return PARAM_ERR;
    L174:
        return CHAT_BOT_COUNT_GT_LIMIT;
    L176:
        return NO_PERM_THREAD_ID;
    L178:
        return INVALID_THREAD_ID;
    L180:
        return CHAT_IS_FROZEN;
    L182:
        return NOT_LATEST_LEAN_MODE_CONFIG;
    L184:
        return FORBID_DISSOLVED_CHAT_DURING_MEETING;
    L186:
        return FORBID_DELETE_USER_IN_MEETING;
    L188:
        return FORBID_FORWARD_MESSAGE_IN_RESTRICTED_MODE;
    L190:
        return DEVICE_IN_LEAN_MODE_CANNOT_USE_CRYPTO_CHAT;
    L192:
        return DEVICE_NOT_HAVE_LEAN_MODE_AUTHORITY;
    L194:
        return LARK_APP_NEED_UPGRADE;
    L196:
        return CAIJING_ACCOUNT_NEED_UPGRADE;
    L198:
        return HONGBAO_CANNOT_GRAB;
    L200:
        return HONGBAO_GRAB_TOO_FAST;
    L202:
        return HONGBAO_USER_NEED_AUTONYM;
    L204:
        return HONGBAO_INVALID_QUERY;
    L206:
        return HONGBAO_INVALID_USER;
    L208:
        return HONGBAO_EXPIRED;
    L210:
        return HONGBAO_ALREADY_GRAB;
    L212:
        return HONGBAO_ZERO_LEFT;
    L214:
        return HONGBAO_INVALID_CHAT;
    L216:
        return HONGBAO_PARAM_ERROR;
    L218:
        return GATEWAY_AUTH_SESSION_INCONSISTENT_WITH_PACKET_USER;
    L220:
        return SID_NOT_IN_FRONTIER_DOWNGRADE_PIPE;
    L222:
        return GATEWAY_AUTH_BAD_REQUEST;
    L224:
        return GATEWAY_AUTH_INVALID_TICKET;
    L226:
        return GATEWAY_AUTH_SESSION_DEVICE_MISMATCH;
    L228:
        return GATEWAY_AUTH_SESSION_NOT_FOUND;
    L230:
        return GATEWAY_AUTH_APP_TOKEN_NOT_FOUND;
    L232:
        return CREATE_MESSAGE_WITH_SOURCE_PARAM_INCOMPLETE;
    L234:
        return MESSAGE_SHARK_RISK_CONTROL_BLOCKED;
    L236:
        return AI_KNOWLEDGE_WORK_SPACE_NODE_NUM_OVER_LIMIT;
    L238:
        return AI_KNOWLEDGE_WORK_SPACE_NODE_HAS_BEEN_DELETED;
    L240:
        return AI_KNOWLEDGE_WORK_SPACE_NODE_NOT_EXISTS;
    L242:
        return AI_KNOWLEDGE_WIKI_ORG_ADMIN_RESTRICT_PERM_TOAST;
    L244:
        return AI_KNOWLEDGE_WIKI_SUB_MERCHANT_OUT_OF_LIMIT;
    L246:
        return AI_KNOWLEDGE_WIKI_ORDER_SALE_INFO_ERROR;
    L248:
        return AI_KNOWLEDGE_WIKI_ACCOUNT_NOT_ENOUGH;
    L250:
        return AI_KNOWLEDGE_WIKI_ORDER_STATE_REFRESH;
    L252:
        return AI_KNOWLEDGE_NO_WIKI_ORDER_OPERATOR_PERMISSION;
    L254:
        return AI_KNOWLEDGE_WIKI_ORDER_CREATING;
    L256:
        return AI_KNOWLEDGE_WIKI_DISCOUNT_CODE_NOT_MATCH;
    L258:
        return AI_KNOWLEDGE_WIKI_USER_NO_NEED_CREATE_ORDER;
    L260:
        return AI_KNOWLEDGE_JOIN_WIKI_SPACE_NEED_PAID;
    L262:
        return AI_KNOWLEDGE_REFUND_IS_REQUIRED_BEFORE_DELETION;
    L264:
        return AI_KNOWLEDGE_SEARCH_DEPARTMENT_LIMIT_EXCEED;
    L266:
        return AI_KNOWLEDGE_WIKI_ASK_TOO_OFTEN;
    L268:
        return AI_KNOWLEDGE_CANT_VIEW_WIKI_QA_REDIRECT;
    L270:
        return AI_KNOWLEDGE_SCHEDULE_TASK_DUPLICATED;
    L272:
        return AI_KNOWLEDGE_AI_PRODUCTIVITY_REPORT_NO_PERMISSION;
    L274:
        return AI_KNOWLEDGE_AI_PRODUCTIVITY_REPORT_RECORD_NOT_FOUND;
    L276:
        return AI_KNOWLEDGE_CHECK_DISCOUNT_CODE_OVER_LIMIT;
    L278:
        return AI_KNOWLEDGE_REMAINING_TRIAL_COUNT_IS_ZERO;
    L280:
        return AI_KNOWLEDGE_WIKI_DISCOUNT_OVER_LIMIT;
    L282:
        return AI_KNOWLEDGE_MISSING_DISCOUNT_CODE;
    L284:
        return AI_KNOWLEDGE_NEED_UPGRADE_VERSION;
    L286:
        return AI_KNOWLEDGE_DISCOUNT_CODE_INVALID;
    L288:
        return AI_KNOWLEDGE_DISCOUNT_CODE_IS_USED;
    L290:
        return AI_KNOWLEDGE_GEN_DISCOUNT_CODE_OVER_LIMIT;
    L292:
        return AI_KNOWLEDGE_SCHEDULE_TASK_NOT_EXIST;
    L294:
        return AI_KNOWLEDGE_SCHEDULE_TASK_OVER_LIMITED;
    L296:
        return AI_KNOWLEDGE_NOT_SUPER_ADMIN;
    L298:
        return AI_KNOWLEDGE_NO_SEND_HONG_BAO_PERMISSION;
    L300:
        return AI_KNOWLEDGE_WIKI_NOT_EXISTS;
    L302:
        return AI_KNOWLEDGE_WIKI_NOT_RELEASE;
    L304:
        return AI_KNOWLEDGE_WIKI_IS_PRIVATE;
    L306:
        return AI_KNOWLEDGE_FEATURE_DISCONTINUED;
    L308:
        return AI_KNOWLEDGE_USER_CREATE_WIKI_OVER_LIMIT;
    L310:
        return AI_KNOWLEDGE_WIKI_INFO_CONTAINS_SENSITIVE_WORDS;
    L312:
        return AI_KNOWLEDGE_USER_MANAGED_WIKI_OVER_LIMIT;
    L314:
        return AI_KNOWLEDGE_USER_JOINED_WIKI_OVER_LIMIT;
    L316:
        return AI_KNOWLEDGE_NEED_JOIN_WIKI;
    L318:
        return AI_KNOWLEDGE_MANAGER_CANNOT_QUIT_WIKI;
    L320:
        return AI_KNOWLEDGE_NO_WIKI_VIEW_PERMISSION;
    L322:
        return AI_KNOWLEDGE_NO_WIKI_OPERATOR_PERMISSION;
    L324:
        return AI_KNOWLEDGE_CONVERT_TO_QUERY_ERROR;
    L326:
        return AI_KNOWLEDGE_AI_TOPIC_IS_DELETED;
    L328:
        return AI_KNOWLEDGE_PULL_ANSWER_CACHE_EMPTY;
    L330:
        return AI_KNOWLEDGE_SHARE_IMAGE_EXCEED_LENGTH_LIMIT;
    L332:
        return AI_KNOWLEDGE_SHARE_IMAGE_TIME_OUT;
    L334:
        return AI_KNOWLEDGE_SHARE_IMAGE_INVALID_URL;
    L336:
        return AI_KNOWLEDGE_NEED_LOGIN;
    L338:
        return AI_KNOWLEDGE_SHARE_LINK_DISABLE;
    L340:
        return AI_KNOWLEDGE_ANSWER_UNAVAILABLE;
    L342:
        return AI_KNOWLEDGE_IMAGE_TNS_INPUT;
    L344:
        return AI_KNOWLEDGE_ANSWER_TNS_OUTPUT;
    L346:
        return AI_KNOWLEDGE_ANSWER_TNS_INPUT;
    L348:
        return AI_KNOWLEDGE_ANSWER_INTERNAL;
    L350:
        return TY_SINGLE_CHAT_OVER_LIMIT;
    L352:
        return TY_SINGLE_CHAT_FORBIDDEN_TRIGGER;
    L354:
        return MEMORY_UNREAD_SUMMARY_OVER_LIMIT;
    L356:
        return MEMORY_UNREAD_SUMMARY_NO_PERMISSION;
    L358:
        return MY_AI_SCENE_ALREADY_ADDED;
    L360:
        return MY_AI_PLUGIN_SELECTION_EXPIRED;
    L362:
        return MY_AI_QUICK_ACTION_EXPIRED;
    L364:
        return My_AI_ALREADY_NEW_TOPIC;
    L366:
        return MY_AI_ALREADY_INIT_SUCCESS;
    L368:
        return AUTH_SYSTEM_BANNER_BLOCKED;
    L370:
        return AUTH_OWNER_OR_ADMIN_BLOCKED;
    L372:
        return AUTH_USER_NOT_IN_CHAT;
    L374:
        return LOCK_CHAT_FAILED;
    L376:
        return SPECIAL_PROTECT_CHAT_TRIGGER_LIMITER;
    L378:
        return WRITE_CHAT_TRIGGER_LIMITER;
    L380:
        return CREATE_GROUP_CHAT_TRIGGER_LIMITER;
    L382:
        return Lark_IM_ExportMsgToDocs_CCM_FAIL;
    L384:
        return Lark_IM_ExportMsgToDocs_WRONG_PARAM;
    L386:
        return Lark_IM_ExportMsgToDocs_EMPTY_PARAM;
    L388:
        return Lark_IM_ExportMsgToDocs_ALL_MSG_IS_RESTRICTED;
    L390:
        return Lark_IM_ExportMsgToDocs_CHAT_CAN_NOT_Export;
    L392:
        return Lark_IM_ExportMsgToDocs_ExportFail_Toast;
    L394:
        return Lark_IM_ExportMsgToDocs_DisabledDueToRestrictedMode_Toast;
    L396:
        return Lark_IM_ExportMsgToDocs_DisabledDueToRestrictSharing_Toast;
    L398:
        return OnTimeDelGlobalSwitchIsOff;
    L400:
        return URL_PREVIEW_NEED_GET_CARD_PREVIEW;
    L402:
        return URL_PREVIEW_RESOURCE_EXHAUSTED;
    L404:
        return URL_PREVIEW_RESOURCE_UNAVAILABLE;
    L406:
        return URL_PREVIEW_SERVICE_UNAVAILABLE;
    L408:
        return URL_PREVIEW_URL_MISMATCH;
    L410:
        return URL_PREVIEW_APP_CONTEXT_MISSING;
    L412:
        return URL_PREVIEW_PERMISSION_DENIED;
    L414:
        return MESSAGE_TENANT_PUSH_BUSINESS_NOT_SUPPORT;
    L416:
        return MESSAGE_TENANT_PUSH_DUPLICATE_REQUEST;
    L418:
        return CANNOT_TRANSFER_TEAM_DEFAULT_CHAT_OWNER;
    L420:
        return CANNOT_RESOLVE_TEAM_DEFAULT_CHAT;
    L422:
        return CANNOT_SHARE_TEAM_CHAT;
    L424:
        return FORBID_SELECT_EXTERNAL_CONTACTS;
    L426:
        return CHAT_IS_BIND_ANOTHER_TEAM;
    L428:
        return FORBID_SELECT_NOT_OWN_CHAT;
    L430:
        return FORBID_CREATE_TEAM_CHAT;
    L432:
        return FORBID_BIND_TEAM_CHAT;
    L434:
        return FORBID_ADD_TEAM_MEMBERS;
    L436:
        return CREATE_TEAM_REACH_LIMIT;
    L438:
        return UNABLE_TO_ADD_SOME_MEMBERS;
    L440:
        return FORBID_CHAT_SETTING_IN_TEAM;
    L442:
        return FORBID_OPERATE_CHAT_IN_TEAM;
    L444:
        return NEW_TEAM_OWNER_NOT_SET;
    L446:
        return WILL_OVERFLOW_AFTER_ADD_MEMBER;
    L448:
        return WILL_OVERFLOW_AFTER_BIND_CHAT;
    L450:
        return CANNOT_ADD_OR_LEAVE_IN_TEAM_CHAT;
    L452:
        return SAME_TEAM_NAME_IN_TENANT;
    L454:
        return SAME_CHAT_NAME_IN_TEAM;
    L456:
        return FEED_GROUP_NAME_DUPLICATE_ERROR;
    L458:
        return LARKTODO_TASK_LIST_NOT_BLAND;
    L460:
        return LARKTODO_TASK_LIST_PROCESSING;
    L462:
        return LARKTODO_TODO_EDITTED;
    L464:
        return LARKTODO_TODO_NOT_FOUND_ERROR;
    L466:
        return LARKTODO_REACH_LIMIT_ERROR;
    L468:
        return DEFAULT_NAMECARD_ERROR;
    L470:
        return DELETED_NAMECARD;
    L472:
        return NAME_NIL;
    L474:
        return PHONE_DUPLICATE;
    L476:
        return PHONE_INVALID;
    L478:
        return EMAIL_DUPLICATE;
    L480:
        return EMAIL_INVALID;
    L482:
        return NAVIGATION_SAVE_ORDER_FAIL;
    L484:
        return NAVIGATION_GET_TENANT_ORDER_FAIL;
    L486:
        return NAVIGATION_REQ_VERSION_NOT_LATEST;
    L488:
        return NAVIGATION_GET_APP_INFO_FAIL;
    L490:
        return NAVIGATION_GET_ORDER_FAIL;
    L492:
        return NAVIGATION_TENANT_ID_NOT_VALID;
    L494:
        return NAVIGATION_USER_ID_NOT_VALID;
    L496:
        return NAVIGATION_UNIQUE_ID_DUPLICATE;
    L498:
        return NAVIGATION_CUSTOM_APP_NOT_UNIQUE;
    L500:
        return NAVIGATION_CUSTOM_APP_BEYOND_LIMIT;
    L502:
        return UG_REACH_CORE_ERROR;
    L504:
        return UG_REACH_REPORT_GUIDE_FAIL;
    L506:
        return UG_REACH_LACK_REQUEST_PARAMETER;
    L508:
        return UG_REACH_DUPLICATE_REQUEST;
    L510:
        return CROSS_WITH_KA_CANT_SEE_PROFILE;
    L512:
        return CROSS_WITH_KA_UNABLE_TO_REMOVE_MEMBER;
    L514:
        return CROSS_WITH_KA_UNABLE_TO_INVITE_GROUP_MEMBER;
    L516:
        return CROSS_WITH_KA_CHAT_SETTINGS_UNAVAILABLE;
    L518:
        return CROSS_WITH_KA_UNABLE_TO_CREATE_GROUP_CHAT;
    L520:
        return CROSS_WITH_KA_UNABLE_TO_FORWARD_MESSAGE;
    L522:
        return CROSS_WITH_KA_UNABLE_TO_SEND_MESSAGE;
    L524:
        return CROSS_WITH_KA_MESSAGE_ACTIONS_UNAVAILABLE;
    L526:
        return CROSS_WITH_KA_FEATURE_UNAVAILABLE;
    L528:
        return MOMENTS_REACH_LIMIT_ERROR;
    L530:
        return MOMENTS_CANNOT_EDIT_COMMENT;
    L532:
        return MOMENTS_CANNOT_EDIT_POST;
    L534:
        return MOMENTS_CANNOT_SHARE_KEEP_POST;
    L536:
        return MOMENTS_CANNOT_SHARE_POST_NOT_AVAILABLE;
    L538:
        return MOMENTS_CANNOT_READ;
    L540:
        return MOMENTS_CANNOT_CREATE_COMMENT;
    L542:
        return MOMENTS_CANNOT_CREATE_POST;
    L544:
        return MOMENTS_CONTENT_ERROR;
    L546:
        return MOMENTS_SET_SELF_VISIBLE_FAILED;
    L548:
        return MOMENTS_SET_RISK_WARNING_FAILED;
    L550:
        return MOMENTS_PIN_COMMENT_FAILED;
    L552:
        return MOMENTS_PIN_POST_FAILED;
    L554:
        return MOMENTS_DUPLICATE_NICKNAME;
    L556:
        return MOMENTS_BAD_USER_ID;
    L558:
        return MOMENTS_PARAM_ERROR;
    L560:
        return MOMENTS_NO_OFFICIAL_USER_PERMISSION;
    L562:
        return MOMENTS_PERMISSION_ERROR;
    L564:
        return MOMENTS_SESSION_ERROR;
    L566:
        return MOMENTS_STOPPED_FEATURE;
    L568:
        return MOMENTS_UNKNOWN_ERROR;
    L570:
        return ACCESS_FILE_AUTH_NO_PASS;
    L572:
        return LAN_TRANS_AUTH_FEATURE_NOT_ALLOWED;
    L574:
        return LAN_TRANS_AUTH_ONLINE_DEVICES_NOT_FOUND;
    L576:
        return LAN_TRANS_AUTH_AUTH_CHAT_FAILED;
    L578:
        return LAN_TRANS_AUTH_FAILED;
    L580:
        return LAN_TRANS_AUTH_PASS;
    L582:
        return SYNC_TO_CHAT_MESSAGE_NOT_SUPPORT_REPLY_IN_THREAD;
    L584:
        return MESSAGE_CROSS_KA_CHAT_UNSUPPORTED_MESSAGE_TYPE;
    L586:
        return CREATE_MESSAGE_WITH_SOURCE_UNSUPPORTED_CRYPTO_MESSAGE;
    L588:
        return MESSAGE_COULD_NOT_SEND_ENCRYPTMSG;
    L590:
        return CREATE_MESSAGE_WITH_SOURCE_CONTENT_INVALID;
    L592:
        return CREATE_MESSAGE_WITH_SOURCE_NO_SCOPE;
    L594:
        return CREATE_MESSAGE_WITH_SOURCE_TICKET_INVALID;
    L596:
        return CREATE_MESSAGE_WITH_SOURCE_OWNERID_INVALID;
    L598:
        return CREATE_MESSAGE_WITH_SOURCE_BOT_NO_PERMISSION;
    L600:
        return PUT_OTHER_TENANT_REACTION;
    L602:
        return SYNCTOCHAT_OPERATE_NOT_SUPPORT_THIS_SCENE;
    L604:
        return RETENTION_BATCH_DELETE_NOT_SUPPORT_MESSAGE_ACTION;
    L606:
        return RETENTION_BATCH_DELETE_NO_MESSAGE_NEED_DELETE;
    L608:
        return RETENTION_BATCH_DELETE_CHAT_NOT_SUPPORT;
    L610:
        return SYNCTOCHAT_MESSAGE_FORBID_REPLY_IN_THREAD;
    L612:
        return MYAI_CHAT_MESSAGE_NOT_SUPPORT_OPERATION;
    L614:
        return MESSAGE_IS_CLEANED;
    L616:
        return MESSAGE_RESTRICTED_MODE_IS_BURNED;
    L618:
        return MESSAGE_RESTRICTED_MODE_WILL_BURNED;
    L620:
        return MESSAGE_DISABLE_ACTION_FOR_RESTRICTED_MODE_BURNED;
    L622:
        return RESTRICTED_MESSAGE_FORBID_PUT_LINK;
    L624:
        return RESTRICTED_MESSAGE_ALREADY_CLOSE;
    L626:
        return RESTRICTED_MESSAGE_ALREADY_OPEN;
    L628:
        return RESTRICTED_MESSAGE_NOT_SUPPORT_SCENE;
    L630:
        return LARK_IM_MESSAGERE_STRICTED_UNABLE;
    L632:
        return RESTRICTED_MESSAGE_FAILED_TO_CLOSE;
    L634:
        return RESTRICTED_MESSAGE_FAILED_TO_OPEN;
    L636:
        return RESTRICTED_MESSAGE_FORBID_FORWARD_MESSAGE;
    L638:
        return RESTRICTED_MESSAGE_FORBID_CLOSE_SWITCH;
    L640:
        return RESTRICTED_MESSAGE_FORBID_OPEN_SWITCH;
    L642:
        return SCHEDULE_MESSAGE_FAILED_TO_SEND_BY_USER_RESIGN;
    L644:
        return SCHEDULE_MESSAGE_FAILED_TO_UPDATE;
    L646:
        return SCHEDULE_MESSAGE_FAILED_TO_CREATE;
    L648:
        return SCHEDULE_MESSAGE_ENTITY_PENDING_COUNT_OVER_LIMIT;
    L650:
        return SCHEDULE_MESSAGE_CHAT_PENDING_COUNT_OVER_LIMIT;
    L652:
        return MESSAGE_DLP_FAILED_TO_PULL_MESSAGE_LINK;
    L654:
        return MESSAGE_DLP_FAILED_TO_PUT_STICKERS;
    L656:
        return MESSAGE_DLP_FAILED_TO_PUT_CHAT_TOP_NOTICE;
    L658:
        return MESSAGE_DLP_FAILED_TO_PIN_MESSAGE;
    L660:
        return MESSAGE_DLP_FAILED_TO_PREVIEW_FILE_DENY;
    L662:
        return MESSAGE_DLP_FAILED_TO_DOWNLOAD_ORIGIN_IMAGE_DETECTING;
    L664:
        return MESSAGE_DLP_FAILED_TO_DOWNLOAD_FILE_DETECTING;
    L666:
        return MESSAGE_DLP_FAILED_TO_DOWNLOAD_ORIGIN_IMAGE_DENY;
    L668:
        return MESSAGE_DLP_FAILED_TO_DOWNLOAD_FILE_DENY;
    L670:
        return MESSAGE_DLP_FAILED_TO_SEND_MESSAGE;
    L672:
        return INVALID_CIPHER_FAILED_TO_UPLOAD_FILE;
    L674:
        return INVALID_CIPHER_FAILED_TO_ACCESS_FILE;
    L676:
        return INVALID_CIPHER_FAILED_TO_OPERATE_MESSAGE;
    L678:
        return INVALID_CIPHER_FAILED_TO_SEND_MESSAGE;
    L680:
        return EM_GET_DATA_FAILED;
    L682:
        return EM_TASK_ALREADY_DONE;
    L684:
        return EM_AUTH_FAILED;
    L686:
        return EM_REDUNDANT_TASK;
    L688:
        return DATA_EXPORT_USER_TTP_GEO_BLOCKED;
    L690:
        return DATA_EXPORT_CHAT_TTP_GEO_BLOCKED;
    L692:
        return DATA_EXPORT_INVALID_ATTACHMENT_INFO;
    L694:
        return DATA_EXPORT_NO_MESSAGE_MATCH_KEYWORDS;
    L696:
        return DATA_EXPORT_REACH_GLOBAL_TASK_LIMIT;
    L698:
        return DATA_EXPORT_REACH_TENANT_TASK_LIMIT;
    L700:
        return DATA_EXPORT_TASK_ALREADY_EXIST;
    L702:
        return DATA_EXPORT_TASK_TERMINATED;
    L704:
        return DATA_EXPORT_ATTACHMENG_ID_ERROR;
    L706:
        return DATA_EXPORT_EXECUTE_TASK_TIMEOUT;
    L708:
        return DATA_EXPORT_CREATE_TASK_CONFLICT;
    L710:
        return DATA_EXPORT_REQUEST_PARAM_ERROR;
    L712:
        return DATA_EXPORT_TASK_NOT_FOUND;
    L714:
        return EDU_INVITATION_SEND_MESSAGE_FREQUENCY;
    L716:
        return EDU_HOME_SCHOOL_CHAT_CREATED;
    L718:
        return EDU_CLASS_INVALID;
    L720:
        return EDU_NOT_AUTHORIZED;
    L722:
        return EDU_UNKNOWN_SYSTEM_ERROR;
    L724:
        return ZAXIS_AUTH_REVOKED;
    L726:
        return ZAXIS_DEPENDENCY_ERROR;
    L728:
        return ZAXIS_ENTITY_NOT_FOUND;
    L730:
        return ZAXIS_NOT_LOGGED_IN;
    L732:
        return ZAXIS_NOT_AUTHORIZED;
    L734:
        return ZAXIS_INVALID_AUTH_TOKEN;
    L736:
        return ZAXIS_INVALID_AUTH_CODE;
    L738:
        return ZAXIS_BAD_REQUEST;
    L740:
        return ZAXIS_UNKNOWN_SYSTEM_ERROR;
    L742:
        return OAUTH_INVALID_CHANNEL;
    L744:
        return OAUTH_NOT_AUTHORIZED;
    L746:
        return OAUTH_INVALID_CODE;
    L748:
        return OAUTH_INVALID_STATE;
    L750:
        return OAUTH_SERVER_ERROR;
    L752:
        return ILLEGAL_REQUEST_ERROR;
    L754:
        return UNKNOWN_SYSTEM_ERROR;
    L756:
        return APPLICATION_REASON_EXCEED_LIMIT;
    L758:
        return CONTACT_REQUEST_SENT_PLEASE_WAIT;
    L760:
        return CANT_ADD_CONTACT_BLOCK_OTHER;
    L762:
        return CANT_ADD_CONTACT_BE_BLOCKED;
    L764:
        return PLEASE_WAIT_MULTIPLE_USERS;
    L766:
        return PLEASE_WAIT_GENERAL;
    L768:
        return FORBID_ADD_LINK_DISABLE;
    L770:
        return FORBID_ADD_NAME_CARD_DISABLE;
    L772:
        return FORBID_ADD_SEARCH_DISABLE;
    L774:
        return CONTACT_IN_SAME_TENANT;
    L776:
        return NEW_CONTACT_EXCEED_LIMIT;
    L778:
        return CONTACT_NUM_EXCEED_LIMIT;
    L780:
        return COLLABORATION_NO_SEND_MESSAGE_TO_MY_AI;
    L782:
        return COLLABORATION_AUTH_FAILED_CAN_APPLY;
    L784:
        return AUTH_MESSAGE_FAILED_RETRY;
    L786:
        return COLLABORATION_AUTH_P2P_BOT_SEND_MESSAGE_FAILED;
    L788:
        return COLLABORATION_AUTH_P2P_SEND_MESSAGE_FAILED;
    L790:
        return TARGET_EXTERNAL_COORDINATE_CTL;
    L792:
        return EXTERNAL_COORDINATE_CTL;
    L794:
        return COLLABORATION_AUTH_NO_PERMISSION;
    L796:
        return CHAT_WITH_NO_CONTACTS_REACH_DAILY_LIMIT;
    L798:
        return COLLABORATION_AUTH_FAILED_TARGET_PRIVACY_SETTING;
    L800:
        return COLLABORATION_AUTH_FAILED_PRIVACY_SETTING;
    L802:
        return COLLABORATION_AUTH_FAILED_BE_BLOCKED;
    L804:
        return COLLABORATION_SEND_MSG_REACH_LIMIT;
    L806:
        return COLLABORATION_AUTH_FAILED_NO_RIGHTS;
    L808:
        return COLLABORATION_AUTH_FAILED_BLOCKED;
    L810:
        return MAIL_AI_PUSH_ONBOARDING_CARD_LAST_MSG_ID_NOT_FOUND;
    L812:
        return MAIL_AI_PUSH_ONBOARDING_CARD_VERSION_OVERDUE;
    L814:
        return MAIL_AI_ACTION_ID_INVALID;
    L816:
        return MAIL_FEED_FOLLOWEE_NOT_EXISTS;
    L818:
        return MAIL_FEED_NOT_EXTERNAL_ADDRESS;
    L820:
        return MAIL_TEMPLATE_OTHER_PARAM_ERROR;
    L822:
        return MAIL_TEMPLATE_TOTAL_SIZE_LIMIT;
    L824:
        return MAIL_TEMPLATE_BATCH_SIZE_LIMIT;
    L826:
        return MAIL_TEMPLATE_INVALID_TEMPLATE_ID;
    L828:
        return MAIL_TEMPLATE_CONTENT_SIZE_LIMIT;
    L830:
        return MAIL_TEMPLATE_TEMPLATE_NUMBER_LIMIT;
    L832:
        return MAIL_TEMPLATE_INVALID_TEMPLATE_NAME;
    L834:
        return MAIL_SEND_READ_RECEIPT_DEDUPLICATE;
    L836:
        return MAIL_DEDUPLICATE_DELETE;
    L838:
        return MAIL_UPLOAD_EML_GET_LOCK_FAIL;
    L840:
        return MAIL_UPLOAD_EML_SIZE_TOO_LARGE;
    L842:
        return MAIL_MAIL_STATE_ILLEGAL;
    L844:
        return MAIL_GROUP_CHAT_TENANT_DOMAIN_NOT_VALID;
    L846:
        return MAIL_GROUP_CHAT_TENANT_PERMISSION_DENIED;
    L848:
        return MAIL_GROUP_CHAT_TYPE_PERMISSION_DENIED;
    L850:
        return MAIL_GROUP_CHAT_AUTH_PERMISSION_DENIED;
    L852:
        return MAIL_MESSAGE_NOT_EXIST;
    L854:
        return MAIL_READ_STATISTICS_RESULT_NOT_READY;
    L856:
        return MAIL_SEARCH_BAD_REQUEST;
    L858:
        return MAIL_NAME_CARD_INVALID_OPERATE_USER;
    L860:
        return MAIL_IMAGE_NO_PERMISSION;
    L862:
        return MAIL_SIGNATURE_INVALID_OPERATE_USER;
    L864:
        return MAIL_SIGNATURE_NAME_DUPLICATE;
    L866:
        return MAIL_USER_ALLOW_BLOCK_SELF_DOMAIN;
    L868:
        return MAIL_USER_ALLOW_BLOCK_SELF_ADDRESS;
    L870:
        return MAIL_USER_ALLOW_BLOCK_DATA_INVALID;
    L872:
        return MAIL_GROUP_UNSUBSCRIBE_TYPE_UNSUPPORTED;
    L874:
        return MAIL_GROUP_UNSUBSCRIBE_DENIED;
    L876:
        return MAIL_GROUP_VIEW_PERMISSION_DENIED;
    L878:
        return MAIL_GROUP_NOT_FOUND;
    L880:
        return MAIL_NOT_VALID_ADDRESS;
    L882:
        return MAIL_OVER_LIMIT_COUNT;
    L884:
        return MAIL_GROUP_MANAGEMENT_PERMISSION_DENIED;
    L886:
        return MAIL_LONG_RUNNING_TASK_MIGRATION_REJECT;
    L888:
        return MAIL_LONG_RUNNING_TASK_SERVER_LIMIT;
    L890:
        return MAIL_LONG_RUNNING_TASK_BLOCK_NO_RETRY;
    L892:
        return MAIL_LONG_RUNNING_TASK_BLOCK;
    L894:
        return MAIL_MESSAGE_HAS_BEEN_RECALLED;
    L896:
        return MAIL_MESSAGE_NOT_IN_SENT_STATE;
    L898:
        return MAIL_MESSAGE_SENT_LONG_TIME_AGO;
    L900:
        return MAIL_REQUEST_PARAMS_LENGTH_LIMIT;
    L902:
        return MAIL_BASIC_EMAIl_PERMISSION_DISABLE;
    L904:
        return MAIL_USER_ID_COMMAND_PROCESSED_LIMIT;
    L906:
        return MAIL_COMMON_PARAM_INVALID;
    L908:
        return MAIL_COMMON_RPC_FAIL;
    L910:
        return MAIL_COMMON_DB_ERROR;
    L912:
        return MAIL_ADD_CHANGE_NO_IMPLEMENTED;
    L914:
        return MAIL_NO_DRIVE_PERMISSION;
    L916:
        return MAIL_ADD_CHANGE_IS_PROCESSING;
    L918:
        return MAIL_USER_ID_DEVICE_ID_PROCESSED_LIMIT;
    L920:
        return MAIL_ADD_CHANGE_OUT_OF_SYNC;
    L922:
        return STICKER_SET_ALREADY_EXISTS;
    L924:
        return HONGBAO_LICENSE_AUTH_FAILED;
    L926:
        return CHAT_NAME_TRANSLATE_FAILED;
    L928:
        return CHAT_PIN_NUM_REACH_LIMIT;
    L930:
        return CROSS_TENANT_CHAT_USER_OVER_LIMIT_NEED_APPLY;
    L932:
        return CHAT_USER_OVER_LIMIT_NEED_APPLY;
    L934:
        return CERT_TENANT_ADD_CHAT_CHATTER_REACH_LIMIT;
    L936:
        return BLOCK_BY_SHARK;
    L938:
        return CHAT_BANNED_BY_TNS;
    L940:
        return BLOCK_BY_STRANGER_RELATION;
    L942:
        return CHAT_SECURITY_CHECK_BLOCK;
    L944:
        return ANALYZE_SHEET_FAIL;
    L946:
        return ANALYZE_SHEET_REACH_CHAT_CHATTER_COUNT_LIMIT;
    L948:
        return ANALYZE_SHEET_EMPTY_FILE;
    L950:
        return ANALYZE_SHEET_NO_EDIT_PERM;
    L952:
        return LARK_FAV_LAN_TRANS_FILE_REFUSE;
    L954:
        return PRICING_PACKAGE_AUTO_TRANSLATE_DISALLOWED;
    L956:
        return PRICING_PACKAGE_CRYPTO_CHAT_URGENT_DISALLOWED;
    L958:
        return PRICING_PACKAGE_CRYPTO_CHAT_DISALLOWED;
    L960:
        return PRICING_PACKAGE_ADD_CHAT_CHATTER_REACH_LIMIT;
    L962:
        return PRICING_PACKAGE_URGENT_REACH_LIMIT;
    L964:
        return PRICING_PACKAGE;
    L966:
        return CREATE_MESSAGE_GENERATION_SHARE_CARD_FAILURE;
    L968:
        return CREATE_MESSAGE_SHARE_USER_CARD_NO_FRIENDSHIP;
    L970:
        return CREATE_MESSAGE_BLOCK_IN_THREAD_DISPLAY_MODE;
    L972:
        return CREATE_MESSAGE_INVALID_SHARED_GROUP_CHAT;
    L974:
        return PULL_GROUP_CHAT_MEMBER_VERSION_RETRY;
    L976:
        return SEND_MISSING_CRYPTO_MESSAGE_MISSING_MAIN_CONTENT;
    L978:
        return SEND_MISSING_CRYPTO_MESSAGE_MISSING_CONTENT;
    L980:
        return CURRENT_CHAT_NOT_CAN_SET_SEARCH;
    L982:
        return ADD_CHAT_CHATTER_APPLY_ALREADY_PROCESSED;
    L984:
        return CHAT_ADMIN_USER_REACH_LIMIT;
    L986:
        return STATIC_RESOURCE_INVALID_COMPRESS_ALGORITHM;
    L988:
        return STATIC_RESOURCE_COMPRESSED_FOLDER_GONE;
    L990:
        return STATIC_RESOURCE_API_HARDLINK_Key_EXCEED_LIMIT;
    L992:
        return STATIC_RESOURCE_API_HARDLINK_FAILED;
    L994:
        return STATIC_RESOURCE_IMAGE_OCR_FAILED;
    L996:
        return STATIC_RESOURCE_UNCOMPRESS_SUB_FILES_NUMBER_EXCEED_LIMIT;
    L998:
        return STATIC_RESOURCE_UNCOMPRESS_DEPTH_EXCEED_LIMIT;
    L1000:
        return STATIC_RESOURCE_UNCOMPRESS_SIZE_EXCEED_LIMIT;
    L1002:
        return STATIC_RESOURCE_UNCOMPRESS_UNSUPPORT_FORMAT;
    L1004:
        return STATIC_RESOURCE_UNCOMPRESS_NOT_ALLOW;
    L1006:
        return STATIC_RESOURCE_UNCOMPRESS_UNABLE;
    L1008:
        return STATIC_RESOURCE_FOLDER_SUB_FILES_NUMBER_EXCEED_LIMIT;
    L1010:
        return STATIC_RESOURCE_FOLDER_DEPTH_EXCEED_LIMIT;
    L1012:
        return STATIC_RESOURCE_UPLOAD_FOLDER_EMPTY;
    L1014:
        return STATIC_RESOURCE_DOWNLOAD_RISKY_NAME;
    L1016:
        return STATIC_RESOURCE_UPLOAD_RISKY_NAME;
    L1018:
        return INVALID_FACE_TO_FACE_TOKEN;
    L1020:
        return REQUEST_OVER_FREQUENCY;
    L1022:
        return IM_STORAGE_DESTROY_BY_OWN;
    L1024:
        return IM_FILE_DATA_RETENTION;
    L1026:
        return IM_TENANT_STORAGE_QUOTA_LIMIT;
    L1028:
        return IM_DEPARTMENT_STORAGE_QUOTA_LIMIT;
    L1030:
        return IM_USER_STORAGE_QUOTA_LIMIT;
    L1032:
        return IM_FILE_DELETE_BY_CSAM;
    L1034:
        return IM_FILE_API_QPS_LIMIT;
    L1036:
        return IM_FILE_API_NOT_AVAILABLE;
    L1038:
        return IM_FILE_PARAM_NOT_SUPPORT;
    L1040:
        return IM_STORAGE_CAPACITY_LIMIT;
    L1042:
        return IM_STORAGE_DESTROY_BY_ADMIN;
    L1044:
        return IM_STORAGE_DELETED_BY_ADMIN;
    L1046:
        return STATIC_RESOURCE_UPLOAD_NOT_COMPLETE;
    L1048:
        return STATIC_RESOURCE_NOT_EXIST;
    L1050:
        return STATIC_RESOURCE_DELETED_BY_ADMIN;
    L1052:
        return FG_KA_CROSS_SEND_MESSAGE_FORBID;
    L1054:
        return STATIC_RESOURCE_DOWNLOAD_LAN_FILE_FROM_SERVER;
    L1056:
        return CHAT_CROSS_WITH_KA_UNSUPPORTED_MESSAGE_TYPE;
    L1058:
        return LARK_CERTIFICATE_DECRYPTION_KEY_INVALID;
    L1060:
        return STATIC_RESOURCE_SHREDDED_BY_ADMIN;
    L1062:
        return STATIC_RESOURCE_FROZEN_BY_ADMIN;
    L1064:
        return FILEINFO_IS_DELETED;
    L1066:
        return COPY_MESSAGE_AUTHED_ID_NIL;
    L1068:
        return SENSITIVE_USER_NAME;
    L1070:
        return SENSITIVE_MESSAGE_BLOCKED;
    L1072:
        return SHARE_CHAT_DEPRECATED;
    L1074:
        return NO_PERMISSION_EDITING_DOC_FOR_OLD_VERSION;
    L1076:
        return UPDATE_CONTAINER_MESSAGE_IS_ILLEGAL;
    L1078:
        return EDIT_MESSAGE_DELETED;
    L1080:
        return EDIT_MESSAGE_IS_ENCRYPT;
    L1082:
        return EDIT_MESSAGE_IS_ILLEGAL;
    L1084:
        return EDIT_MESSAGE_IS_CRYPTO;
    L1086:
        return EDIT_MESSAGE_SENSITIVE_WORDS_REVIEW_FAIL;
    L1088:
        return EDIT_MESSAGE_DLP_REVIEW_FAIL;
    L1090:
        return EDIT_MESSAGE_SUBMIT_FOR_REVIEW_FAIL;
    L1092:
        return EDIT_MESSAGE_USER_CAN_NOT_SEND_MESSAGE;
    L1094:
        return EDIT_MESSAGE_USER_NOT_IN_MESSAGE_CHAT;
    L1096:
        return EDIT_MESSAGE_USERID_NOT_SAME_FROM_REQUEST;
    L1098:
        return EDIT_MESSAGE_NOT_VISIBLE;
    L1100:
        return FORBID_TRANSMIT_ONE_AUDIO_MESSAGE;
    L1102:
        return CRYPTO_CHAT_UNSUPPORTED_ADD_BOTS;
    L1104:
        return NO_PERMISSION_USE_OTHER_TENANT_EMOJI;
    L1106:
        return OPERATE_MESSAGE_NOT_FROM_SAME_CHAT;
    L1108:
        return TRANSMIT_MESSAGE_SOURCE_INVALID;
    L1110:
        return MERGE_FORWARD_MESSAGE_SOURCE_INVALID;
    L1112:
        return TRANSMIT_MESSAGE_TYPE_IS_CRYPTO_INVALID;
    L1114:
        return TRANSMIT_MESSAGE_HAS_RECALL;
    L1116:
        return TRANSMIT_MESSAGE_IS_NO_VALID;
    L1118:
        return TRANSMIT_CHAT_IS_NO_VALID;
    L1120:
        return NO_PERMISSION_TRANSMIT_TO_THIRD_PARTY_ENCRYTE_CHAT;
    L1122:
        return PUT_TRANSMIT_MESSAGE_TYPE_INVALID;
    L1124:
        return PUT_MERGE_FORWARD_MESSAGE_TYPE_INVALID;
    L1126:
        return PUT_SHORTCUTS_FAILED;
    L1128:
        return DEEP_COPY_NO_VALID_MESSAGE;
    L1130:
        return DEEP_COPY_EXCEED_LIMIT;
    L1132:
        return COPY_MESSAGE_EXCEED_RESOURCE;
    L1134:
        return EDIT_MESSAGE_RECALLED;
    L1136:
        return EDIT_MESSAGE_OVER_TIMES;
    L1138:
        return EDIT_MESSAGE_NOT_IN_VALID_TIME;
    L1140:
        return THIRD_PARTY_ENCRYPT_CHAT_UNSUPPORTED_ADD_BOTS;
    L1142:
        return THIRD_PARTY_ENCRYPT_CHAT_UNSUPPORTED_CROSS;
    L1144:
        return NO_DEVICE_WHEN_CREATE_P2P_CHAT;
    L1146:
        return NO_DEVICE_FOR_CRYPTO_MESSAGE_CONTENT;
    L1148:
        return DOUBAO_CHAT_NOT_SUPPORTED;
    L1150:
        return HOTSPOT_CHAT_LIMITED_FOR_REPORT;
    L1152:
        return HOTSPOT_CHAT_LIMITED;
    L1154:
        return FORBIDDEN_EXIT_DEPARTMENT_CHAT;
    L1156:
        return FORBID_SET_AVATAR;
    L1158:
        return URGENT_PEOPLE_LIMIT;
    L1160:
        return FORBID_PUT_URGENT;
    L1162:
        return FORBID_PUT_P2P_CHATS;
    L1164:
        return FORBID_PUT_P2P_CHAT;
    L1166:
        return FORBID_DISABLE_SHARED_CHAT;
    L1168:
        return JOIN_TOKEN_NOT_SET;
    L1170:
        return FORBID_WITHDRAW_GROUP_OWNER;
    L1172:
        return DELETE_THREAD_PERMISSION_EXPIRED;
    L1174:
        return WITH_DRAW_PERMISSION_EXPIRED;
    L1176:
        return PULL_MESSAGE_FAIL_FOR_NOT_IN_CHAT;
    L1178:
        return PARTIAL_URGENT_USERS_ARE_MANAGERS;
    L1180:
        return ALL_URGENT_USERS_ARE_MANAGERS;
    L1182:
        return FORBID_SEND_MESSAGE_IN_CHAT;
    L1184:
        return FORBID_PULL_THREAD_MESSAGE_FOR_NOT_IN_CHAT;
    L1186:
        return FORBID_PULL_CHAT_THREAD_FOR_NOT_IN_CHAT;
    L1188:
        return FORBID_CREATE_CRYPTO_CHAT_OR_ADD_CHATTER;
    L1190:
        return TRANSFER_CHAT_OWNER_FAIL;
    L1192:
        return FORBID_ADD_OUT_TENANT_USER_V2;
    L1194:
        return RESET_CONTACT_TOKEN_TOO_FAST;
    L1196:
        return INVALID_CONTACT_TOKEN;
    L1198:
        return GET_CHAT_CHATTERS_FAIL;
    L1200:
        return FORBID_LARK_ASSISTANT_QUIT_CUSTOM_CHAT;
    L1202:
        return FORBID_QUIT_YOUR_CUSTOM_CHAT;
    L1204:
        return FORBID_CREATE_CHAT_FOR_USER_RESIGNED;
    L1206:
        return OPERATION_TOO_FREQUENTLY;
    L1208:
        return NO_FILE_SHARE_PERM;
    L1210:
        return SHARE_CARD_ADD_NON_CERTIFIED_TENANT_REFUSE;
    L1212:
        return QR_CODE_ADD_NON_CERTIFIED_TENANT_REFUSE;
    L1214:
        return LINK_ADD_NON_CERTIFIED_TENANT_REFUSE;
    L1216:
        return NO_RIGHT_CANDIDATE_OWNER;
    L1218:
        return SAFETY_CHECK_FORBIDDEN_DOWNLOAD;
    L1220:
        return OWNER_CLOSE_GROUP_CHAT_SHARED;
    L1222:
        return INVITEE_MOBILE_MARKED_MALICIOUS;
    L1224:
        return TENANT_DATA_TRANSFER_ON_MARCHING;
    L1226:
        return FORBID_SET_NAME;
    L1228:
        return CHAT_NOT_FOUND;
    L1230:
        return GROUP_CHAT_DISSOLVED;
    L1232:
        return FORBID_ADD_OUT_TENANT_USER;
    L1234:
        return WITHDRAW_MESSAGE_EXPIRED;
    L1236:
        return SHARE_CHAT_FORBID;
    L1238:
        return ONLY_OWNER_CAN_INVITE_OTHERS;
    L1240:
        return CHAT_USER_COUNT_GT_LIMIT;
    L1242:
        return ALREADY_IN_CHAT;
    L1244:
        return GROUP_CHAT_SHARED_CARD_EXPIRED;
    L1246:
        return NOT_IN_SAME_TENANT;
    L1248:
        return FORBID_SEND_MESSAGE_FOR_CHAT_DELETED_OR_ARCHIVED;
    L1250:
        return FORBID_PULL_MESSAGES_FOR_NOT_IN_CHAT;
    L1252:
        return FORBID_PULL_CHAT_MEMBERS_FOR_NOT_IN_CHAT;
    L1254:
        return FORBID_MODIFY_CHAT_NAME_FOR_NOT_IN_CHAT;
    L1256:
        return FORBID_MODIFY_ARCHIVED_CHAT_NAME;
    L1258:
        return ONLY_GROUP_CHAT_ALLOW_MODIFY_NAME;
    L1260:
        return FORBID_DEL_MEMBER_FOR_NOT_IN_CHAT;
    L1262:
        return FORBID_ADD_MEMBER_TO_P2P_CHAT;
    L1264:
        return FORBID_ADD_MEMBER_FOR_NOT_IN_CHAT;
    L1266:
        return NO_PERMISSION;
    L1268:
        return CREATE_MESSAGE_REQUEST_IS_PROCESSING;
    L1270:
        return MAIL_FORBID_MODIFY_MAIL_TITLE;
    L1272:
        return MAIL_NOT_IN_MAIL_GROUP;
    L1274:
        return ACCOUNT_LOGOUT_ERROR;
    L1276:
        return ACCOUNT_FORBIDDEN;
    L1278:
        return STOPPED_FEATURE_NEED_UPGRADE;
    L1280:
        return STOPPED_FEATURE_DEPRECATED;
    L1282:
        return CREATE_MESSAGE_INVALID_CARD_CONTENT;
    L1284:
        return UNKNOWN_CODE;
    }

    public final int getValue() {
        return this.value;
    }

    public static ErrorCode valueOf(String r1) {
        return (ErrorCode) a.a(ErrorCode.class, r1);
    }

    private ErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
