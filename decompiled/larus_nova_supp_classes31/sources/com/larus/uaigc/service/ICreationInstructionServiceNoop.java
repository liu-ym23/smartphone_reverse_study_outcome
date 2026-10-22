package com.larus.uaigc.service;

import android.content.Intent;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.instruction.m1;
import com.larus.uaigc.bean.chat.template.TemplateViewModel;
import com.larus.uaigc.createpage.CreationActivity;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u0083\u0001\u0010\u000e\u001a\u00020\u000f2Q\u0010\u0010\u001aM\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060!j\u0002`\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u0016H\u0016J(\u0010&\u001a\u00020\u001f2\n\u0010 \u001a\u00060!j\u0002`\"2\b\u0010'\u001a\u0004\u0018\u00010\u00162\b\u0010(\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\u001e\u0010,\u001a\u00020\u001f2\n\u0010 \u001a\u00060!j\u0002`\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016JN\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002:\u00101\u001a6\u0012\u0017\u0012\u001503j\u0002`4¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u000502H\u0016¨\u00066"}, d2 = {"Lcom/larus/uaigc/service/ICreationInstructionServiceNoop;", "Lcom/larus/uaigc/service/ICreationInstructionService;", "<init>", "()V", "tryDirectlyJumpImageTemplate", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "intent", "Landroid/content/Intent;", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportTemplateRecommendOpCounter", "templatePrimaryKey", "", "createImageTemplateListDialogFragment", "Landroidx/fragment/app/DialogFragment;", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "conversationId", "Landroid/net/Uri;", "localImagePath", "botId", "chatType", "recommendFrom", "cvsId", "createDigitalAvatarInstructionBizAdapter", "Lcom/larus/bmhome/instruction/biz/AbsInstructionBizAdapter;", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "instructionDependency", "Lcom/larus/bmhome/instruction/biz/IInstructionDependency;", "enterMethod", "createAiCreationInstructionBizAdapter", "previousPage", "currentPage", "getLyricsToSongCellInfoList", "", "Lcom/larus/bmhome/chat/cell/CellManager$CellInfo;", "createMusicInstructionBizAdapter", "createMusicTemplateListFragment", "Landroidx/fragment/app/Fragment;", "templateViewModel", "Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;", "templateChooseCallback", "Lkotlin/Function2;", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "Lcom/larus/bmhome/music/protocol/MusicGenTemplate;", "enterFrom", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationInstructionServiceNoop implements ICreationInstructionService {
    public ICreationInstructionServiceNoop() {
    }

    public final List<xc8.f.a> E() {
        return CollectionsKt.emptyList();
    }

    public final Fragment A(TemplateViewModel r1, wt8.z r2) {
        Intrinsics.checkNotNullParameter(r2, "templateChooseCallback");
        return new Fragment();
    }

    public final vp8.g C(BaseContentWidget r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "component");
        return new i(r1);
    }

    public final vp8.g F(BaseContentWidget r1, m1 r2) {
        Intrinsics.checkNotNullParameter(r1, "component");
        return new k(r1);
    }

    public final Object B(CreationActivity r1, Intent r2, Continuation r3) {
        return Unit.INSTANCE;
    }

    public final vp8.g D(BaseContentWidget r1, m1 r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "component");
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        return new j(r1);
    }

    public final DialogFragment z(Function3 r1, String r2, String r3, String r4) {
        return new DialogFragment();
    }
}
