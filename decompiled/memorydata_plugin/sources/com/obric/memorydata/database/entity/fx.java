package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.GenderEnum;
import com.obric.capabilitykit.entity.meta.MetaAddress;
import com.obric.capabilitykit.entity.meta.MetaAnniversary;
import com.obric.capabilitykit.entity.meta.MetaCredentialNumber;
import com.obric.capabilitykit.entity.meta.MetaEmailAddress;
import com.obric.capabilitykit.entity.meta.MetaInstantMessaging;
import com.obric.capabilitykit.entity.meta.MetaRelationship;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.memorydata.database.dao.CallHistoryRawDbDao;
import com.obric.memorydata.database.dao.ContactHistoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\bV\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bç\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b'\u0010(J\b\u0010_\u001a\u00020`H\u0014J\u0018\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020\u0005H\u0016J\u0012\u0010e\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020\u0005H\u0016J\n\u0010f\u001a\u0004\u0018\u00010gH\u0016J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0005HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\tHÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\tHÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0090\u0003\u0010\u008a\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0017\u0010\u008b\u0001\u001a\u00030\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001HÖ\u0003J\n\u0010\u008f\u0001\u001a\u00020\tHÖ\u0001J\n\u0010\u0090\u0001\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010.\"\u0004\b8\u00109R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010.R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010.\"\u0004\b=\u00109R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010.R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010.R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010.R \u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010.\"\u0004\bC\u00109R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010.R \u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010.\"\u0004\bF\u00109R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bG\u0010.R \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010.\"\u0004\bI\u00109R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010.R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010.R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bL\u0010.R \u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010.\"\u0004\bN\u00109R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u0010.R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bP\u0010.R \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010.\"\u0004\bR\u00109R \u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010.\"\u0004\bT\u00109R \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010.\"\u0004\bV\u00109R \u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010.\"\u0004\bX\u00109R \u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010.\"\u0004\bZ\u00109R\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010.\"\u0004\b\\\u00109R\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010.\"\u0004\b^\u00109¨\u0006\u0091\u0001"}, d2 = {"Lcom/obric/memorydata/database/entity/RawContactEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, ActivityLifecycle.NAME, "telephones", "telephonesValues", "avatar", "note", "gender", "credentialNumbers", "credentialValues", "emails", "emailsValues", "addresses", "addressesValues", "company", "instantMessagings", "anniversaries", "anniversariesValues", "voip", "relationShips", "relationShipsValues", "fullContent", "department", "jobTitle", "subNote", "website", "telephoneStandardMap", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getName", "getTelephones", "getTelephonesValues", "setTelephonesValues", "getAvatar", "getNote", "getGender", "getCredentialNumbers", "getCredentialValues", "setCredentialValues", "getEmails", "getEmailsValues", "setEmailsValues", "getAddresses", "getAddressesValues", "setAddressesValues", "getCompany", "getInstantMessagings", "getAnniversaries", "getAnniversariesValues", "setAnniversariesValues", "getVoip", "getRelationShips", "getRelationShipsValues", "setRelationShipsValues", "getFullContent", "setFullContent", "getDepartment", "setDepartment", "getJobTitle", "setJobTitle", "getSubNote", "setSubNote", "getWebsite", "setWebsite", "getTelephoneStandardMap", "setTelephoneStandardMap", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class fx extends com.obric.memorydata.database.entity.d {
    private final String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9139b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private String i;
    private final String j;
    private final String k;
    private String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private String q;
    private final String r;
    private String s;
    private final String t;
    private String u;
    private final String v;
    private final String w;
    private final String x;
    private String y;
    private final String z;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends MetaTelephone>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends MetaCredentialNumber>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends MetaEmailAddress>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends TypeToken<List<? extends MetaAddress>> {
        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends TypeToken<List<? extends MetaInstantMessaging>> {
        public e() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends TypeToken<List<? extends MetaAnniversary>> {
        public f() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g extends TypeToken<List<? extends MetaRelationship>> {
        public g() {
        }
    }

    public fx(long r23, String r25, long r26, long r28, int r30, long r31, String r33, int r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60) {
        Intrinsics.checkNotNullParameter(r25, "entityId");
        Intrinsics.checkNotNullParameter(r33, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r36, ActivityLifecycle.NAME);
        super(r23, r25, r26, r28, r30, r31, r33, r34, r35, null, null, null, 3584, null);
        this.f9138a = r23;
        this.f9139b = r25;
        this.c = r26;
        this.d = r28;
        this.e = r30;
        this.f = r31;
        this.g = r33;
        this.h = r34;
        this.i = r35;
        this.j = r36;
        this.k = r37;
        this.l = r38;
        this.m = r39;
        this.n = r40;
        this.o = r41;
        this.p = r42;
        this.q = r43;
        this.r = r44;
        this.s = r45;
        this.t = r46;
        this.u = r47;
        this.v = r48;
        this.w = r49;
        this.x = r50;
        this.y = r51;
        this.z = r52;
        this.A = r53;
        this.B = r54;
        this.C = r55;
        this.D = r56;
        this.E = r57;
        this.F = r58;
        this.G = r59;
        this.H = r60;
    }

    public /* synthetic */ fx(long r43, String r45, long r46, long r48, int r50, long r51, String r53, int r54, String r55, String r56, String r57, String r58, String r59, String r60, String r61, String r62, String r63, String r64, String r65, String r66, String r67, String r68, String r69, String r70, String r71, String r72, String r73, String r74, String r75, String r76, String r77, String r78, String r79, String r80, int r81, int r82, DefaultConstructorMarker r83) {
        if ((r81 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r81 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r81 & 256) == 0) goto L13;
        String r16 = UUID.randomUUID().toString();
    L15:
        if ((r81 & 2048) == 0) goto L17;
        String r19 = "";
    L19:
        if ((65536 & r81) == 0) goto L21;
        String r24 = "";
    L23:
        if ((262144 & r81) == 0) goto L25;
        String r26 = "";
    L27:
        if ((1048576 & r81) == 0) goto L29;
        String r28 = "";
    L31:
        if ((16777216 & r81) == 0) goto L33;
        String r32 = "";
    L35:
        if ((134217728 & r81) == 0) goto L37;
        String r35 = "";
    L39:
        if ((268435456 & r81) == 0) goto L41;
        String r36 = "";
    L43:
        if ((536870912 & r81) == 0) goto L45;
        String r37 = "";
    L47:
        if ((1073741824 & r81) == 0) goto L49;
        String r38 = "";
    L51:
        if ((r81 & Integer.MIN_VALUE) == 0) goto L53;
        String r39 = "";
    L55:
        if ((r82 & 1) == 0) goto L57;
        String r40 = "";
    L59:
        if ((r82 & 2) == 0) goto L61;
        String r41 = null;
    L62:
        this(r4, r45, r46, r48, r50, r12, r53, r54, r16, r56, r57, r19, r59, r60, r61, r62, r24, r64, r26, r66, r28, r68, r69, r70, r32, r72, r73, r35, r36, r37, r38, r39, r40, r41);
        return;
    L61:
        r41 = r80;
        goto L62
    L57:
        r40 = r79;
        goto L59
    L53:
        r39 = r78;
        goto L55
    L49:
        r38 = r77;
        goto L51
    L45:
        r37 = r76;
        goto L47
    L41:
        r36 = r75;
        goto L43
    L37:
        r35 = r74;
        goto L39
    L33:
        r32 = r71;
        goto L35
    L29:
        r28 = r67;
        goto L31
    L25:
        r26 = r65;
        goto L27
    L21:
        r24 = r63;
        goto L23
    L17:
        r19 = r58;
        goto L19
    L13:
        r16 = r55;
        goto L15
    L9:
        r12 = r51;
        goto L11
    L5:
        r4 = r43;
        goto L7
    }

    public final String a() {
        return this.j;
    }

    public final void a(String r1) {
        this.l = r1;
    }

    public final String b() {
        return this.k;
    }

    public final void b(String r1) {
        this.q = r1;
    }

    public final String c() {
        return this.l;
    }

    public final void c(String r1) {
        this.s = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        String r0 = this.k;
        List<MetaRelationship> r2 = null;
        if (r0 != null) goto L125;
    L11:
        List r1 = null;
    L12:
        Map<String, com.obric.memorydata.utils.au> r4 = com.obric.memorydata.utils.t.f13260a.b(this.H);
        if (r1 == null) goto L19;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        MetaTelephone r9 = (MetaTelephone) ZeusTransformUtils.preCheckCast(r8.next(), MetaTelephone.class, "com.obric.memorydata.plugin");
        r7.add(MetaTelephone.copy$default(r9, com.obric.memorydata.utils.t.f13260a.a(r9.getTelephone(), r9.getContactType(), r4), null, 2, null));
        goto L16
    L18:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L20:
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L23;
    L26:
        boolean r12 = true;
    L27:
        if (r12 == true) goto L49;
        CallHistoryRawDbDao r13 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao();
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r3.iterator();
    L30:
        if (r15.hasNext() == false) goto L32;
        r5.add(((MetaTelephone) ZeusTransformUtils.preCheckCast(r15.next(), MetaTelephone.class, "com.obric.memorydata.plugin")).getTelephone());
        goto L30
    L32:
        Pair<String, Long> r16 = r13.getLastCallTimeStampByPhoneNumbers((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), getPackageName());
        if (r16 == null) goto L49;
        if ((System.currentTimeMillis() - ((Number) ZeusTransformUtils.preCheckCast(r16.getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue()) > 2592000000L) goto L49;
        if (r14 == null) goto L45;
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L39:
        if (r17.hasNext() == false) goto L43;
        Object r18 = r17.next();
        MetaTelephone r19 = (MetaTelephone) ZeusTransformUtils.preCheckCast(r18, MetaTelephone.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(com.obric.memorydata.utils.t.f13260a.a((String) ZeusTransformUtils.preCheckCast(r16.getFirst(), String.class, "com.obric.memorydata.plugin"), r19.getContactType(), r4), r19.getTelephone()) == false) goto L39;
    L44:
        T r20 = (MetaTelephone) ZeusTransformUtils.preCheckCast(r18, MetaTelephone.class, "com.obric.memorydata.plugin");
    L46:
        r10.element = r20;
        if (r10.element == 0) goto L49;
        Long r21 = r16.getSecond();
    L50:
        ContactEntity r22 = new ContactEntity(getEntityId(), getCreateTime(), getModifyTime(), this.j, r14);
        r22.set_packageName(getPackageName());
        r22.setUuid(getUuid());
        String r23 = this.m;
        if (r23 != null) goto L53;
        FileEntity r24 = null;
    L54:
        r22.setAvatar(r24);
        r22.setNote(this.n);
        r22.setGender(GenderEnum.Companion.from(this.o));
        String r25 = this.p;
        if (r25 != null) goto L127;
    L63:
        List<MetaCredentialNumber> r26 = null;
    L64:
        r22.setCredentialNumbers(r26);
        String r27 = this.r;
        if (r27 != null) goto L115;
    L73:
        List<MetaEmailAddress> r28 = null;
    L74:
        r22.setEmails(r28);
        String r29 = this.t;
        if (r29 != null) goto L119;
    L83:
        List<MetaAddress> r30 = null;
    L84:
        r22.setAddresses(r30);
        r22.setCompany(this.v);
        String r31 = this.w;
        if (r31 != null) goto L117;
    L93:
        List<MetaInstantMessaging> r32 = null;
    L94:
        r22.setInstantMessagings(r32);
        String r33 = this.x;
        if (r33 != null) goto L121;
    L103:
        List<MetaAnniversary> r34 = null;
    L104:
        r22.setAnniversaries(r34);
        r22.setVoip(this.z);
        String r110 = this.A;
        if (r110 != null) goto L123;
    L113:
        r22.setRelationShips(r2);
        r22.setLastUsedTelephoneTimeStamp((Long) ZeusTransformUtils.preCheckCast(r21, Long.class, "com.obric.memorydata.plugin"));
        r22.setLastUsedTelephone((MetaTelephone) ZeusTransformUtils.preCheckCast(r10.element, MetaTelephone.class, "com.obric.memorydata.plugin"));
        return (AppEntity) ZeusTransformUtils.preCheckCast(r22, AppEntity.class, "com.obric.memorydata.plugin");
    L123:
        r2 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r110, new g().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L108 JsonSyntaxException -> L110
        goto L113
    L110:
        e = e;
        IRunLog r35 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r36 = new StringBuilder();
    L112:
        IRunLog.a.b(r35, "GsonExt", r36.append("toListObj error : ").append(e).toString(), null, 4, null);
    L108:
        e = e;
        r35 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r36 = new StringBuilder();
        goto L112
    L121:
        r34 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r33, new f().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L98 JsonSyntaxException -> L100
    L100:
        e = e;
        IRunLog r37 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r38 = new StringBuilder();
    L102:
        IRunLog.a.b(r37, "GsonExt", r38.append("toListObj error : ").append(e).toString(), null, 4, null);
    L98:
        e = e;
        r37 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r38 = new StringBuilder();
        goto L102
    L117:
        r32 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r31, new e().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L88 JsonSyntaxException -> L90
    L90:
        e = e;
        IRunLog r39 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r40 = new StringBuilder();
    L92:
        IRunLog.a.b(r39, "GsonExt", r40.append("toListObj error : ").append(e).toString(), null, 4, null);
    L88:
        e = e;
        r39 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r40 = new StringBuilder();
        goto L92
    L119:
        r30 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r29, new d().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L78 JsonSyntaxException -> L80
    L80:
        e = e;
        IRunLog r41 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r42 = new StringBuilder();
    L82:
        IRunLog.a.b(r41, "GsonExt", r42.append("toListObj error : ").append(e).toString(), null, 4, null);
    L78:
        e = e;
        r41 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r42 = new StringBuilder();
        goto L82
    L115:
        r28 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r27, new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L68 JsonSyntaxException -> L70
    L70:
        e = e;
        IRunLog r43 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r44 = new StringBuilder();
    L72:
        IRunLog.a.b(r43, "GsonExt", r44.append("toListObj error : ").append(e).toString(), null, 4, null);
    L68:
        e = e;
        r43 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r44 = new StringBuilder();
        goto L72
    L127:
        r26 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r25, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L58 JsonSyntaxException -> L60
    L60:
        e = e;
        IRunLog r45 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r46 = new StringBuilder();
    L62:
        IRunLog.a.b(r45, "GsonExt", r46.append("toListObj error : ").append(e).toString(), null, 4, null);
    L58:
        e = e;
        r45 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r46 = new StringBuilder();
        goto L62
    L53:
        r24 = com.obric.memorydata.personalcontext.util.f.c(r23);
        goto L54
    L43:
        r18 = null;
        goto L44
    L45:
        r20 = 0;
    L49:
        r21 = null;
        goto L50
    L23:
        if (r11.isEmpty() == true) goto L26;
        r12 = false;
        goto L27
    L19:
        r14 = null;
        goto L20
    L125:
        r1 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r0, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L6 JsonSyntaxException -> L8
    L8:
        e = e;
        IRunLog r47 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r48 = new StringBuilder();
    L10:
        IRunLog.a.b(r47, "GsonExt", r48.append("toListObj error : ").append(e).toString(), null, 4, null);
    L6:
        e = e;
        r47 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r48 = new StringBuilder();
        goto L10
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "column");
        return (i) ZeusTransformUtils.preCheckCast(new ar(0, getId(), r10, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public com.obric.memorydata.database.entity.c convertToRawHistoryEntity() {
        return (com.obric.memorydata.database.entity.c) ZeusTransformUtils.preCheckCast(new ContactHistoryEntity(0, this, 1, null), com.obric.memorydata.database.entity.c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new as(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final String d() {
        return this.m;
    }

    public final void d(String r1) {
        this.u = r1;
    }

    public final String e() {
        return this.n;
    }

    public final void e(String r1) {
        this.y = r1;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, fx.class) == true) goto L8;
        return false;
    L8:
        fx r10 = (fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin");
        if (this.f9138a == r10.f9138a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9139b, r10.f9139b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r10.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r10.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r10.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r10.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r10.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r10.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r10.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r10.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r10.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r10.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r10.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r10.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r10.B) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r10.C) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.D, r10.D) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.E, r10.E) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.F, r10.F) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.G, r10.G) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r10.H) == true) goto L110;
        return false;
    L110:
        return true;
    }

    public final String f() {
        return this.o;
    }

    public final void f(String r1) {
        this.B = r1;
    }

    public final String g() {
        return this.p;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9139b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9138a;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.i;
    }

    public final String h() {
        return this.q;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9138a) * 31) + this.f9139b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
        String r1 = this.i;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.j.hashCode()) * 31;
        String r5 = this.k;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.l;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.m;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.n;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.o;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.p;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.q;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.r;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.s;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.t;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        String r35 = this.u;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        String r38 = this.v;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        String r41 = this.w;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        String r44 = this.x;
        if (r44 != null) goto L61;
        int r45 = 0;
    L62:
        int r46 = (r43 + r45) * 31;
        String r47 = this.y;
        if (r47 != null) goto L65;
        int r48 = 0;
    L66:
        int r49 = (r46 + r48) * 31;
        String r50 = this.z;
        if (r50 != null) goto L69;
        int r51 = 0;
    L70:
        int r52 = (r49 + r51) * 31;
        String r53 = this.A;
        if (r53 != null) goto L73;
        int r54 = 0;
    L74:
        int r55 = (r52 + r54) * 31;
        String r56 = this.B;
        if (r56 != null) goto L77;
        int r57 = 0;
    L78:
        int r58 = (r55 + r57) * 31;
        String r59 = this.C;
        if (r59 != null) goto L81;
        int r60 = 0;
    L82:
        int r61 = (r58 + r60) * 31;
        String r62 = this.D;
        if (r62 != null) goto L85;
        int r63 = 0;
    L86:
        int r64 = (r61 + r63) * 31;
        String r65 = this.E;
        if (r65 != null) goto L89;
        int r66 = 0;
    L90:
        int r67 = (r64 + r66) * 31;
        String r68 = this.F;
        if (r68 != null) goto L93;
        int r69 = 0;
    L94:
        int r70 = (r67 + r69) * 31;
        String r71 = this.G;
        if (r71 != null) goto L97;
        int r72 = 0;
    L98:
        int r73 = (r70 + r72) * 31;
        String r74 = this.H;
        if (r74 == null) goto L103;
        r2 = r74.hashCode();
    L103:
        return r73 + r2;
    L97:
        r72 = r71.hashCode();
        goto L98
    L93:
        r69 = r68.hashCode();
        goto L94
    L89:
        r66 = r65.hashCode();
        goto L90
    L85:
        r63 = r62.hashCode();
        goto L86
    L81:
        r60 = r59.hashCode();
        goto L82
    L77:
        r57 = r56.hashCode();
        goto L78
    L73:
        r54 = r53.hashCode();
        goto L74
    L69:
        r51 = r50.hashCode();
        goto L70
    L65:
        r48 = r47.hashCode();
        goto L66
    L61:
        r45 = r44.hashCode();
        goto L62
    L57:
        r42 = r41.hashCode();
        goto L58
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String i() {
        return this.r;
    }

    public final String j() {
        return this.s;
    }

    public final String k() {
        return this.t;
    }

    public final String l() {
        return this.u;
    }

    public final String m() {
        return this.v;
    }

    public final String n() {
        return this.w;
    }

    public final String o() {
        return this.x;
    }

    public final String p() {
        return this.y;
    }

    public final String q() {
        return this.z;
    }

    public final String r() {
        return this.A;
    }

    public final String s() {
        return this.B;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9138a = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.i = r1;
    }

    public final String t() {
        return this.C;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawContactEntity(id=").append(this.f9138a).append(", entityId=").append(this.f9139b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", uuid=").append(this.i).append(", name=").append(this.j).append(", telephones=").append(this.k).append(", telephonesValues=");
        r0.append(this.l).append(", avatar=").append(this.m).append(", note=").append(this.n).append(", gender=").append(this.o).append(", credentialNumbers=").append(this.p).append(", credentialValues=").append(this.q).append(", emails=").append(this.r).append(", emailsValues=").append(this.s).append(", addresses=").append(this.t).append(", addressesValues=").append(this.u).append(", company=").append(this.v).append(", instantMessagings=").append(this.w);
        r0.append(", anniversaries=").append(this.x).append(", anniversariesValues=").append(this.y).append(", voip=").append(this.z).append(", relationShips=").append(this.A).append(", relationShipsValues=").append(this.B).append(", fullContent=").append(this.C).append(", department=").append(this.D).append(", jobTitle=").append(this.E).append(", subNote=").append(this.F).append(", website=").append(this.G).append(", telephoneStandardMap=").append(this.H).append(')');
        return r0.toString();
    }

    public final String u() {
        return this.D;
    }

    public final String v() {
        return this.E;
    }

    public final String w() {
        return this.F;
    }

    public final String x() {
        return this.G;
    }

    public final String y() {
        return this.H;
    }
}
