package com.obric.memorydata.database.entity;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.backup.appentity.FakeMemoryAppEntity;
import com.obric.memorydata.database.index.ExtractTime;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\ba\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bý\u0003\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010/\u001a\u00020\t\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u00101\u001a\u000202¢\u0006\u0004\b3\u00104J\f\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0014J\u001c\u0010\u0095\u0001\u001a\u00030\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\u00052\u0007\u0010\u0098\u0001\u001a\u00020\u0005H\u0016J\u0015\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0007\u0010\u0097\u0001\u001a\u00020\u0005H\u0016J\u001d\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u0097\u0001\u001a\u00020\u00052\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016J\f\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J\n\u0010 \u0001\u001a\u00030¡\u0001H\u0016J\n\u0010¢\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\tHÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010©\u0001\u001a\u00020\tHÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010«\u0001\u001a\u00020\tHÆ\u0003J\n\u0010¬\u0001\u001a\u00020\tHÆ\u0003J\u0011\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010MJ\u0011\u0010®\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010MJ\u0011\u0010¯\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010MJ\u0011\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010MJ\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¹\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Â\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010È\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010É\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\tHÆ\u0003J\f\u0010Í\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010Î\u0001\u001a\u000202HÆ\u0003J\u0094\u0004\u0010Ï\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010/\u001a\u00020\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00101\u001a\u000202HÆ\u0001¢\u0006\u0003\u0010Ð\u0001J\u0016\u0010Ñ\u0001\u001a\u0002022\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001HÖ\u0003J\n\u0010Ô\u0001\u001a\u00020\tHÖ\u0001J\n\u0010Õ\u0001\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u0006\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u00106R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00106\"\u0004\bC\u00108R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010:R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010AR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010:\"\u0004\bG\u0010<R\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010A\"\u0004\bI\u0010JR\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bK\u0010AR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010P\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010P\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010P\u001a\u0004\bS\u0010M\"\u0004\bT\u0010OR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010P\u001a\u0004\bU\u0010M\"\u0004\bV\u0010OR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010:\"\u0004\bX\u0010<R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010:\"\u0004\bZ\u0010<R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010:\"\u0004\b\\\u0010<R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010:\"\u0004\b^\u0010<R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u0010:R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010:R \u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010:\"\u0004\bb\u0010<R \u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010:\"\u0004\bd\u0010<R \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010:\"\u0004\bf\u0010<R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010:\"\u0004\bh\u0010<R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010:\"\u0004\bj\u0010<R \u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010:\"\u0004\bl\u0010<R \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010:\"\u0004\bn\u0010<R \u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010:\"\u0004\bp\u0010<R \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010:\"\u0004\br\u0010<R \u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010:\"\u0004\bt\u0010<R \u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010:\"\u0004\bv\u0010<R \u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010:\"\u0004\bx\u0010<R \u0010&\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010:\"\u0004\bz\u0010<R \u0010'\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010:\"\u0004\b|\u0010<R \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010:\"\u0004\b~\u0010<R\u001d\u0010)\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010:\"\u0005\b\u0080\u0001\u0010<R\u001e\u0010*\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010:\"\u0005\b\u0082\u0001\u0010<R\u001e\u0010+\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010:\"\u0005\b\u0084\u0001\u0010<R\u001e\u0010,\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010:\"\u0005\b\u0086\u0001\u0010<R\u001e\u0010-\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010:\"\u0005\b\u0088\u0001\u0010<R\"\u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010:\"\u0005\b\u008a\u0001\u0010<R \u0010/\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010A\"\u0005\b\u008c\u0001\u0010JR\u001e\u00100\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010:\"\u0005\b\u008e\u0001\u0010<R\"\u00101\u001a\u0002028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001¨\u0006Ö\u0001"}, d2 = {"Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "memoryType", "productType", "startDate", "startTime", "endDate", "endTime", "sourceLinkType", "sourceLink", "screenshot", "locations", "summary", "fullContent", "key1", "key2", "key3", "key4", "key5", "keyword1", "keyword2", "keyword3", "keyword4", "keyword5", "keyword6", "semantic1", "semantic2", "keywordAndSemantic1", "keywordAndSemantic2", "sourceText", "sourcePackageName", "sourceAppName", "logId", "sourceQuery", MemoryListActivity.JUMP_FROM_DETAIL, "detailStatus", "contentWithTime", "userEdit", "", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getCreateTime", "setCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "getMemoryType", "setMemoryType", "(I)V", "getProductType", "getStartDate", "()Ljava/lang/Long;", "setStartDate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getStartTime", "setStartTime", "getEndDate", "setEndDate", "getEndTime", "setEndTime", "getSourceLinkType", "setSourceLinkType", "getSourceLink", "setSourceLink", "getScreenshot", "setScreenshot", "getLocations", "setLocations", "getSummary", "getFullContent", "getKey1", "setKey1", "getKey2", "setKey2", "getKey3", "setKey3", "getKey4", "setKey4", "getKey5", "setKey5", "getKeyword1", "setKeyword1", "getKeyword2", "setKeyword2", "getKeyword3", "setKeyword3", "getKeyword4", "setKeyword4", "getKeyword5", "setKeyword5", "getKeyword6", "setKeyword6", "getSemantic1", "setSemantic1", "getSemantic2", "setSemantic2", "getKeywordAndSemantic1", "setKeywordAndSemantic1", "getKeywordAndSemantic2", "setKeywordAndSemantic2", "getSourceText", "setSourceText", "getSourcePackageName", "setSourcePackageName", "getSourceAppName", "setSourceAppName", "getLogId", "setLogId", "getSourceQuery", "setSourceQuery", "getDetail", "setDetail", "getDetailStatus", "setDetailStatus", "getContentWithTime", "setContentWithTime", "getUserEdit", "()Z", "setUserEdit", "(Z)V", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "convertToContentTimeEntity", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "extractTime", "Lcom/obric/memorydata/database/index/ExtractTime;", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/FakeMemoryAppEntity;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "copy", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RawMemoryEntity extends d {
    private String contentWithTime;
    private long createTime;
    private String detail;
    private int detailStatus;
    private Long endDate;
    private Long endTime;
    private String entityId;
    private final String fullContent;
    private final int hashCodeValue;
    private long id;
    private String key1;
    private String key2;
    private String key3;
    private String key4;
    private String key5;
    private String keyword1;
    private String keyword2;
    private String keyword3;
    private String keyword4;
    private String keyword5;
    private String keyword6;
    private String keywordAndSemantic1;
    private String keywordAndSemantic2;
    private String locations;
    private String logId;
    private int memoryType;
    private final long modifyTime;
    private final String packageName;
    private final int productType;
    private String screenshot;
    private String semantic1;
    private String semantic2;
    private String sourceAppName;
    private String sourceLink;
    private String sourceLinkType;
    private String sourcePackageName;
    private String sourceQuery;
    private String sourceText;
    private Long startDate;
    private Long startTime;
    private final String summary;
    private long timestamp;
    private final int type;
    private boolean userEdit;
    private String uuid;

    public RawMemoryEntity(long r21, String r23, long r24, long r26, int r28, long r29, String r31, int r32, String r33, int r34, int r35, Long r36, Long r37, Long r38, Long r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60, String r61, String r62, String r63, String r64, String r65, String r66, int r67, String r68, boolean r69) {
        Intrinsics.checkNotNullParameter(r23, "entityId");
        Intrinsics.checkNotNullParameter(r31, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Integer r0 = null;
        super(r21, r23, r24, r26, r28, r29, r31, r32, r33, r0, r0, null, 3584, null);
        this.id = r21;
        this.entityId = r23;
        this.createTime = r24;
        this.modifyTime = r26;
        this.type = r28;
        this.timestamp = r29;
        this.packageName = r31;
        this.hashCodeValue = r32;
        this.uuid = r33;
        this.memoryType = r34;
        this.productType = r35;
        this.startDate = r36;
        this.startTime = r37;
        this.endDate = r38;
        this.endTime = r39;
        this.sourceLinkType = r40;
        this.sourceLink = r41;
        this.screenshot = r42;
        this.locations = r43;
        this.summary = r44;
        this.fullContent = r45;
        this.key1 = r46;
        this.key2 = r47;
        this.key3 = r48;
        this.key4 = r49;
        this.key5 = r50;
        this.keyword1 = r51;
        this.keyword2 = r52;
        this.keyword3 = r53;
        this.keyword4 = r54;
        this.keyword5 = r55;
        this.keyword6 = r56;
        this.semantic1 = r57;
        this.semantic2 = r58;
        this.keywordAndSemantic1 = r59;
        this.keywordAndSemantic2 = r60;
        this.sourceText = r61;
        this.sourcePackageName = r62;
        this.sourceAppName = r63;
        this.logId = r64;
        this.sourceQuery = r65;
        this.detail = r66;
        this.detailStatus = r67;
        this.contentWithTime = r68;
        this.userEdit = r69;
    }

    public /* synthetic */ RawMemoryEntity(long r55, String r57, long r58, long r60, int r62, long r63, String r65, int r66, String r67, int r68, int r69, Long r70, Long r71, Long r72, Long r73, String r74, String r75, String r76, String r77, String r78, String r79, String r80, String r81, String r82, String r83, String r84, String r85, String r86, String r87, String r88, String r89, String r90, String r91, String r92, String r93, String r94, String r95, String r96, String r97, String r98, String r99, String r100, int r101, String r102, boolean r103, int r104, int r105, DefaultConstructorMarker r106) {
        if ((r104 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r104 & 16) == 0) goto L9;
        int r12 = -303;
    L11:
        if ((r104 & 32) == 0) goto L13;
        long r13 = System.currentTimeMillis();
    L15:
        if ((r104 & 128) == 0) goto L17;
        int r16 = 0;
    L19:
        if ((r104 & 256) == 0) goto L21;
        String r17 = UUID.randomUUID().toString();
    L23:
        if ((r104 & 2048) == 0) goto L25;
        Long r20 = null;
    L27:
        if ((r104 & 4096) == 0) goto L29;
        Long r21 = null;
    L31:
        if ((r104 & 8192) == 0) goto L33;
        Long r22 = null;
    L35:
        if ((r104 & 16384) == 0) goto L37;
        Long r23 = null;
    L39:
        if ((32768 & r104) == 0) goto L41;
        String r24 = null;
    L43:
        if ((65536 & r104) == 0) goto L45;
        String r25 = null;
    L47:
        if ((131072 & r104) == 0) goto L49;
        String r26 = null;
    L51:
        if ((262144 & r104) == 0) goto L53;
        String r27 = null;
    L55:
        if ((524288 & r104) == 0) goto L57;
        String r28 = null;
    L59:
        if ((1048576 & r104) == 0) goto L61;
        String r29 = null;
    L63:
        if ((2097152 & r104) == 0) goto L65;
        String r30 = null;
    L67:
        if ((4194304 & r104) == 0) goto L69;
        String r31 = null;
    L71:
        if ((8388608 & r104) == 0) goto L73;
        String r32 = null;
    L75:
        if ((16777216 & r104) == 0) goto L77;
        String r33 = null;
    L79:
        if ((33554432 & r104) == 0) goto L81;
        String r34 = null;
    L83:
        if ((67108864 & r104) == 0) goto L85;
        String r35 = null;
    L87:
        if ((134217728 & r104) == 0) goto L89;
        String r36 = null;
    L91:
        if ((268435456 & r104) == 0) goto L93;
        String r37 = null;
    L95:
        if ((536870912 & r104) == 0) goto L97;
        String r38 = null;
    L99:
        if ((1073741824 & r104) == 0) goto L101;
        String r39 = null;
    L103:
        if ((r104 & Integer.MIN_VALUE) == 0) goto L105;
        String r40 = null;
    L107:
        if ((r105 & 1) == 0) goto L109;
        String r41 = null;
    L111:
        if ((r105 & 2) == 0) goto L113;
        String r42 = null;
    L115:
        if ((r105 & 4) == 0) goto L117;
        String r43 = null;
    L119:
        if ((r105 & 8) == 0) goto L121;
        String r44 = null;
    L123:
        if ((r105 & 16) == 0) goto L125;
        String r45 = null;
    L127:
        if ((r105 & 32) == 0) goto L129;
        String r46 = null;
    L131:
        if ((r105 & 64) == 0) goto L133;
        String r47 = null;
    L135:
        if ((r105 & 128) == 0) goto L137;
        String r48 = null;
    L139:
        if ((r105 & 256) == 0) goto L141;
        String r49 = null;
    L143:
        if ((r105 & 512) == 0) goto L145;
        String r50 = null;
    L147:
        if ((r105 & 2048) == 0) goto L149;
        String r52 = null;
    L151:
        if ((r105 & 4096) == 0) goto L153;
        boolean r53 = false;
    L154:
        this(r5, r57, r58, r60, r12, r13, r65, r16, r17, r68, r69, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r101, r52, r53);
        return;
    L153:
        r53 = r103;
        goto L154
    L149:
        r52 = r102;
        goto L151
    L145:
        r50 = r100;
        goto L147
    L141:
        r49 = r99;
        goto L143
    L137:
        r48 = r98;
        goto L139
    L133:
        r47 = r97;
        goto L135
    L129:
        r46 = r96;
        goto L131
    L125:
        r45 = r95;
        goto L127
    L121:
        r44 = r94;
        goto L123
    L117:
        r43 = r93;
        goto L119
    L113:
        r42 = r92;
        goto L115
    L109:
        r41 = r91;
        goto L111
    L105:
        r40 = r90;
        goto L107
    L101:
        r39 = r89;
        goto L103
    L97:
        r38 = r88;
        goto L99
    L93:
        r37 = r87;
        goto L95
    L89:
        r36 = r86;
        goto L91
    L85:
        r35 = r85;
        goto L87
    L81:
        r34 = r84;
        goto L83
    L77:
        r33 = r83;
        goto L79
    L73:
        r32 = r82;
        goto L75
    L69:
        r31 = r81;
        goto L71
    L65:
        r30 = r80;
        goto L67
    L61:
        r29 = r79;
        goto L63
    L57:
        r28 = r78;
        goto L59
    L53:
        r27 = r77;
        goto L55
    L49:
        r26 = r76;
        goto L51
    L45:
        r25 = r75;
        goto L47
    L41:
        r24 = r74;
        goto L43
    L37:
        r23 = r73;
        goto L39
    L33:
        r22 = r72;
        goto L35
    L29:
        r21 = r71;
        goto L31
    L25:
        r20 = r70;
        goto L27
    L21:
        r17 = r67;
        goto L23
    L17:
        r16 = r66;
        goto L19
    L13:
        r13 = r63;
        goto L15
    L9:
        r12 = r62;
        goto L11
    L5:
        r5 = r55;
        goto L7
    }

    public static /* synthetic */ RawMemoryEntity copy$default(RawMemoryEntity r17, long r18, String r20, long r21, long r23, int r25, long r26, String r28, int r29, String r30, int r31, int r32, Long r33, Long r34, Long r35, Long r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60, String r61, String r62, String r63, int r64, String r65, boolean r66, int r67, int r68, Object r69) {
        if ((r67 & 1) == 0) goto L5;
        long r3 = r17.id;
    L7:
        if ((r67 & 2) == 0) goto L9;
        String r5 = r17.entityId;
    L11:
        if ((r67 & 4) == 0) goto L13;
        long r6 = r17.createTime;
    L15:
        if ((r67 & 8) == 0) goto L17;
        long r8 = r17.modifyTime;
    L19:
        if ((r67 & 16) == 0) goto L21;
        int r10 = r17.type;
    L23:
        if ((r67 & 32) == 0) goto L25;
        long r11 = r17.timestamp;
    L27:
        if ((r67 & 64) == 0) goto L29;
        String r13 = r17.packageName;
    L31:
        if ((r67 & 128) == 0) goto L33;
        int r14 = r17.hashCodeValue;
    L35:
        if ((r67 & 256) == 0) goto L37;
        String r15 = r17.uuid;
    L38:
        String r310 = r15;
        if ((r67 & 512) == 0) goto L41;
        int r16 = r17.memoryType;
    L42:
        int r311 = r16;
        if ((r67 & 1024) == 0) goto L45;
        int r19 = r17.productType;
    L46:
        int r312 = r19;
        if ((r67 & 2048) == 0) goto L49;
        Long r110 = r17.startDate;
    L50:
        Long r313 = r110;
        if ((r67 & 4096) == 0) goto L53;
        Long r111 = r17.startTime;
    L54:
        Long r314 = r111;
        if ((r67 & 8192) == 0) goto L57;
        Long r112 = r17.endDate;
    L58:
        Long r315 = r112;
        if ((r67 & 16384) == 0) goto L61;
        Long r113 = r17.endTime;
    L62:
        Long r316 = r113;
        if ((r67 & 32768) == 0) goto L65;
        String r114 = r17.sourceLinkType;
    L66:
        String r317 = r114;
        if ((r67 & 65536) == 0) goto L69;
        String r115 = r17.sourceLink;
    L70:
        String r318 = r115;
        if ((r67 & 131072) == 0) goto L73;
        String r116 = r17.screenshot;
    L74:
        String r319 = r116;
        if ((r67 & 262144) == 0) goto L77;
        String r117 = r17.locations;
    L78:
        String r410 = r117;
        if ((r67 & 524288) == 0) goto L81;
        String r118 = r17.summary;
    L82:
        String r411 = r118;
        if ((r67 & 1048576) == 0) goto L85;
        String r119 = r17.fullContent;
    L86:
        String r412 = r119;
        if ((r67 & 2097152) == 0) goto L89;
        String r120 = r17.key1;
    L90:
        String r413 = r120;
        if ((r67 & 4194304) == 0) goto L93;
        String r121 = r17.key2;
    L94:
        String r414 = r121;
        if ((r67 & 8388608) == 0) goto L97;
        String r122 = r17.key3;
    L98:
        String r415 = r122;
        if ((r67 & 16777216) == 0) goto L101;
        String r123 = r17.key4;
    L102:
        String r416 = r123;
        if ((r67 & 33554432) == 0) goto L105;
        String r124 = r17.key5;
    L106:
        String r417 = r124;
        if ((r67 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L109;
        String r125 = r17.keyword1;
    L110:
        String r418 = r125;
        if ((r67 & 134217728) == 0) goto L113;
        String r126 = r17.keyword2;
    L114:
        String r419 = r126;
        if ((r67 & SQLiteDatabase.CREATE_IF_NECESSARY) == 0) goto L117;
        String r127 = r17.keyword3;
    L118:
        String r510 = r127;
        if ((r67 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == 0) goto L121;
        String r128 = r17.keyword4;
    L122:
        String r511 = r128;
        if ((r67 & 1073741824) == 0) goto L125;
        String r129 = r17.keyword5;
    L127:
        if ((r67 & Integer.MIN_VALUE) == 0) goto L129;
        String r1 = r17.keyword6;
    L130:
        String r512 = r1;
        if ((r68 & 1) == 0) goto L133;
        String r2 = r17.semantic1;
    L134:
        String r513 = r2;
        if ((r68 & 2) == 0) goto L137;
        String r4 = r17.semantic2;
    L138:
        String r514 = r4;
        if ((r68 & 4) == 0) goto L141;
        String r7 = r17.keywordAndSemantic1;
    L142:
        String r515 = r7;
        if ((r68 & 8) == 0) goto L145;
        String r9 = r17.keywordAndSemantic2;
    L146:
        String r516 = r9;
        if ((r68 & 16) == 0) goto L149;
        String r12 = r17.sourceText;
    L150:
        String r517 = r12;
        if ((r68 & 32) == 0) goto L153;
        String r22 = r17.sourcePackageName;
    L154:
        String r518 = r22;
        if ((r68 & 64) == 0) goto L157;
        String r24 = r17.sourceAppName;
    L158:
        String r610 = r24;
        if ((r68 & 128) == 0) goto L161;
        String r27 = r17.logId;
    L162:
        String r611 = r27;
        if ((r68 & 256) == 0) goto L165;
        String r70 = r17.sourceQuery;
    L166:
        String r612 = r70;
        if ((r68 & 512) == 0) goto L169;
        String r71 = r17.detail;
    L170:
        String r613 = r71;
        if ((r68 & 1024) == 0) goto L173;
        int r72 = r17.detailStatus;
    L174:
        int r614 = r72;
        if ((r68 & 2048) == 0) goto L177;
        String r73 = r17.contentWithTime;
    L179:
        if ((r68 & 4096) == 0) goto L181;
        boolean r74 = r17.userEdit;
    L183:
        return r17.copy(r3, r5, r6, r8, r10, r11, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r129, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r73, r74);
    L181:
        r74 = r66;
        goto L183
    L177:
        r73 = r65;
        goto L179
    L173:
        r72 = r64;
        goto L174
    L169:
        r71 = r63;
        goto L170
    L165:
        r70 = r62;
        goto L166
    L161:
        r27 = r61;
        goto L162
    L157:
        r24 = r60;
        goto L158
    L153:
        r22 = r59;
        goto L154
    L149:
        r12 = r58;
        goto L150
    L145:
        r9 = r57;
        goto L146
    L141:
        r7 = r56;
        goto L142
    L137:
        r4 = r55;
        goto L138
    L133:
        r2 = r54;
        goto L134
    L129:
        r1 = r53;
        goto L130
    L125:
        r129 = r52;
        goto L127
    L121:
        r128 = r51;
        goto L122
    L117:
        r127 = r50;
        goto L118
    L113:
        r126 = r49;
        goto L114
    L109:
        r125 = r48;
        goto L110
    L105:
        r124 = r47;
        goto L106
    L101:
        r123 = r46;
        goto L102
    L97:
        r122 = r45;
        goto L98
    L93:
        r121 = r44;
        goto L94
    L89:
        r120 = r43;
        goto L90
    L85:
        r119 = r42;
        goto L86
    L81:
        r118 = r41;
        goto L82
    L77:
        r117 = r40;
        goto L78
    L73:
        r116 = r39;
        goto L74
    L69:
        r115 = r38;
        goto L70
    L65:
        r114 = r37;
        goto L66
    L61:
        r113 = r36;
        goto L62
    L57:
        r112 = r35;
        goto L58
    L53:
        r111 = r34;
        goto L54
    L49:
        r110 = r33;
        goto L50
    L45:
        r19 = r32;
        goto L46
    L41:
        r16 = r31;
        goto L42
    L37:
        r15 = r30;
        goto L38
    L33:
        r14 = r29;
        goto L35
    L29:
        r13 = r28;
        goto L31
    L25:
        r11 = r26;
        goto L27
    L21:
        r10 = r25;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final int component10() {
        return this.memoryType;
    }

    public final int component11() {
        return this.productType;
    }

    public final Long component12() {
        return this.startDate;
    }

    public final Long component13() {
        return this.startTime;
    }

    public final Long component14() {
        return this.endDate;
    }

    public final Long component15() {
        return this.endTime;
    }

    public final String component16() {
        return this.sourceLinkType;
    }

    public final String component17() {
        return this.sourceLink;
    }

    public final String component18() {
        return this.screenshot;
    }

    public final String component19() {
        return this.locations;
    }

    public final String component2() {
        return this.entityId;
    }

    public final String component20() {
        return this.summary;
    }

    public final String component21() {
        return this.fullContent;
    }

    public final String component22() {
        return this.key1;
    }

    public final String component23() {
        return this.key2;
    }

    public final String component24() {
        return this.key3;
    }

    public final String component25() {
        return this.key4;
    }

    public final String component26() {
        return this.key5;
    }

    public final String component27() {
        return this.keyword1;
    }

    public final String component28() {
        return this.keyword2;
    }

    public final String component29() {
        return this.keyword3;
    }

    public final long component3() {
        return this.createTime;
    }

    public final String component30() {
        return this.keyword4;
    }

    public final String component31() {
        return this.keyword5;
    }

    public final String component32() {
        return this.keyword6;
    }

    public final String component33() {
        return this.semantic1;
    }

    public final String component34() {
        return this.semantic2;
    }

    public final String component35() {
        return this.keywordAndSemantic1;
    }

    public final String component36() {
        return this.keywordAndSemantic2;
    }

    public final String component37() {
        return this.sourceText;
    }

    public final String component38() {
        return this.sourcePackageName;
    }

    public final String component39() {
        return this.sourceAppName;
    }

    public final long component4() {
        return this.modifyTime;
    }

    public final String component40() {
        return this.logId;
    }

    public final String component41() {
        return this.sourceQuery;
    }

    public final String component42() {
        return this.detail;
    }

    public final int component43() {
        return this.detailStatus;
    }

    public final String component44() {
        return this.contentWithTime;
    }

    public final boolean component45() {
        return this.userEdit;
    }

    public final int component5() {
        return this.type;
    }

    public final long component6() {
        return this.timestamp;
    }

    public final String component7() {
        return this.packageName;
    }

    public final int component8() {
        return this.hashCodeValue;
    }

    public final String component9() {
        return this.uuid;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        MemoryEntity r0 = com.obric.memorydata.database.entity.memoryindex.m.a().toMemoryEntity(this);
        if (r0 != null) goto L5;
    L9:
        Object r1 = ZeusTransformUtils.preCheckCast(r0, AppEntity.class, "com.obric.memorydata.plugin");
    L8:
        return (AppEntity) r1;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, OrderMovieTicketMemoryEntity.class) == false) goto L9;
        String r14 = null;
        OrderTicketMemoryEntity r2 = new OrderTicketMemoryEntity(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getId(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getCreateTime(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getLastModifiedTime(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getProductType(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieName(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieDate(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getStartTime(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getEndTime(), r14, ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieTheaterName(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieTheaterAddress(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getMovieHallNumber(), ((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getSeatNumber(), 256, null);
        r2.setSourceLinkType(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getSourceLinkType());
        r2.setSourceLink(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getSourceLink());
        r2.setUuid(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getUuid());
        r2.setLogId(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getLogId());
        r2.setSourceQuery(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getSourceQuery());
        r2.setDetail(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getDetail());
        r2.setDetailStatus(((OrderMovieTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r0, OrderMovieTicketMemoryEntity.class, "com.obric.memorydata.plugin")).getDetailStatus());
        r1 = ZeusTransformUtils.preCheckCast(r2, AppEntity.class, "com.obric.memorydata.plugin");
        goto L8
    }

    @Override // com.obric.memorydata.database.entity.d
    public b convertToContentTimeEntity(String r21, ExtractTime r22) {
        Intrinsics.checkNotNullParameter(r21, "column");
        Intrinsics.checkNotNullParameter(r22, "extractTime");
        return (b) ZeusTransformUtils.preCheckCast(new co(0, getId(), r21, r22.getStartTimestamp(), r22.getEndTimestamp(), r22.getStartDateTimestamp(), r22.getEndDateTimestamp(), r22.getDeltaDay(), r22.getDeltaMonth(), r22.getDeltaYear(), 1, null), b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public /* synthetic */ AbstractFakeAppEntity convertToFakeAppEntity() {
        return (AbstractFakeAppEntity) ZeusTransformUtils.preCheckCast(convertToFakeAppEntity(), AbstractFakeAppEntity.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public FakeMemoryAppEntity convertToFakeAppEntity() {
        return new FakeMemoryAppEntity(this);
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return (c) ZeusTransformUtils.preCheckCast(new gl(0, this, 1, null), c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new cq(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final RawMemoryEntity copy(long r52, String r54, long r55, long r57, int r59, long r60, String r62, int r63, String r64, int r65, int r66, Long r67, Long r68, Long r69, Long r70, String r71, String r72, String r73, String r74, String r75, String r76, String r77, String r78, String r79, String r80, String r81, String r82, String r83, String r84, String r85, String r86, String r87, String r88, String r89, String r90, String r91, String r92, String r93, String r94, String r95, String r96, String r97, int r98, String r99, boolean r100) {
        Intrinsics.checkNotNullParameter(r54, "entityId");
        Intrinsics.checkNotNullParameter(r62, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return new RawMemoryEntity(r52, r54, r55, r57, r59, r60, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, RawMemoryEntity.class) == true) goto L8;
        return false;
    L8:
        RawMemoryEntity r10 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r9, RawMemoryEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityId, r10.entityId) == true) goto L15;
        return false;
    L15:
        if (this.createTime == r10.createTime) goto L18;
        return false;
    L18:
        if (this.modifyTime == r10.modifyTime) goto L21;
        return false;
    L21:
        if (this.type == r10.type) goto L24;
        return false;
    L24:
        if (this.timestamp == r10.timestamp) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L30;
        return false;
    L30:
        if (this.hashCodeValue == r10.hashCodeValue) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.uuid, r10.uuid) == true) goto L36;
        return false;
    L36:
        if (this.memoryType == r10.memoryType) goto L39;
        return false;
    L39:
        if (this.productType == r10.productType) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.startDate, r10.startDate) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.startTime, r10.startTime) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.endDate, r10.endDate) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.endTime, r10.endTime) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.sourceLinkType, r10.sourceLinkType) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.sourceLink, r10.sourceLink) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.screenshot, r10.screenshot) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.locations, r10.locations) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.summary, r10.summary) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.fullContent, r10.fullContent) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.key1, r10.key1) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.key2, r10.key2) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.key3, r10.key3) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.key4, r10.key4) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.key5, r10.key5) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.keyword1, r10.keyword1) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.keyword2, r10.keyword2) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.keyword3, r10.keyword3) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.keyword4, r10.keyword4) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.keyword5, r10.keyword5) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.keyword6, r10.keyword6) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.semantic1, r10.semantic1) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.semantic2, r10.semantic2) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.keywordAndSemantic1, r10.keywordAndSemantic1) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.keywordAndSemantic2, r10.keywordAndSemantic2) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.sourceText, r10.sourceText) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.sourcePackageName, r10.sourcePackageName) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.sourceAppName, r10.sourceAppName) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.sourceQuery, r10.sourceQuery) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.detail, r10.detail) == true) goto L135;
        return false;
    L135:
        if (this.detailStatus == r10.detailStatus) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.contentWithTime, r10.contentWithTime) == true) goto L141;
        return false;
    L141:
        if (this.userEdit == r10.userEdit) goto L143;
        return false;
    L143:
        return true;
    }

    public final String getContentWithTime() {
        return this.contentWithTime;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.createTime;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final int getDetailStatus() {
        return this.detailStatus;
    }

    public final Long getEndDate() {
        return this.endDate;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.entityId;
    }

    public final String getFullContent() {
        return this.fullContent;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.hashCodeValue;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.id;
    }

    public final String getKey1() {
        return this.key1;
    }

    public final String getKey2() {
        return this.key2;
    }

    public final String getKey3() {
        return this.key3;
    }

    public final String getKey4() {
        return this.key4;
    }

    public final String getKey5() {
        return this.key5;
    }

    public final String getKeyword1() {
        return this.keyword1;
    }

    public final String getKeyword2() {
        return this.keyword2;
    }

    public final String getKeyword3() {
        return this.keyword3;
    }

    public final String getKeyword4() {
        return this.keyword4;
    }

    public final String getKeyword5() {
        return this.keyword5;
    }

    public final String getKeyword6() {
        return this.keyword6;
    }

    public final String getKeywordAndSemantic1() {
        return this.keywordAndSemantic1;
    }

    public final String getKeywordAndSemantic2() {
        return this.keywordAndSemantic2;
    }

    public final String getLocations() {
        return this.locations;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final int getMemoryType() {
        return this.memoryType;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.modifyTime;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.packageName;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final String getScreenshot() {
        return this.screenshot;
    }

    public final String getSemantic1() {
        return this.semantic1;
    }

    public final String getSemantic2() {
        return this.semantic2;
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final String getSourceLink() {
        return this.sourceLink;
    }

    public final String getSourceLinkType() {
        return this.sourceLinkType;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final String getSourceQuery() {
        return this.sourceQuery;
    }

    public final String getSourceText() {
        return this.sourceText;
    }

    public final Long getStartDate() {
        return this.startDate;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final String getSummary() {
        return this.summary;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.type;
    }

    public final boolean getUserEdit() {
        return this.userEdit;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.id) * 31) + this.entityId.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.modifyTime)) * 31) + Integer.hashCode(this.type)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.packageName.hashCode()) * 31) + Integer.hashCode(this.hashCodeValue)) * 31;
        String r1 = this.uuid;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + Integer.hashCode(this.memoryType)) * 31) + Integer.hashCode(this.productType)) * 31;
        Long r5 = this.startDate;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.startTime;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.endDate;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Long r14 = this.endTime;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.sourceLinkType;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.sourceLink;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.screenshot;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.locations;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.summary;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.fullContent;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        String r35 = this.key1;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        String r38 = this.key2;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        String r41 = this.key3;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        String r44 = this.key4;
        if (r44 != null) goto L61;
        int r45 = 0;
    L62:
        int r46 = (r43 + r45) * 31;
        String r47 = this.key5;
        if (r47 != null) goto L65;
        int r48 = 0;
    L66:
        int r49 = (r46 + r48) * 31;
        String r50 = this.keyword1;
        if (r50 != null) goto L69;
        int r51 = 0;
    L70:
        int r52 = (r49 + r51) * 31;
        String r53 = this.keyword2;
        if (r53 != null) goto L73;
        int r54 = 0;
    L74:
        int r55 = (r52 + r54) * 31;
        String r56 = this.keyword3;
        if (r56 != null) goto L77;
        int r57 = 0;
    L78:
        int r58 = (r55 + r57) * 31;
        String r59 = this.keyword4;
        if (r59 != null) goto L81;
        int r60 = 0;
    L82:
        int r61 = (r58 + r60) * 31;
        String r62 = this.keyword5;
        if (r62 != null) goto L85;
        int r63 = 0;
    L86:
        int r64 = (r61 + r63) * 31;
        String r65 = this.keyword6;
        if (r65 != null) goto L89;
        int r66 = 0;
    L90:
        int r67 = (r64 + r66) * 31;
        String r68 = this.semantic1;
        if (r68 != null) goto L93;
        int r69 = 0;
    L94:
        int r70 = (r67 + r69) * 31;
        String r71 = this.semantic2;
        if (r71 != null) goto L97;
        int r72 = 0;
    L98:
        int r73 = (r70 + r72) * 31;
        String r74 = this.keywordAndSemantic1;
        if (r74 != null) goto L101;
        int r75 = 0;
    L102:
        int r76 = (r73 + r75) * 31;
        String r77 = this.keywordAndSemantic2;
        if (r77 != null) goto L105;
        int r78 = 0;
    L106:
        int r79 = (r76 + r78) * 31;
        String r80 = this.sourceText;
        if (r80 != null) goto L109;
        int r81 = 0;
    L110:
        int r82 = (r79 + r81) * 31;
        String r83 = this.sourcePackageName;
        if (r83 != null) goto L113;
        int r84 = 0;
    L114:
        int r85 = (r82 + r84) * 31;
        String r86 = this.sourceAppName;
        if (r86 != null) goto L117;
        int r87 = 0;
    L118:
        int r88 = (r85 + r87) * 31;
        String r89 = this.logId;
        if (r89 != null) goto L121;
        int r90 = 0;
    L122:
        int r91 = (r88 + r90) * 31;
        String r92 = this.sourceQuery;
        if (r92 != null) goto L125;
        int r93 = 0;
    L126:
        int r94 = (r91 + r93) * 31;
        String r95 = this.detail;
        if (r95 != null) goto L129;
        int r96 = 0;
    L130:
        int r97 = (((r94 + r96) * 31) + Integer.hashCode(this.detailStatus)) * 31;
        String r98 = this.contentWithTime;
        if (r98 == null) goto L135;
        r2 = r98.hashCode();
    L135:
        return ((r97 + r2) * 31) + Boolean.hashCode(this.userEdit);
    L129:
        r96 = r95.hashCode();
        goto L130
    L125:
        r93 = r92.hashCode();
        goto L126
    L121:
        r90 = r89.hashCode();
        goto L122
    L117:
        r87 = r86.hashCode();
        goto L118
    L113:
        r84 = r83.hashCode();
        goto L114
    L109:
        r81 = r80.hashCode();
        goto L110
    L105:
        r78 = r77.hashCode();
        goto L106
    L101:
        r75 = r74.hashCode();
        goto L102
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

    public final void setContentWithTime(String r1) {
        this.contentWithTime = r1;
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public final void setDetail(String r1) {
        this.detail = r1;
    }

    public final void setDetailStatus(int r1) {
        this.detailStatus = r1;
    }

    public final void setEndDate(Long r1) {
        this.endDate = r1;
    }

    public final void setEndTime(Long r1) {
        this.endTime = r1;
    }

    public void setEntityId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entityId = r2;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.id = r1;
    }

    public final void setKey1(String r1) {
        this.key1 = r1;
    }

    public final void setKey2(String r1) {
        this.key2 = r1;
    }

    public final void setKey3(String r1) {
        this.key3 = r1;
    }

    public final void setKey4(String r1) {
        this.key4 = r1;
    }

    public final void setKey5(String r1) {
        this.key5 = r1;
    }

    public final void setKeyword1(String r1) {
        this.keyword1 = r1;
    }

    public final void setKeyword2(String r1) {
        this.keyword2 = r1;
    }

    public final void setKeyword3(String r1) {
        this.keyword3 = r1;
    }

    public final void setKeyword4(String r1) {
        this.keyword4 = r1;
    }

    public final void setKeyword5(String r1) {
        this.keyword5 = r1;
    }

    public final void setKeyword6(String r1) {
        this.keyword6 = r1;
    }

    public final void setKeywordAndSemantic1(String r1) {
        this.keywordAndSemantic1 = r1;
    }

    public final void setKeywordAndSemantic2(String r1) {
        this.keywordAndSemantic2 = r1;
    }

    public final void setLocations(String r1) {
        this.locations = r1;
    }

    public final void setLogId(String r1) {
        this.logId = r1;
    }

    public final void setMemoryType(int r1) {
        this.memoryType = r1;
    }

    public final void setScreenshot(String r1) {
        this.screenshot = r1;
    }

    public final void setSemantic1(String r1) {
        this.semantic1 = r1;
    }

    public final void setSemantic2(String r1) {
        this.semantic2 = r1;
    }

    public final void setSourceAppName(String r1) {
        this.sourceAppName = r1;
    }

    public final void setSourceLink(String r1) {
        this.sourceLink = r1;
    }

    public final void setSourceLinkType(String r1) {
        this.sourceLinkType = r1;
    }

    public final void setSourcePackageName(String r1) {
        this.sourcePackageName = r1;
    }

    public final void setSourceQuery(String r1) {
        this.sourceQuery = r1;
    }

    public final void setSourceText(String r1) {
        this.sourceText = r1;
    }

    public final void setStartDate(Long r1) {
        this.startDate = r1;
    }

    public final void setStartTime(Long r1) {
        this.startTime = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.timestamp = r1;
    }

    public final void setUserEdit(boolean r1) {
        this.userEdit = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.uuid = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawMemoryEntity(id=").append(this.id).append(", entityId=").append(this.entityId).append(", createTime=").append(this.createTime).append(", modifyTime=").append(this.modifyTime).append(", type=").append(this.type).append(", timestamp=").append(this.timestamp).append(", packageName=").append(this.packageName).append(", hashCodeValue=").append(this.hashCodeValue).append(", uuid=").append(this.uuid).append(", memoryType=").append(this.memoryType).append(", productType=").append(this.productType).append(", startDate=");
        r0.append(this.startDate).append(", startTime=").append(this.startTime).append(", endDate=").append(this.endDate).append(", endTime=").append(this.endTime).append(", sourceLinkType=").append(this.sourceLinkType).append(", sourceLink=").append(this.sourceLink).append(", screenshot=").append(this.screenshot).append(", locations=").append(this.locations).append(", summary=").append(this.summary).append(", fullContent=").append(this.fullContent).append(", key1=").append(this.key1).append(", key2=").append(this.key2);
        r0.append(", key3=").append(this.key3).append(", key4=").append(this.key4).append(", key5=").append(this.key5).append(", keyword1=").append(this.keyword1).append(", keyword2=").append(this.keyword2).append(", keyword3=").append(this.keyword3).append(", keyword4=").append(this.keyword4).append(", keyword5=").append(this.keyword5).append(", keyword6=").append(this.keyword6).append(", semantic1=").append(this.semantic1).append(", semantic2=").append(this.semantic2).append(", keywordAndSemantic1=");
        r0.append(this.keywordAndSemantic1).append(", keywordAndSemantic2=").append(this.keywordAndSemantic2).append(", sourceText=").append(this.sourceText).append(", sourcePackageName=").append(this.sourcePackageName).append(", sourceAppName=").append(this.sourceAppName).append(", logId=").append(this.logId).append(", sourceQuery=").append(this.sourceQuery).append(", detail=").append(this.detail).append(", detailStatus=").append(this.detailStatus).append(", contentWithTime=").append(this.contentWithTime).append(", userEdit=").append(this.userEdit).append(')');
        return r0.toString();
    }
}
